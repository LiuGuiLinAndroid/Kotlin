package com.liuguilin.kotlinweather.ui

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.ViewPropertyAnimatorCompat
import androidx.core.view.ViewPropertyAnimatorListener
import com.liuguilin.kotlinweather.MainActivity
import com.liuguilin.kotlinweather.R
import com.liuguilin.kotlinweather.base.BaseActivity
import com.liuguilin.kotlinweather.utils.L
import com.liuguilin.kotlinweather.utils.SpUtils
import kotlinx.android.synthetic.main.activity_splash.*


/**
 * FileName: SplashActivity
 * Founder: LiuGuiLin
 * Profile:
 */
class SplashActivity : BaseActivity(), ViewPropertyAnimatorListener {

    override fun getLayoutId(): Int {
        return R.layout.activity_splash
    }

    override fun isShowBack(): Boolean {
        return false
    }

    override fun initView() {
        ViewCompat.animate(llSplash)
            .scaleX(0.8f)
            .scaleY(0.8f)
            .setDuration(1500)
            .setListener(this)
            .start()
    }

    override fun onAnimationEnd(view: View?) {
        val city: String = SpUtils.instance.getString("city", "")
        if (!TextUtils.isEmpty(city)) {
            startActivity(Intent(this, MainActivity::class.java))
        } else {
            startActivity(Intent(this, CitySelectActivity::class.java))
        }
        finish()
    }

    override fun onAnimationCancel(view: View?) {

    }

    override fun onAnimationStart(view: View?) {

    }


}