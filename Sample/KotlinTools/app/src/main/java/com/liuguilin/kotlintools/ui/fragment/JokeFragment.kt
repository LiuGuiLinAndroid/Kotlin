package com.liuguilin.kotlintools.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.liuguilin.kotlintools.R
import com.liuguilin.kotlintools.bean.JokeBean
import com.liuguilin.kotlintools.http.RetrofitManager
import com.liuguilin.okhelper.base.BaseFragment
import com.liuguilin.okhelper.base.adapter.CommonAdapter
import com.liuguilin.okhelper.base.adapter.CommonViewHolder
import com.liuguilin.okhelper.utils.L
import kotlinx.android.synthetic.main.fragment_joke.*
import kotlinx.android.synthetic.main.layout_joke_item.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList


/**
 * FileName: JokeFragment
 * Founder: LiuGuiLin
 * Profile:
 */
class JokeFragment : BaseFragment() {

    private var jockAdapter: CommonAdapter<String>? = null

    private var list = ArrayList<String>()

    override fun getLayoutId(): Int {
        return R.layout.fragment_joke
    }

    override fun initView(view: View?) {

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mJockView.layoutManager = LinearLayoutManager(activity)
        mJockView.addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.VERTICAL))
        jockAdapter = CommonAdapter(list, object : CommonAdapter.OnBindDataListener<String> {
            override fun getLayoutId(type: Int): Int {
                return R.layout.layout_joke_item
            }

            override fun onBindViewHolder(
                model: String?,
                viewHolder: CommonViewHolder?,
                type: Int,
                position: Int
            ) {
                viewHolder?.itemView?.tv_joke?.text = model
            }
        })
        mJockView.adapter = jockAdapter

        getJoke()
    }

    private fun getJoke() {
        RetrofitManager
            .getJoke()
            .enqueue(object : Callback<JokeBean> {
                override fun onFailure(call: Call<JokeBean>, t: Throwable) {
                    L.i("onFailure${t}")
                }

                override fun onResponse(call: Call<JokeBean>, response: Response<JokeBean>) {
                    if (response.isSuccessful) {
                        val bean = response.body()
                        bean?.result?.forEach {
                            list.add(it.content)
                        }
                        jockAdapter?.notifyDataSetChanged()
                    }
                }

            })
    }
}