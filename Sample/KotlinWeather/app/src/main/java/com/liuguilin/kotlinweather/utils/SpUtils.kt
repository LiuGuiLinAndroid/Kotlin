package com.liuguilin.kotlinweather.utils

import android.content.Context
import android.content.SharedPreferences


/**
 * FileName: SpUtils
 * Founder: LiuGuiLin
 * Profile:
 */
class SpUtils private constructor() {

    private var sp: SharedPreferences? = null
    private var edit: SharedPreferences.Editor? = null

    companion object {
        val instance: SpUtils by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) { SpUtils() }
    }

    fun initSp(mContext: Context) {
        sp = mContext.getSharedPreferences("config", Context.MODE_PRIVATE)
        edit = sp?.edit()
    }

    fun putString(key: String, value: String) {
        edit?.let {
            it.putString(key, value)
            it.commit()
        }
    }

    fun getString(key: String, defValue: String): String {
        return sp?.getString(key, defValue)!!
    }
}