package com.liuguilin.kotlintools.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.ViewPropertyAnimatorListener
import com.liuguilin.kotlintools.MainActivity
import com.liuguilin.kotlintools.R
import com.liuguilin.okhelper.utils.L
import com.liuguilin.okhelper.utils.SpUtils
import kotlinx.android.synthetic.main.activity_index.*

/**
 * FileName: IndexActivity
 * Founder: LiuGuiLin
 * Profile: 启动页
 */
class IndexActivity : AppCompatActivity(), ViewPropertyAnimatorListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_index)

        initView()
    }

    private fun initView() {
        mTextView.text = getString(R.string.app_name)

        //动画
        ViewCompat.animate(mTextView)
            .scaleX(1.2f)
            .scaleY(1.2f)
            .setDuration(2000)
            .setListener(this)
            .start()
    }

    override fun onAnimationEnd(view: View?) {
        startForMain()
    }

    override fun onAnimationCancel(view: View?) {

    }

    override fun onAnimationStart(view: View?) {

    }

    //是否是第一次进入App
    private val isFirstApp = "isFirstApp"

    //判断跳转页面
    private fun startForMain() {
        L.i("startForMain")
        //判断是否是第一次打开App 如果是第一次打开，我们跳转引导页，否则就直接进入主页
        val isFirst = SpUtils.getInstance().getBoolean(isFirstApp,true)
        if(isFirst){
            //是第一次进入App
            startActivity(Intent(this,GuideActivity::class.java))
            SpUtils.getInstance().putBoolean(isFirstApp,false)
        }else{
            startActivity(Intent(this,MainActivity::class.java))
        }
        finish()
    }
}