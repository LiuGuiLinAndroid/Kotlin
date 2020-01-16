package com.liuguilin.kotlintools.manager

import android.app.Activity
import com.liuguilin.okhelper.utils.L
import com.tencent.smtt.export.external.interfaces.WebResourceRequest
import com.tencent.smtt.sdk.WebSettings
import com.tencent.smtt.sdk.WebView
import com.tencent.smtt.sdk.WebViewClient


/**
 * FileName: X5Manager
 * Founder: LiuGuiLin
 * Profile:
 */
object X5Manager {

    fun loadX5(url:String,webView: WebView,activity:Activity?){
        val webSetting: WebSettings = webView.settings
        webSetting.allowFileAccess = true
        webSetting.layoutAlgorithm = WebSettings.LayoutAlgorithm.NARROW_COLUMNS
        webSetting.setSupportZoom(true)
        webSetting.builtInZoomControls = true
        webSetting.useWideViewPort = true
        webSetting.setSupportMultipleWindows(false)
        webSetting.setAppCacheEnabled(true)
        webSetting.domStorageEnabled = true
        webSetting.javaScriptEnabled = true
        webSetting.setGeolocationEnabled(true)
        webSetting.setAppCacheMaxSize(Long.MAX_VALUE)
        webSetting.setAppCachePath(activity?.getDir("appcache", 0)?.path)
        webSetting.databasePath = activity?.getDir("databases", 0)?.path
        webSetting.setGeolocationDatabasePath(activity?.getDir("geolocation", 0)?.path)
        webSetting.pluginState = WebSettings.PluginState.ON_DEMAND

        webView.webViewClient = MyWebViewClient()
        L.i("url:$url")
        webView.loadUrl(url)
    }

    class MyWebViewClient : WebViewClient() {
        override fun shouldOverrideUrlLoading(p0: WebView?, p1: WebResourceRequest?): Boolean {
            return false
        }

        override fun onPageFinished(p0: WebView?, p1: String?) {
            super.onPageFinished(p0, p1)
            L.i("加载成功")
        }
    }
}