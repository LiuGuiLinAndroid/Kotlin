package com.liuguilin.kotlinweather

import android.annotation.SuppressLint
import android.content.Intent
import android.text.TextUtils
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.liuguilin.kotlinweather.adapter.WeatherListAdapter
import com.liuguilin.kotlinweather.base.BaseActivity
import com.liuguilin.kotlinweather.bean.CityInfoBean
import com.liuguilin.kotlinweather.net.NetManager
import com.liuguilin.kotlinweather.ui.SettingActivity
import com.liuguilin.kotlinweather.utils.L
import com.liuguilin.kotlinweather.utils.SpUtils
import com.liuguilin.kotlinweather.utils.WeatherIconUtils
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : BaseActivity(), SwipeRefreshLayout.OnRefreshListener {

    private var mWeatherAdapter: WeatherListAdapter? = null
    private var cityId: String? = ""

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun isShowBack(): Boolean {
        return false
    }

    override fun initView() {

        supportActionBar?.elevation = 0f

        cityId = intent.getStringExtra("city")

        if (TextUtils.isEmpty(cityId)) {
            cityId = SpUtils.instance.getString("city", "")
        }

        mWeatherAdapter = WeatherListAdapter(this)
        val lm = LinearLayoutManager(this)
        lm.orientation = RecyclerView.HORIZONTAL
        mWeatherView.layoutManager = lm
        mWeatherView.adapter = mWeatherAdapter

        mSwipeRefreshLayout.setOnRefreshListener(this)

        loadWeather(cityId)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        cityId = intent?.getStringExtra("city")
        loadWeather(cityId)
    }

    /**
     * 加载天气详情
     */
    private fun loadWeather(cityId: String?) {
        mSwipeRefreshLayout.isRefreshing = true
        NetManager.getCityInfo(cityId!!).enqueue(object : Callback<CityInfoBean> {
            override fun onFailure(call: Call<CityInfoBean>, t: Throwable) {
                L.i("加载失败 $t")
            }

            override fun onResponse(call: Call<CityInfoBean>, response: Response<CityInfoBean>) {
                L.i("加载成功")
                parsingWeatherInfo(response.body()?.result)
            }
        })
    }

    //解析天气数据
    @SuppressLint("SetTextI18n")
    private fun parsingWeatherInfo(result: CityInfoBean.ResultBean?) {
        result?.let {
            //设置城市
            supportActionBar?.title = it.city
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

            //更新下面列表
            mWeatherAdapter?.updateData(it.future)

            mSwipeRefreshLayout.isRefreshing = false
        }
    }

    override fun onRefresh() {
        if (mSwipeRefreshLayout.isRefreshing) {
            loadWeather(cityId)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_setting) {
            startActivity(Intent(this, SettingActivity::class.java))
        }
        return super.onOptionsItemSelected(item)
    }
}
