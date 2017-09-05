package com.study.neteasemusic.mainpage.fragment

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.View
import com.study.neteasemusic.R
import com.study.neteasemusic.base.adapter.BaseFragmentPagerAdapter
import com.study.neteasemusic.base.fragment.BaseFragment
import com.study.neteasemusic.mainpage.discofragment.MusicListFragment
import com.study.neteasemusic.mainpage.discofragment.RadioFragment
import com.study.neteasemusic.mainpage.discofragment.RatingListFragment
import com.study.neteasemusic.mainpage.discofragment.RecommendFragment
import kotlinx.android.synthetic.main.main_disco_fragment_layout.*
import kotlinx.android.synthetic.main.main_disco_fragment_layout.view.*

/**
 * Created by tuozhaobing on 17/9/3.
 */
class MainDiscoFragment: BaseFragment() {

    private lateinit var mTabLayout: TabLayout
    private lateinit var mViewPager: ViewPager

    private lateinit var mFragments: List<Fragment>
    private lateinit var mRecommendFragment:RecommendFragment
    private lateinit var mMusicListFragment:MusicListFragment
    private lateinit var mRadioFragment:RadioFragment
    private lateinit var mRatingListFragment:RatingListFragment

    private lateinit var mFragmentPagerAdapter:BaseFragmentPagerAdapter

    override fun setContent(): Int {
        return R.layout.main_disco_fragment_layout
    }

    override fun initView(view: View, savedInstanceState: Bundle?) {
        mTabLayout = view.findViewById(R.id.main_disco_tabs) as TabLayout
        mViewPager = view.findViewById(R.id.main_disco_view_pager) as ViewPager
    }

    override fun initData() {
        initTabsAndViewPager()
        mTabLayout.setupWithViewPager(mViewPager)
    }

    fun initTabsAndViewPager(){
        //tab layout init
        val tabTitles = listOf<String>(resources.getString(R.string.main_disco_tab_title_recommand),resources.getString(R.string.main_disco_tab_title_music_list),
                resources.getString(R.string.main_disco_tab_title_radio),resources.getString(R.string.main_disco_tab_title_rating_list))
        for (title in tabTitles){
            mTabLayout.addTab(main_disco_tabs.newTab().setText(title))
        }

        //fragment init
        mRadioFragment = RadioFragment()
        mRecommendFragment = RecommendFragment()
        mMusicListFragment = MusicListFragment()
        mRatingListFragment = RatingListFragment()

        mFragments = listOf(mRecommendFragment,mMusicListFragment,mRadioFragment,mRatingListFragment)

        mFragmentPagerAdapter = BaseFragmentPagerAdapter(childFragmentManager,mFragments,tabTitles)
        mViewPager.adapter = mFragmentPagerAdapter
    }
}