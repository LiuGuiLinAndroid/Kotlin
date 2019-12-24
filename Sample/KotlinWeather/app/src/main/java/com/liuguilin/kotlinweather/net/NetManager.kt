package com.liuguilin.kotlinweather.net

import com.liuguilin.kotlinweather.BuildConfig
import com.liuguilin.kotlinweather.bean.CityInfoBean
import com.liuguilin.kotlinweather.bean.CityListBean
import com.liuguilin.kotlinweather.impl.WeatherImpl
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * FileName: NetManager
 * Founder: LiuGuiLin
 * Profile:
 */
object NetManager {

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder().baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private val api: WeatherImpl by lazy {
        retrofit.create(WeatherImpl::class.java)
    }

    fun getCityList(): Call<CityListBean> {
        return api.getCityList(BuildConfig.WEATHER_KEY)
    }

    fun getCityInfo(city: String): Call<CityInfoBean> {
        return api.getCityInfo(BuildConfig.WEATHER_KEY, city)
    }
}