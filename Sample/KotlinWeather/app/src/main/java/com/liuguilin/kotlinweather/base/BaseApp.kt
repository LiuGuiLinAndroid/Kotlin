package com.liuguilin.kotlinweather.base

import android.app.Application
import com.liuguilin.kotlinweather.utils.SpUtils


/**
 * FileName: BaseApp
 * Founder: LiuGuiLin
 * Profile:
 */
class BaseApp: Application() {

    override fun onCreate() {
        super.onCreate()
        SpUtils.instance.initSp(this)
    }

}