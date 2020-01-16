package com.liuguilin.kotlintools.ui.activity

import android.os.Bundle
import com.liuguilin.kotlintools.R
import com.liuguilin.kotlintools.manager.X5Manager
import com.liuguilin.okhelper.base.BaseActivity
import kotlinx.android.synthetic.main.activity_webview.*


/**
 * FileName: WebViewActivity
 * Founder: LiuGuiLin
 * Profile:
 */
class WebViewActivity : BaseActivity() {

    override fun getLayoutId(): Int {
        return R.layout.activity_webview
    }

    override fun isShowBack(): Boolean {
        return true
    }

    override fun initView(savedInstanceState: Bundle?) {
        val url = intent.getStringExtra("url")
        url?.let {
            X5Manager.loadX5(it, mNewsWebView, this)
        }
    }
}