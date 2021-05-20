package com.kotlin.common.util

import android.util.Log
import com.kotlin.common.model.IBannerApi
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitManager {
    companion object {
        fun test() {
            val okHttpClient = OkHttpClient.Builder()
                    .callTimeout(5000, TimeUnit.SECONDS)
                    .writeTimeout(5000, TimeUnit.SECONDS)
                    .readTimeout(5000, TimeUnit.SECONDS)
                    .build()

            val retrofit = Retrofit.Builder()
                    .baseUrl("https://www.wanandroid.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build()

            retrofit.create(IBannerApi::class.java)
                    .getBanner()
                    .enqueue(object : Callback<Any> {
                        override fun onResponse(call: Call<Any>, response: Response<Any>) {
                            Log.i("RetrofitManager", "onResponse: ")
                        }

                        override fun onFailure(call: Call<Any>, t: Throwable) {
                            Log.i("RetrofitManager", "onFailure: ")
                        }

                    })

        }
    }
}