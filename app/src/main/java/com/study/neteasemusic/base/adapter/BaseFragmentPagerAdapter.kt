package com.study.neteasemusic.base.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Created by tuozhaobing on 17/9/5.
 */
class BaseFragmentPagerAdapter(fragmentManager: FragmentManager, var fragments:List<Fragment>, var titles:List<String>):FragmentPagerAdapter(fragmentManager) {
    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }

    override fun getPageTitle(position: Int): CharSequence {
        if (titles != null && !titles.isEmpty()){
            return titles[position]
        }else{
            return ""
        }
    }
}