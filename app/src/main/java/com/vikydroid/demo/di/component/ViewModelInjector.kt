package com.vikydroid.demo.di.component

import com.vikydroid.demo.di.module.NetworkModule
import com.vikydroid.demo.viewmodel.MainVM
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface ViewModelInjector {

    fun inject(mainVM: MainVM)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector

        fun networkModule(networkModule: NetworkModule): Builder
    }
}