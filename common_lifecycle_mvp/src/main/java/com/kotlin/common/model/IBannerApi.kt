package com.kotlin.common.model

import retrofit2.Call
import retrofit2.http.GET

interface IBannerApi {

    @GET("banner/json")
    fun getBanner(): Call<Any>
}