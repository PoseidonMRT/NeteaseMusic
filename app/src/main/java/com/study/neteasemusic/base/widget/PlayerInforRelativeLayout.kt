package com.study.neteasemusic.base.widget

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.ViewConfiguration
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.study.neteasemusic.R

/**
 * Created by tuozhaobing on 17/9/7.
 */
class PlayerInforRelativeLayout: RelativeLayout {
    private lateinit var mContext: Context
    private lateinit var mPlayerInfoIcon: ImageView
    private lateinit var mPlayerInfoTitle: TextView
    private lateinit var mPlayerInfoAuthor: TextView


    constructor(context: Context): super(context){
        initView(context)
    }

    constructor(context: Context,attrs: AttributeSet): super(context,attrs){
        initView(context)
    }

    constructor(context: Context,attrs: AttributeSet,defStyleAttr:Int): super(context,attrs,defStyleAttr){
        initView(context)
    }

    fun initView(context: Context){
        View.inflate(context, R.layout.player_info_layout,this)
        mPlayerInfoIcon = this.findViewById(R.id.player_info_music_icon) as ImageView
        mPlayerInfoTitle = this.findViewById(R.id.player_info_music_name) as TextView
        mPlayerInfoAuthor = this.findViewById(R.id.player_info_music_author) as TextView
    }
}