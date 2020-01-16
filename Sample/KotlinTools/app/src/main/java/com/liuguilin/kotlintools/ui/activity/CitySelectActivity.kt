package com.liuguilin.kotlintools.ui.activity

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.liuguilin.kotlintools.R
import com.liuguilin.kotlintools.bean.CityListBean
import com.liuguilin.kotlintools.http.RetrofitManager
import com.liuguilin.okhelper.base.BaseActivity
import com.liuguilin.okhelper.base.adapter.CommonAdapter
import com.liuguilin.okhelper.base.adapter.CommonViewHolder
import com.liuguilin.okhelper.utils.L
import kotlinx.android.synthetic.main.activity_city_select.*
import kotlinx.android.synthetic.main.layout_city_select_item.*
import kotlinx.android.synthetic.main.layout_city_select_item.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * FileName: CitySelectActivity
 * Founder: LiuGuiLin
 * Profile:
 */

class CitySelectActivity : BaseActivity() {

    private var cityAdapter: CommonAdapter<CityListBean.ResultBean>? = null
    private var list = ArrayList<CityListBean.ResultBean>()

    private var listCity = ArrayList<String>()

    override fun getLayoutId(): Int {
        return R.layout.activity_city_select
    }

    override fun isShowBack(): Boolean {
        return true
    }

    override fun initView(savedInstanceState: Bundle?) {

        supportActionBar?.title = "选择城市"

        cityAdapter =
            CommonAdapter(list, object : CommonAdapter.OnBindDataListener<CityListBean.ResultBean> {
                override fun getLayoutId(type: Int): Int {
                    return R.layout.layout_city_select_item
                }

                @SuppressLint("SetTextI18n")
                override fun onBindViewHolder(
                    model: CityListBean.ResultBean?,
                    viewHolder: CommonViewHolder?,
                    type: Int,
                    position: Int
                ) {
                    viewHolder?.let {
                        it.itemView.mCityText.setTextColor(Color.BLACK)
                        model?.let { bean ->
                            it.itemView.mCityText.text =
                                "${bean.province}${getString(R.string.tv_province)}" +
                                        "${bean.city}${getString(R.string.tv_city)}" +
                                        "${bean.district}${getString(R.string.tv_district)}"

                            it.itemView.setOnClickListener {
                                val intent = Intent()
                                intent.putExtra("city", bean.city)
                                setResult(Activity.RESULT_OK, intent)
                                finish()
                            }
                        }

                    }

                }

            })

        mCityView.layoutManager = LinearLayoutManager(this)
        mCityView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        mCityView.adapter = cityAdapter

        mCityView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                val lm = recyclerView.layoutManager
                //获取第一个可见的Item
                if (lm is LinearLayoutManager) {
                    val firstIndex = lm.findFirstVisibleItemPosition()
                    val province = list[firstIndex].province
                    mCitySelectView.setItemCity(province)
                }
            }
        })

        mCitySelectView.setOnMoveItemListener {
            mShowCity.text = it
            findScrollIndex(it)
        }

        mCitySelectView.setShowView(mShowCity)

        getCityList()
    }

    //根据城市名查找滚动的下标
    private fun findScrollIndex(city: String) {
        var scrollIndex = 0
        list.let {
            for ((k, v) in it.withIndex()) {
                if (city == v.province) {
                    scrollIndex = k
                    return@let
                }
            }
        }
        mCityView.scrollToPosition(scrollIndex)
    }

    private fun getCityList() {
        RetrofitManager.getCityList().enqueue(object : Callback<CityListBean> {
            override fun onFailure(call: Call<CityListBean>, t: Throwable) {
                L.i("onFailure${t}")
            }

            override fun onResponse(call: Call<CityListBean>, response: Response<CityListBean>) {
                if (response.isSuccessful) {
                    val bean = response.body()
                    bean?.result?.forEach {
                        list.add(it)
                        buildCity(it.province)
                    }
                    mCitySelectView.setCity(listCity)
                    cityAdapter?.notifyDataSetChanged()
                }
            }

        })
    }


    //过滤城市，去掉重复
    private fun buildCity(city: String?) {
        if (!listCity.contains(city)) {
            listCity.add(city!!)
        }
    }
}