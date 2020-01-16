package com.liuguilin.kotlintools.base

import android.app.Application
import com.liuguilin.kotlintools.BuildConfig
import com.liuguilin.okhelper.OkHelper
import com.liuguilin.okhelper.utils.L
import com.tencent.smtt.sdk.QbSdk


/**
 * FileName: BaseApp
 * Founder: LiuGuiLin
 * Profile:
 */
class BaseApp : Application() {

    override fun onCreate() {
        super.onCreate()

        OkHelper
            .getInstance()
            .initHelper(this)
            .setLogConfig("KotlinTools", BuildConfig.DEBUG)

        //init X5
        QbSdk.initX5Environment(this, object : QbSdk.PreInitCallback {
            override fun onCoreInitFinished() {
                L.i("X5加载成功")
            }

            override fun onViewInitFinished(b: Boolean) {
                L.i("视图加载成功$b")
            }
        })
    }
}