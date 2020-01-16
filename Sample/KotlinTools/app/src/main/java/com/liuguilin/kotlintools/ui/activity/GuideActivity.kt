package com.liuguilin.kotlintools.ui.activity

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.liuguilin.kotlintools.MainActivity
import com.liuguilin.kotlintools.R
import com.liuguilin.okhelper.base.adapter.BasePageAdapter
import kotlinx.android.synthetic.main.activity_guide.*


/**
 * FileName: GuideActivity
 * Founder: LiuGuiLin
 * Profile: 引导页
 */
class GuideActivity : AppCompatActivity(), ViewPager.OnPageChangeListener {

    private val list = ArrayList<View>()
    private var myAdapter: BasePageAdapter? = null
    private val title = listOf("方便","快捷","简单")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guide)

        initView()
    }

    private fun initView() {
        mSkipMain.text = "跳转主页"

        mSkipMain.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }

        //初始化View
        for (i in 0..2) {
            val tv = TextView(this)
            tv.layoutParams = RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT
            )
            tv.gravity = Gravity.CENTER
            tv.text = title[i]
            tv.setTextColor(Color.WHITE)
            tv.textSize = 30f

            when (i) {
                0 -> tv.setBackgroundColor(Color.YELLOW)
                1 -> tv.setBackgroundColor(Color.RED)
                2 -> tv.setBackgroundColor(Color.GREEN)
            }
            list.add(tv)
        }

        myAdapter = BasePageAdapter(list)
        mViewPager.adapter = myAdapter

        mViewPager.addOnPageChangeListener(this)
    }

    override fun onPageScrollStateChanged(state: Int) {
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
    }

    override fun onPageSelected(position: Int) {
        mSkipMain.visibility = if (position == 2) View.VISIBLE else View.GONE
    }
}