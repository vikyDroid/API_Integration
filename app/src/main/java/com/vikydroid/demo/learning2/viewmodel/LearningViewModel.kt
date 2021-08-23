package com.vikydroid.demo.learning2.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LearningViewModel: ViewModel() {
    val data = MutableLiveData<Boolean>(true)
}