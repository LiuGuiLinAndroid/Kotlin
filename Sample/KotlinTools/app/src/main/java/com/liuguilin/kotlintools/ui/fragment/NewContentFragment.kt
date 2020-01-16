package com.liuguilin.kotlintools.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.liuguilin.kotlintools.R
import com.liuguilin.kotlintools.bean.NewsBean
import com.liuguilin.kotlintools.http.RetrofitManager
import com.liuguilin.kotlintools.ui.activity.WebViewActivity
import com.liuguilin.okhelper.base.adapter.CommonAdapter
import com.liuguilin.okhelper.base.adapter.CommonViewHolder
import com.liuguilin.okhelper.utils.L
import kotlinx.android.synthetic.main.fragment_news_contentt.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * FileName: NewContentFragment
 * Founder: LiuGuiLin
 * Profile:
 */
class NewContentFragment : Fragment() {

    private val isOpen = true
    private var newsAdapter: CommonAdapter<NewsBean.ResultBean.DataBean>? = null
    private val mList = ArrayList<NewsBean.ResultBean.DataBean>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_news_contentt, null)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initView()

        val title = arguments?.getString("title")
        title?.let {
            if (isOpen) {
                getNews(it)
            }
        }
    }

    private fun initView() {
        newsAdapter = CommonAdapter(
            mList,
            object : CommonAdapter.OnBindDataListener<NewsBean.ResultBean.DataBean> {
                override fun getLayoutId(type: Int): Int {
                    return R.layout.layout_news_item
                }

                override fun onBindViewHolder(
                    model: NewsBean.ResultBean.DataBean?,
                    viewHolder: CommonViewHolder?,
                    type: Int,
                    position: Int
                ) {
                    viewHolder?.let {
                        model?.let { dataBean ->
                            it.setText(R.id.tv_title, dataBean.title)
                            it.setText(R.id.tv_author, dataBean.author_name)
                            it.setText(R.id.tv_date, dataBean.date)

                            dataBean.thumbnail_pic_s?.let {
                                viewHolder.getView<ImageView>(R.id.iv1).visibility = View.VISIBLE
                                loadImg(it,viewHolder.getView(R.id.iv1))
                            }

                            dataBean.thumbnail_pic_s02?.let {
                                viewHolder.getView<ImageView>(R.id.iv2).visibility = View.VISIBLE
                                loadImg(it,viewHolder.getView(R.id.iv2))
                            }

                            dataBean.thumbnail_pic_s03?.let {
                                viewHolder.getView<ImageView>(R.id.iv3).visibility = View.VISIBLE
                                loadImg(it,viewHolder.getView(R.id.iv3))
                            }

                            it.itemView.setOnClickListener {
                                //拿到url跳转到腾讯X5内核
                                val intent = Intent(activity, WebViewActivity::class.java)
                                intent.putExtra("url", dataBean.url)
                                startActivity(intent)
                            }
                        }
                    }
                }
            })
        mNewsView.layoutManager = LinearLayoutManager(activity)
        mNewsView.addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.VERTICAL))
        mNewsView.adapter = newsAdapter
    }

    private fun getNews(type: String) {
        RetrofitManager
            .getNews(type)
            .enqueue(object : Callback<NewsBean> {
                override fun onFailure(call: Call<NewsBean>, t: Throwable) {
                    L.i("onFailure${t}")
                }

                override fun onResponse(call: Call<NewsBean>, response: Response<NewsBean>) {
                    if (response.isSuccessful) {
                        val bean = response.body()
                        bean?.let {
                            mList.addAll(it.result.data)
                            newsAdapter?.notifyDataSetChanged()
                        }
                    }
                }
            })
    }

    //加载图片
    fun loadImg(url: String, view: ImageView) {
        Glide
            .with(activity!!)
            .load(url)
            .centerCrop()
            .into(view)
    }
}