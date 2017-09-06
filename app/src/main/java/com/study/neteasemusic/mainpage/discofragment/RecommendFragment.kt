package com.study.neteasemusic.mainpage.discofragment

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.View
import com.study.neteasemusic.R
import com.study.neteasemusic.base.fragment.BaseFragment

/**
 * Created by tuozhaobing on 17/9/5.
 */
class RecommendFragment: BaseFragment() {

    private lateinit var mRecyclerView: RecyclerView

    override fun setContent(): Int {
        return R.layout.main_desco_recommend_fragment_layout
    }

    override fun initView(view: View, savedInstanceState: Bundle?) {
        mRecyclerView = view.findViewById(R.id.main_disco_recommend_recycler_view) as RecyclerView
    }

    override fun initData() {

    }
}