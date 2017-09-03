package com.study.neteasemusic.mainpage

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Created by tuozhaobing on 17/9/3.
 */
class MainContentViewPagerAdapter(fragmentManager: FragmentManager,var fragments:List<Fragment>): FragmentPagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }
}