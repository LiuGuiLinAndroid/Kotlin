package com.liuguilin.kotlintools.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.liuguilin.kotlintools.R
import kotlinx.android.synthetic.main.fragment_news.*


/**
 * FileName: NewsFragment
 * Founder: LiuGuiLin
 * Profile:
 */
class NewsFragment : Fragment() {

    private val listTitle = listOf("头条", "社会", "国内", "国际", "娱乐", "体育", "军事", "科技", "财经", "时尚")
    private val listName = listOf(
        "top",
        "shehui",
        "guonei",
        "guoji",
        "yule",
        "tiyu",
        "junshi",
        "keji",
        "caijing",
        "shishang"
    )

    private var tabAdapter:TabPagerAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_news, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initTab()
    }

    private fun initTab() {
        activity?.let {
            tabAdapter = TabPagerAdapter(it.supportFragmentManager)
            mNewsPager.adapter = tabAdapter
            mTabLayout.setupWithViewPager(mNewsPager)
            mNewsPager.offscreenPageLimit = listName.size
        }
    }

    inner class TabPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            val newContentFragment = NewContentFragment()
            val bundle = Bundle()
            bundle.putString("title", listName[position])
            newContentFragment.arguments = bundle
            return newContentFragment
        }

        override fun getCount(): Int {
            return listTitle.size
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return listTitle[position]
        }

    }
}