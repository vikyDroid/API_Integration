package com.vikydroid.demo.learning.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import com.vikydroid.demo.R
import kotlinx.android.synthetic.main.activity_job.*
import kotlinx.android.synthetic.main.activity_job.button
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import java.util.concurrent.CompletionException

class JobActivity : AppCompatActivity() {
    private lateinit var job: CompletableJob
    private val PROGRESS_MAX = 100
    private val PROGRESS_MIN = 0
    private val JOB_TIME = 4000 //ms

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_job)

        button.setOnClickListener {
            if (!::job.isInitialized) {
                initJob()
            }
            progress_bar.startJobOrCancel()
        }

    }

    private fun ProgressBar.startJobOrCancel() {
//        this.visibility = View.GONE
        if (this.progress > 0) {
            println("$job is already active. Cancelling...")
            resetJob()
        } else {
            button.text = "Cancel Job #1"
            CoroutineScope(IO + job).launch {
                println("Coroutine $this is activated with $job")
                for (i in PROGRESS_MIN..PROGRESS_MAX) {
                    delay((JOB_TIME / PROGRESS_MAX).toLong())
                    this@startJobOrCancel.progress = i
                }
                updateJobCompleteTv("Job Completed")
                job.cancel(CancellationException("Job done successfully"))
            }
        }
    }


    private fun resetJob() {
        if (job.isActive || job.isCompleted) {
            job.cancel(CancellationException("Resetting Job"))
        }
        initJob()
    }

    private fun updateJobCompleteTv(msg: String) {
        //try withContext(Main)
        GlobalScope.launch(Dispatchers.Main) {
            job_complete_text.text = msg
        }
    }

    private fun initJob() {
        button.text = "Start JOb #1"
        updateJobCompleteTv("")
        job = Job()
        job.invokeOnCompletion {
            it?.message.let {
                var msg = it
                if (msg.isNullOrBlank()) {
                    msg = "Unknown Job Cancellation error"
                }
                println("$job was cancelled. Reason: $msg")
                showToast(msg)
            }
        }
        progress_bar.max = PROGRESS_MAX
        progress_bar.progress = PROGRESS_MIN
    }

    private fun showToast(msg: String) {
        GlobalScope.launch(Dispatchers.Main) {
            Toast.makeText(this@JobActivity, msg, Toast.LENGTH_LONG).show()
        }
    }
}