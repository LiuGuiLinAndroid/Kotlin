package com.liuguilin.kotlintools

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.graphics.PixelFormat
import android.os.Bundle
import android.util.EventLog
import android.view.KeyEvent
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.liuguilin.kotlintools.event.EventImpl
import com.liuguilin.kotlintools.event.MessageEvent
import com.liuguilin.kotlintools.ui.activity.CitySelectActivity
import com.liuguilin.kotlintools.ui.fragment.JokeFragment
import com.liuguilin.kotlintools.ui.fragment.MovieFragment
import com.liuguilin.kotlintools.ui.fragment.NewsFragment
import com.liuguilin.kotlintools.ui.fragment.WeatherFragment
import kotlinx.android.synthetic.main.activity_main.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var newsFragment: NewsFragment? = null
    private var newsTransaction: FragmentTransaction? = null

    private var movieFragment: MovieFragment? = null
    private var movieTransaction: FragmentTransaction? = null

    private var weatherFragment: WeatherFragment? = null
    private var weatherTransaction: FragmentTransaction? = null

    private var jokeFragment: JokeFragment? = null
    private var jokeTransaction: FragmentTransaction? = null

    private var currentFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //X5 Config
        window.setFormat(PixelFormat.TRANSLUCENT)

        EventBus.getDefault().register(this)

        supportActionBar?.elevation = 0f

        initView()
    }

    private fun initView() {
        mTextNews.text = "新闻"
        mTextMovie.text = "电影"
        mTextWeather.text = "天气"
        mTextJoke.text = "笑话"

        mTextNews.setOnClickListener(this)
        mTextMovie.setOnClickListener(this)
        mTextWeather.setOnClickListener(this)
        mTextJoke.setOnClickListener(this)

        initFragment()

        checkText(0)
    }

    private fun initFragment() {

        if (newsFragment == null) {
            newsTransaction = supportFragmentManager.beginTransaction()
            newsFragment = NewsFragment()
            newsTransaction?.add(R.id.mContentLayout, newsFragment!!)
            newsTransaction?.commit()
        }
        if (movieFragment == null) {
            movieTransaction = supportFragmentManager.beginTransaction()
            movieFragment = MovieFragment()
            movieTransaction?.add(R.id.mContentLayout, movieFragment!!)
            movieTransaction?.commit()
        }
        if (weatherFragment == null) {
            weatherTransaction = supportFragmentManager.beginTransaction()
            weatherFragment = WeatherFragment()
            weatherTransaction?.add(R.id.mContentLayout, weatherFragment!!)
            weatherTransaction?.commit()
        }
        if (jokeFragment == null) {
            jokeTransaction = supportFragmentManager.beginTransaction()
            jokeFragment = JokeFragment()
            jokeTransaction?.add(R.id.mContentLayout, jokeFragment!!)
            jokeTransaction?.commit()
        }
    }

    //显示碎片
    private fun showFragment(fragment: Fragment) {
        val beginTransaction = supportFragmentManager.beginTransaction()
        hideAllFragment(beginTransaction)
        beginTransaction.show(fragment)
        beginTransaction.commitAllowingStateLoss()
        currentFragment = fragment
    }

    //隐藏所有的碎片
    private fun hideAllFragment(beginTransaction: FragmentTransaction) {
        beginTransaction.hide(newsFragment!!)
        beginTransaction.hide(movieFragment!!)
        beginTransaction.hide(weatherFragment!!)
        beginTransaction.hide(jokeFragment!!)
    }

    private fun checkText(index: Int) {
        when (index) {
            0 -> {
                mTextNews.setTextColor(Color.RED)
                mTextMovie.setTextColor(Color.BLACK)
                mTextWeather.setTextColor(Color.BLACK)
                mTextJoke.setTextColor(Color.BLACK)

                showFragment(newsFragment!!)

                ll_bottom.visibility = View.VISIBLE

                supportActionBar?.show()
                supportActionBar?.title = "新闻"
            }
            1 -> {
                mTextNews.setTextColor(Color.BLACK)
                mTextMovie.setTextColor(Color.RED)
                mTextWeather.setTextColor(Color.BLACK)
                mTextJoke.setTextColor(Color.BLACK)

                showFragment(movieFragment!!)

                ll_bottom.visibility = View.GONE

                supportActionBar?.hide()
            }
            2 -> {
                mTextNews.setTextColor(Color.BLACK)
                mTextMovie.setTextColor(Color.BLACK)
                mTextWeather.setTextColor(Color.RED)
                mTextJoke.setTextColor(Color.BLACK)

                showFragment(weatherFragment!!)

                ll_bottom.visibility = View.VISIBLE

                supportActionBar?.show()
                supportActionBar?.title = weatherFragment!!.getCity()
            }
            3 -> {
                mTextNews.setTextColor(Color.BLACK)
                mTextMovie.setTextColor(Color.BLACK)
                mTextWeather.setTextColor(Color.BLACK)
                mTextJoke.setTextColor(Color.RED)

                showFragment(jokeFragment!!)

                ll_bottom.visibility = View.VISIBLE

                supportActionBar?.show()
                supportActionBar?.title = "笑话"
            }
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.mTextNews -> checkText(0)
            R.id.mTextMovie -> checkText(1)
            R.id.mTextWeather -> checkText(2)
            R.id.mTextJoke -> checkText(3)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(event: MessageEvent?) {
        when (event?.type) {
            EventImpl.TYPE_BACK_HOME -> checkText(0)
            EventImpl.TYPE_WEATHER_TITLE -> {
                if (currentFragment == weatherFragment) {
                    supportActionBar?.title = event.text
                }
            }
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (movieFragment?.canBack()!!) {
                movieFragment?.back()
                return false
            }
        }
        return super.onKeyDown(keyCode, event)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_select) {
            startActivityForResult(Intent(this, CitySelectActivity::class.java), 1000)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK){
            if(requestCode == 1000){
                val city = data?.getStringExtra("city")
                weatherFragment?.setCity(city)
            }
        }
    }
}
