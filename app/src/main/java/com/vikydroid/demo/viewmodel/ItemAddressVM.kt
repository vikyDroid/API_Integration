package com.vikydroid.demo.viewmodel

import android.view.View
import androidx.lifecycle.MutableLiveData
import com.vikydroid.demo.base.BaseViewModel
import com.vikydroid.demo.model.Address

class ItemAddressVM : BaseViewModel() {

    val address = MutableLiveData<Address>()
    val visCity = MutableLiveData(View.GONE)

    fun setAddress(address: Address?) {
        this.address.value = address
        this.visCity.value = if (address?.city.isNullOrBlank()) View.GONE else View.VISIBLE
    }
}