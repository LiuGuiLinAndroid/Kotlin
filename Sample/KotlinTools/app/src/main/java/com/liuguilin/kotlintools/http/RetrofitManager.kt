package com.liuguilin.kotlintools.http

import com.liuguilin.kotlintools.bean.*
import com.liuguilin.kotlintools.impl.ApiService
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * FileName: RetrofitManager
 * Founder: LiuGuiLin
 * Profile: 网络请求的封装
 */
object RetrofitManager {

    private const val BASE_URL = "http://v.juhe.cn/"

    private const val WEATHER_BASE_URL = "http://apis.juhe.cn/"

    //新闻
    const val NEWS_URL = "toutiao/index"
    //新闻的key
    private const val NEWS_KEY = "fe06d421e616b5deda176b5ef1e7f6df"

    //电影
    const val MOVIE_URL = "wepiao/query"
    //电影的key
    private const val MOVIE_KEY = "1b761c8592429978d8d9ea1245bc83aa"

    //根据城市获取天气
    const val WEATHER_URL = "simpleWeather/query"
    //天气查询的Key
    private const val WEATHER_KEY = "4ea58de8a7573377cec0046f5e2469d5"
    //城市列表
    const val CITY_LIST_URL = "simpleWeather/cityList"

    //笑话
    const val JOKE_URL = "joke/randJoke.php"
    //笑话key
    private const val JOCK_KEY = "56e5f85c150ebd54461ae4fb7c6705ec"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private val api: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

    private val retrofitWeather: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(WEATHER_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private val apiWeather: ApiService by lazy {
        retrofitWeather.create(ApiService::class.java)
    }


    //获取新闻数据
    fun getNews(type: String): Call<NewsBean> {
        return api.getNews(type, NEWS_KEY)
    }

    //获取电影
    fun getMovie(): Call<MovieBean> {
        return api.getMovie(MOVIE_KEY)
    }

    //根据城市获取天气
    fun getWeather(city: String): Call<WeatherBean> {
        return apiWeather.getWeather(city, WEATHER_KEY)
    }

    //获取城市列表
    fun getCityList(): Call<CityListBean> {
        return apiWeather.getCityList(WEATHER_KEY)
    }

    //获取笑话
    fun getJoke(): Call<JokeBean> {
        return api.getJoke(JOCK_KEY)
    }
}