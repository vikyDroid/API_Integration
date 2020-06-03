package com.vikydroid.demo.base

import androidx.lifecycle.ViewModel
import com.vikydroid.demo.di.component.DaggerViewModelInjector
import com.vikydroid.demo.di.component.ViewModelInjector
import com.vikydroid.demo.di.module.NetworkModule
import com.vikydroid.demo.viewmodel.MainVM

abstract class BaseViewModel : ViewModel() {
    private val injector: ViewModelInjector =
        DaggerViewModelInjector.builder().networkModule(NetworkModule).build()

    init {
        inject()
    }

    private fun inject() {
        when (this) {
            is MainVM -> injector.inject(this)
        }
    }
}