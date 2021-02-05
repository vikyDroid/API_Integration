package com.vikydroid.demo.ui.activity

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.vikydroid.demo.R
import com.vikydroid.demo.databinding.ActivityMainBinding
import com.vikydroid.demo.viewmodel.MainVM
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

 class MainActivity : AppCompatActivity(), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job + handler

    private lateinit var job: Job
    private val handler = CoroutineExceptionHandler { _, exception ->
        print("$exception handled")
    }

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainVM


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        job = Job()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.addressList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        viewModel = ViewModelProvider(this).get(MainVM::class.java)
        binding.viewModel = viewModel

        setUpObserver()

        launch { supervisorScope {

        } }


    }

    private fun setUpObserver() {
        viewModel.address.observe(this, Observer { if (!it.isNullOrBlank()) viewModel.callAddressListApi() })
        viewModel.city.observe(this, Observer { if (!it.isNullOrBlank()) viewModel.callAddressListApi() })
        viewModel.apiError.observe(this, Observer {
            Toast.makeText(this@MainActivity, it, Toast.LENGTH_SHORT).show()
        })
    }

    override fun onDestroy() {
        job.cancel()
        super.onDestroy()
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
    }
}
