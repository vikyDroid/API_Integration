package com.vikydroid.demo.test

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.vikydroid.demo.R

class TestKotlinInActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = Intent(Intent.ACTION_SEND)
        val chooser = resources.getString(R.string.app_name).let {
            Intent.createChooser(intent, it)
        }
        startActivity(chooser)

    }


}