package com.vikydroid.demo.model

import com.google.gson.annotations.SerializedName

data class AddressData(
    @SerializedName("requestId")
    val requestId: String?,
    @SerializedName("data")
    val data: Data?
)