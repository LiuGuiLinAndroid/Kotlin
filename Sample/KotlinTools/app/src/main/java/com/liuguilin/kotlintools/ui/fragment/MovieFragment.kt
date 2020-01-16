package com.liuguilin.kotlintools.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.liuguilin.kotlintools.R
import com.liuguilin.kotlintools.bean.MovieBean
import com.liuguilin.kotlintools.event.EventImpl
import com.liuguilin.kotlintools.event.MessageEvent
import com.liuguilin.kotlintools.http.RetrofitManager
import com.liuguilin.kotlintools.manager.X5Manager
import com.liuguilin.okhelper.utils.L
import kotlinx.android.synthetic.main.fragment_movie.*
import org.greenrobot.eventbus.EventBus
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * FileName: MovieFragment
 * Founder: LiuGuiLin
 * Profile:
 */
class MovieFragment : Fragment() {

    private val isOpen = true

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    private fun initView() {

        fab_home.setOnClickListener {
            EventBus.getDefault().post(MessageEvent(EventImpl.TYPE_BACK_HOME))
        }

        if (isOpen) {
            getMovie()
        }
    }

    private fun getMovie() {
        //调用Api
        RetrofitManager
            .getMovie()
            .enqueue(object : Callback<MovieBean> {
                override fun onFailure(call: Call<MovieBean>, t: Throwable) {
                    L.i("onFailure${t}")
                }

                override fun onResponse(call: Call<MovieBean>, response: Response<MovieBean>) {
                    if (response.isSuccessful) {
                        val bean = response.body()
                        bean?.let {
                            val h5Url = it.result.h5url
                            h5Url?.let { url ->
                                X5Manager.loadX5(url, mX5WebView, activity)
                            }
                        }
                    }
                }
            })
    }

    fun canBack(): Boolean {
        return mX5WebView.canGoBack()
    }

    fun back() {
        mX5WebView.goBack()
    }
}