package com.liuguilin.kotlintools.impl

import com.liuguilin.kotlintools.bean.*
import com.liuguilin.kotlintools.http.RetrofitManager
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * FileName: ApiService
 * Founder: LiuGuiLin
 * Profile: 对外的服务
 */
interface ApiService {

    //新闻
    @GET(RetrofitManager.NEWS_URL)
    fun getNews(@Query("type") type: String, @Query("key") key: String): Call<NewsBean>

    //电影
    @GET(RetrofitManager.MOVIE_URL)
    fun getMovie(@Query("key") key: String): Call<MovieBean>

    //根据城市获取天气
    @GET(RetrofitManager.WEATHER_URL)
    fun getWeather(@Query("city") city: String, @Query("key") key: String): Call<WeatherBean>

    //获取城市列表
    @GET(RetrofitManager.CITY_LIST_URL)
    fun getCityList(@Query("key") key: String): Call<CityListBean>

    //获取笑话
    @GET(RetrofitManager.JOKE_URL)
    fun getJoke(@Query("key") key: String): Call<JokeBean>
}