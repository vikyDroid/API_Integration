package com.vikydroid.demo.model

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("autoCompleteRequestString")
    val autoCompleteRequestString: String?,
    @SerializedName("focusWord")
    val focusWord: String?,
    @SerializedName("addressList")
    val addressList: List<Address>?
)