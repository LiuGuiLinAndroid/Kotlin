package com.liuguilin.kotlinweather.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.hardware.camera2.params.OisSample
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.liuguilin.kotlinweather.R
import com.liuguilin.kotlinweather.bean.CityListBean
import com.liuguilin.kotlinweather.utils.L
import kotlinx.android.synthetic.main.layout_city_select_item.view.*


/**
 * FileName: CitySelectAdapter
 * Founder: LiuGuiLin
 * Profile:
 */
class CitySelectAdapter(
    private val mContext: Context
) : RecyclerView.Adapter<CitySelectAdapter.ViewHolder>() {

    private var mList: List<CityListBean.ResultBean>? = null

    fun updateData(mList: List<CityListBean.ResultBean>) {
        this.mList = mList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(View.inflate(mContext, R.layout.layout_city_select_item, null))
    }

    override fun getItemCount(): Int {
        return mList?.size ?: 0
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val bean: CityListBean.ResultBean = mList!![position]
        holder.itemView.mCityText.setTextColor(Color.BLACK)
        holder.itemView.mCityText.text =
            "${bean.province}${mContext.getString(R.string.tv_province)}" +
                    "${bean.city}${mContext.getString(R.string.tv_city)}" +
                    "${bean.district}${mContext.getString(R.string.tv_district)}"
        holder.itemView.setOnClickListener {
            listener!!(bean)
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private var listener: ((bean: CityListBean.ResultBean) -> Unit)? = null

    fun setOnItemClickListener(listener: (bean: CityListBean.ResultBean) -> Unit) {
        this.listener = listener
    }
}