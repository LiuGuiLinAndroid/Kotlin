package com.liuguilin.kotlinweather.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.liuguilin.kotlinweather.R
import com.liuguilin.kotlinweather.bean.CityInfoBean
import com.liuguilin.kotlinweather.bean.CityListBean
import com.liuguilin.kotlinweather.utils.WeatherIconUtils
import kotlinx.android.synthetic.main.layout_weather_item.view.*


/**
 * FileName: WeatherListAdapter
 * Founder: LiuGuiLin
 * Create Date: 2019/12/24 10:18
 * Email: lgl@szokl.com.cn
 * Profile:
 */
class WeatherListAdapter(
    private var mContext: Context
) : RecyclerView.Adapter<WeatherListAdapter.ViewHolder>() {

    private var mList = ArrayList<CityInfoBean.ResultBean.FutureBean>()

    fun updateData(mList: List<CityInfoBean.ResultBean.FutureBean>) {
        this.mList.clear()
        this.mList.addAll(mList)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(View.inflate(mContext, R.layout.layout_weather_item, null))
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val bean: CityInfoBean.ResultBean.FutureBean = mList[position]
        holder.itemView.ivIcon.setImageResource(WeatherIconUtils.getIcon(bean.wid.day))
        holder.itemView.mTemperature.text = bean.temperature
        holder.itemView.mWeather.text = bean.weather
        holder.itemView.mDate.text = bean.date
    }

}