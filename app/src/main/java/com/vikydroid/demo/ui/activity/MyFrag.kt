package com.vikydroid.demo.ui.activity

import android.os.Bundle
import androidx.fragment.app.Fragment

class MyFrag : Fragment(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as MainActivity).viewModel.address.observe(this, { it -> println(it)})
    }

    override fun setRetainInstance(retain: Boolean) {
        super.setRetainInstance(retain)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }


}