package com.vikydroid.demo.learning2

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.vikydroid.demo.R
import com.vikydroid.demo.databinding.ActivityLearningBinding
import com.vikydroid.demo.learning2.security.BioMetricActivity
import com.vikydroid.demo.learning2.service.ServiceActivity
import com.vikydroid.demo.learning2.viewmodel.LearningViewModel
import com.vikydroid.demo.ui.activity.MainActivity
import kotlinx.android.synthetic.main.activity_learning.*

class LearningActivity : AppCompatActivity() {
    lateinit var binding: ActivityLearningBinding
    lateinit var viewModel: LearningViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_learning)
        binding.lifecycleOwner = this
        viewModel = ViewModelProvider(this).get(LearningViewModel::class.java)
        binding.viewModel = viewModel

        setOnclickListeners()


        viewModel.data.observe(this,{
            if(it){
                tv_dummy.text = "TRUE"
            }else{
                tv_dummy.text = "FALSE"
            }
        })

        bt_biometric.setOnClickListener {
            viewModel.data.value?.let {
                viewModel.data.value = !it
            }
        }


    }

    private fun setOnclickListeners() {
        bt_main.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        bt_service.setOnClickListener {
            startActivity(Intent(this, ServiceActivity::class.java))
        }
        bt_biometric.setOnClickListener {
            startActivity(Intent(this, BioMetricActivity::class.java))
        }
    }
}