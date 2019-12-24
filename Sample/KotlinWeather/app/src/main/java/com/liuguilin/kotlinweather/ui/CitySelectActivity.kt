package com.liuguilin.kotlinweather.ui

import android.content.Intent
import android.view.MotionEvent
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.liuguilin.kotlinweather.MainActivity
import com.liuguilin.kotlinweather.R
import com.liuguilin.kotlinweather.adapter.CitySelectAdapter
import com.liuguilin.kotlinweather.base.BaseActivity
import com.liuguilin.kotlinweather.bean.CityListBean
import com.liuguilin.kotlinweather.net.NetManager
import com.liuguilin.kotlinweather.utils.L
import com.liuguilin.kotlinweather.utils.SpUtils
import kotlinx.android.synthetic.main.activity_city_select.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * FileName: CitySelectActivity
 * Founder: LiuGuiLin
 * Profile:
 */
class CitySelectActivity : BaseActivity() {

    //装载省级的列表
    private var provinceList: List<String>? = null
    //适配器
    private var mCityAdapter: CitySelectAdapter? = null

    override fun getLayoutId(): Int {
        return R.layout.activity_city_select
    }

    override fun isShowBack(): Boolean {
        return true
    }

    override fun initView() {

        supportActionBar?.title = getString(R.string.tv_select_city)

        mCityAdapter = CitySelectAdapter(this)
        mCityView.layoutManager = LinearLayoutManager(this)
        mCityView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        mCityView.adapter = mCityAdapter

        mCitySelectView.setShowView(mShowCity)

        mCityAdapter!!.setOnItemClickListener {
            SpUtils.instance.putString("city", it.id)
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("city", it.id)
            startActivity(intent)
            finish()
        }

        mCitySelectView.setOnMoveItemListener { city ->
            mShowCity.text = city
            findScrollIndex(city)
        }

        mCityView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                val lm = recyclerView.layoutManager
                if (lm is LinearLayoutManager) {
                    //屏幕可见的第一个Item
                    val firstIndex = lm.findFirstVisibleItemPosition()
                    //根据可见下标得到值
                    val city = provinceList!![firstIndex]
                    mCitySelectView.setItemCity(city)
                }
            }
        })

        loadCityList()
    }

    //根据城市名查找下标并且滚动
    private fun findScrollIndex(city: String) {
        var scrollIndex = 0
        provinceList?.let {
            //满足条件的第一个
            for ((k, v) in it.withIndex()) {
                if (city == v) {
                    scrollIndex = k
                    return@let
                }
            }
        }
        mCityView.scrollToPosition(scrollIndex)
    }

    private fun loadCityList() {
        NetManager.getCityList().enqueue(object : Callback<CityListBean> {
            override fun onFailure(call: Call<CityListBean>, t: Throwable) {
                L.i("加载失败")
            }

            override fun onResponse(call: Call<CityListBean>, response: Response<CityListBean>) {
                L.i("加载成功")
                response.body()?.result?.let { mCityAdapter?.updateData(it) }

                mCitySelectView.setCity(buildCity(response.body()?.result))
            }
        })
    }

    /**
     * 对城市列表进行过滤
     */
    private fun buildCity(result: List<CityListBean.ResultBean>?): MutableList<String> {
        //加载城市列表
        provinceList = result?.map {
            it.province
        }
        val list: MutableList<String> = ArrayList()
        //去除重复
        for (p in provinceList!!) {
            if (!list.contains(p)) {
                list.add(p)
            }
        }
        return list
    }
}