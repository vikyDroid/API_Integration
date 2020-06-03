package com.vikydroid.demo.network

import com.vikydroid.demo.model.AddressData
import com.vikydroid.demo.utils.AUTO_COMPLETE
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET(AUTO_COMPLETE)
    fun getAddresses(@Query("queryString") queryString: String, @Query("city") city: String): Observable<AddressData>
}