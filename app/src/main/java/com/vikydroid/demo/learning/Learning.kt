package com.vikydroid.demo.learning

import android.content.Context
import android.os.AsyncTask
import android.os.Parcelable
import androidx.lifecycle.Observer
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import kotlinx.android.parcel.Parcelize
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import java.util.concurrent.Executor

@Parcelize
class Learning : Parcelable {


    init {

    }
    init {

    }
    init {

    }
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("asds")

//            val wm = AsyncTask()
//            val ex = Executor()
        }
    }

    suspend fun fetchAndShowUser() {
        /*val user = fetchLearning()
        showLearning(user)*/
        return withContext(IO) { /*getUser*/ }

//        val oneTimeWorkRequest: OneTimeWorkRequest = OneTimeWorkRequest.Builder(MyWorker::class).build()
//        WorkManager.getInstance(Context()).enqueue(oneTimeWorkRequest)
//
//        WorkManager.getInstance().getWorkInfoByIdLiveData(oneTimeWorkRequest.id).observe(this, Observer { println("Fsd") })
    }

    private fun showLearning(learning: Learning) {

    }

    private fun fetchLearning(): Learning {
        return Learning()
    }
}