package com.vikydroid.demo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import com.vikydroid.demo.base.BaseViewModel
import com.vikydroid.demo.model.AddressData
import com.vikydroid.demo.network.Api
import com.vikydroid.demo.ui.adapter.AddressAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainVM(private val savedStateHandle: SavedStateHandle) : BaseViewModel() {
    @Inject
    lateinit var api: Api
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
    val addressAdapter = AddressAdapter()
    val apiError = MutableLiveData<String>()
    val address = MutableLiveData("")
    val city = MutableLiveData("")

    fun callAddressListApi() {
        compositeDisposable.clear() //Cleared previous task so that only final result prevails
        compositeDisposable.add(
            api.getAddresses(address.value!!, city.value!!)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { result -> onSuccess(result) },
                    { error -> onFailure(error) })
        )
    }

    private fun onFailure(error: Throwable) {
        apiError.value = error.localizedMessage
        println(error.localizedMessage)
    }

    private fun onSuccess(addressData: AddressData?) {
        val addressList = addressData?.data?.addressList
        addressList?.let { addressAdapter.setList(it) }
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}