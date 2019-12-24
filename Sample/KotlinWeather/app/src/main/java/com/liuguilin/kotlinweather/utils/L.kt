package com.liuguilin.kotlinweather.utils

import android.util.Log
import com.liuguilin.kotlinweather.BuildConfig


/**
 * FileName: L
 * Founder: LiuGuiLin
 * Profile:
 */
object L {

    private val DEBUG: Boolean = true

     fun i(text: String) {
        if (DEBUG) {
            Log.i(BuildConfig.LOG_TAG, text)
        }
    }

    fun e(text: String) {
        if (DEBUG) {
            Log.e(BuildConfig.LOG_TAG, text)
        }
    }
}