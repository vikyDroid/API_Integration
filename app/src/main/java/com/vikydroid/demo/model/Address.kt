package com.vikydroid.demo.model

import com.google.gson.annotations.SerializedName

data class Address(
    @SerializedName("id")
    val id: String?,
    @SerializedName("pinCode")
    val pinCode: String?,
    @SerializedName("city")
    val city: String?,
    @SerializedName("cityBoundaryBreached")
    val cityBoundaryBreached: String?,
    @SerializedName("pinCodeBoundaryBreached")
    val pinCodeBoundaryBreached: String?,
    @SerializedName("addressType")
    val addressType: String?,
    @SerializedName("addressString")
    val addressString: String?,
    @SerializedName("latitude")
    val latitude: String?,
    @SerializedName("longitude")
    val longitude: String?,
    @SerializedName("errorMargin")
    val errorMargin: String?
)