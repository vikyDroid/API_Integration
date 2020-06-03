package com.vikydroid.demo.ui.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.vikydroid.demo.R
import com.vikydroid.demo.databinding.ActivityMainBinding
import com.vikydroid.demo.viewmodel.MainVM

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.addressList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        viewModel = ViewModelProvider(this).get(MainVM::class.java)
        binding.viewModel = viewModel

        setUpObserver()
    }

    private fun setUpObserver() {
        viewModel.address.observe(this, Observer { if (!it.isNullOrBlank()) viewModel.callAddressListApi() })
        viewModel.city.observe(this, Observer { if (!it.isNullOrBlank()) viewModel.callAddressListApi() })
        viewModel.apiError.observe(this, Observer {
            Toast.makeText(this@MainActivity, it, Toast.LENGTH_SHORT).show()
        })
    }
}
