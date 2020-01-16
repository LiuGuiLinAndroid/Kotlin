package com.liuguilin.kotlintools.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.liuguilin.kotlintools.R
import com.liuguilin.kotlintools.bean.WeatherBean
import com.liuguilin.kotlintools.event.EventImpl
import com.liuguilin.kotlintools.event.MessageEvent
import com.liuguilin.kotlintools.http.RetrofitManager
import com.liuguilin.kotlintools.utils.WeatherIconUtils
import com.liuguilin.okhelper.base.BaseFragment
import com.liuguilin.okhelper.base.adapter.CommonAdapter
import com.liuguilin.okhelper.base.adapter.CommonViewHolder
import com.liuguilin.okhelper.utils.L
import kotlinx.android.synthetic.main.fragment_weather.*
import kotlinx.android.synthetic.main.layout_weather_item.view.*
import org.greenrobot.eventbus.EventBus
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * FileName: WeatherFragment
 * Founder: LiuGuiLin
 * Profile: 天气
 */
class WeatherFragment : BaseFragment() {

    private var city: String = "北京"

    private var mWeatherAdapter: CommonAdapter<WeatherBean.ResultBean.FutureBean>? = null
    private val list = ArrayList<WeatherBean.ResultBean.FutureBean>()

    override fun getLayoutId(): Int {
        return R.layout.fragment_weather
    }

    override fun initView(view: View?) {

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mWeatherAdapter = CommonAdapter(list,
            object : CommonAdapter.OnBindDataListener<WeatherBean.ResultBean.FutureBean> {
                override fun getLayoutId(type: Int): Int {
                    return R.layout.layout_weather_item
                }

                override fun onBindViewHolder(
                    model: WeatherBean.ResultBean.FutureBean?,
                    viewHolder: CommonViewHolder?,
                    type: Int,
                    position: Int
                ) {
                    //L.i("model:${model?.date}")
                    viewHolder?.let {
                        model?.let { m ->
                            it.itemView.ivIcon.setImageResource(WeatherIconUtils.getIcon(m.wid.day))
                            it.itemView.mTemperature.text = m.temperature
                            it.itemView.mWeather.text = m.weather
                            it.itemView.mDate.text = m.date
                        }
                    }
                }

            })
        val ll = LinearLayoutManager(activity)
        ll.orientation = LinearLayoutManager.HORIZONTAL
        mWeatherView.layoutManager = ll
        mWeatherView.adapter = mWeatherAdapter

        getWeather(city)
    }

    //加载天气
    private fun getWeather(city: String) {
        RetrofitManager
            .getWeather(city)
            .enqueue(object : Callback<WeatherBean> {
                override fun onFailure(call: Call<WeatherBean>, t: Throwable) {
                    L.i("onFailure${t}")
                }

                override fun onResponse(call: Call<WeatherBean>, response: Response<WeatherBean>) {
                    L.i("onResponse$response")
                    if (response.isSuccessful) {
                        val bean = response.body()
                        parsingWeatherInfo(bean?.result)
                    }
                }
            })
    }

    override fun onResume() {
        super.onResume()
        val event = MessageEvent(EventImpl.TYPE_WEATHER_TITLE)
        event.text = city
        EventBus.getDefault().post(event)
    }

    fun getCity(): String {
        return city
    }

    //解析天气数据
    @SuppressLint("SetTextI18n")
    private fun parsingWeatherInfo(result: WeatherBean.ResultBean?) {
        L.i("parsingWeatherInfo${result}")
        result?.let {
            //设置城市
            //supportActionBar?.title = it.city
            city = it.city
            val event = MessageEvent(EventImpl.TYPE_WEATHER_TITLE)
            event.text = it.city
            EventBus.getDefault().post(event)

            //设置天气
            mInfo.text = it.realtime.info
            //设置天气图标
            ivWid.setImageResource(WeatherIconUtils.getIcon(it.realtime.wid))
            //设置温度
            mTemperature.text = "${it.realtime.temperature}${getString(R.string.tv_temperature_a)}"
            //设置湿度
            mHumidity.text = "${getString(R.string.tv_humidity)}\n${it.realtime.humidity}"
            //设置风向
            mDirect.text = "${getString(R.string.tv_direct)}\n${it.realtime.direct}"
            //设置风级
            mPower.text = "${getString(R.string.tv_power)}\n${it.realtime.power}"
            //设置空气质量
            mAqi.text = "${getString(R.string.tv_aqi)}\n${it.realtime.aqi}"

            L.i("result:$it")

            list.addAll(result.future)
            //更新下面列表
            mWeatherAdapter?.notifyDataSetChanged()
        }
    }

    fun setCity(city: String?) {
        getWeather(city!!)
    }

}