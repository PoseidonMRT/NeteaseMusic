package com.study.neteasemusic.base.fragment

import android.content.Context
import android.os.Bundle
import android.support.annotation.Nullable
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout



/**
 * Created by tuozhaobing on 17/9/3.
 */
abstract class BaseFragment:Fragment() {
    private lateinit var mRootView: View
    private lateinit var mContext: Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(inflater: LayoutInflater?, @Nullable container: ViewGroup?, @Nullable savedInstanceState: Bundle?): View? {
        mRootView = inflater!!.inflate(setContent(), container, false)
        return mRootView
    }

    abstract fun setContent(): Int
}