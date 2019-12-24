package com.liuguilin.kotlinweather.impl

import com.liuguilin.kotlinweather.bean.CityInfoBean
import com.liuguilin.kotlinweather.bean.CityListBean
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * FileName: WeatherImpl
 * Founder: LiuGuiLin
 * Profile:
 */
interface WeatherImpl {

    @GET("simpleWeather/cityList")
    fun getCityList(@Query("key") key: String): Call<CityListBean>

    @GET("simpleWeather/query")
    fun getCityInfo(@Query("key") key: String, @Query("city") city: String): Call<CityInfoBean>
}