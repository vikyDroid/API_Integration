package com.vikydroid.demo.learning.coroutines

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.vikydroid.demo.R
import com.vikydroid.demo.learning.singleton.MySingleton
import kotlinx.android.synthetic.main.activity_coroutines.*
import kotlinx.android.synthetic.main.activity_coroutines.button
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlin.system.measureTimeMillis

class CoroutinesActivity : AppCompatActivity() {
    private val RESULT_1: String = "Result 1"
    private val RESULT_2: String = "Result 2"
    private lateinit var parent: Job

    override fun onResume() {
        super.onResume()
        println("debug: onResume")
    }

    override fun onPause() {
        super.onPause()
        println("debug: onPause")
    }

    override fun onStart() {
        super.onStart()
        println("debug: onPause")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("debug: onDestroy")
    }

    override fun onStop() {
        super.onStop()
        println("debug: onStop")
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        println("debug: onConfigurationChanged")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        println("debug: onSaveInstanceState")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        println("debug: onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutines)

        println("debug: Singleton $MySingleton")
        println("debug: Singleton ${MySingleton.hashCode()}")


        callParentTaskToExecute()

        cancel_job.setOnClickListener {
            if (::parent.isInitialized) {
                parent.cancel()
            }
        }

        clear_text.setOnClickListener {
            text_view.text = "Text cleared"
        }
        button.setOnClickListener {
            CoroutineScope(IO).launch { fakeApiCall() }
        }

        button_async.setOnClickListener {
            CoroutineScope(IO).launch {
                val res1: Deferred<String> = async {
                    getDataFromApi1()
                }
                val res2: Deferred<String> = async {
                    getDataFromApi2()
                }
                setTextOnMainThread("Data : ${res1.await()}")
                setTextOnMainThread("Data : ${res2.await()}")
            }
        }

        button_async2.setOnClickListener {
            val executionTime = measureTimeMillis {
                CoroutineScope(IO).launch {
                    val res1 = async {
                        getDataFromApi1()
                    }.await()
                    val res2 = async {
                        println(res1)
                        getDataFromApi2()
                    }.await()
                    println(res2)
                }
            }
            println("debug: Total time elapsed $executionTime") // res2 wait for res1 to complete
        }
    }

    private fun callParentTaskToExecute() {
        val handler = CoroutineExceptionHandler { coroutineContext, throwable ->
            println("debug: Exception handled ${throwable.message}")
        }
        parent = CoroutineScope(IO).launch(handler) {
            supervisorScope {
                val child1 = launch {
                    callSomeDelay(1)
                }
                val child2 = launch {
                    callSomeDelay(2)
                }
                val child3 = launch {
                    callSomeDelay(3)
                }
            }
        }
        parent.invokeOnCompletion {
            if (it == null) {
                println("debug: Job successful")
            } else {
                println("debug: Error happened in parent or child jobs $it")
            }
        }
    }

    private suspend fun callSomeDelay(i: Int) {
        delay(i * 500L)
        if (i == 2) {
            throw Exception("value is 2")
        }
        println("debug: job no $i")
    }

    private suspend fun fakeApiCall() {
        val dataFromApi1 = getDataFromApi1()//wait
        setTextOnMainThread(dataFromApi1)

        val dataFromApi2 = getDataFromApi2()//wait
        setTextOnMainThread(dataFromApi2)
    }

    private suspend fun setTextOnMainThread(result: String) {
        withContext(Dispatchers.Main) {
            setNewText(result)
        }
    }

    private fun setNewText(result: String) {
        val newText = text_view.text.toString() + "\n$result"
        text_view.text = newText
    }

    private suspend fun getDataFromApi1(): String {
        delay(1000)
        logThread("getDataFromApi1")
        return RESULT_1
    }

    private suspend fun getDataFromApi2(): String {
        delay(1000)
        logThread("getDataFromApi2")
        return RESULT_2
    }

    private fun logThread(methodName: String) {
        println("$methodName : ${Thread.currentThread().name}")
    }
}