package com.liuguilin.kotlinweather.base

import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity


/**
 * FileName: BaseActivity
 * Founder: LiuGuiLin
 * Profile:
 */
abstract class BaseActivity : AppCompatActivity() {

    //加载布局
    abstract fun getLayoutId(): Int

    //是否显示返回键
    abstract fun isShowBack(): Boolean

    //初始化方法
    abstract fun initView()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())

        initView()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            supportActionBar?.setDisplayHomeAsUpEnabled(isShowBack())
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}