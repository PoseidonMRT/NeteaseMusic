package com.study.neteasemusic.base.widget

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.ViewConfiguration
import android.view.ViewGroup
import android.widget.FrameLayout
import com.study.neteasemusic.base.utils.UIUtils

/**
 * Created by tuozhaobing on 17/9/7.
 */
class SwipeFrameLayout:FrameLayout {
    private var isIntercept:Boolean = false
    private lateinit var mOnSwipeListener:OnSwipeListener
    private var mTouchSlop: Int = -1
    private var mTouchDownX:Float = -1.0f
    private var mTouchDownY:Float = -1.0f
    private var mCurrentTouchDownX:Float = -1.0f
    private var mCurrentTouchDownY:Float = -1.0f
    private var mCurrentDX:Float = -1.0f
    private var mCurrentDY:Float = -1.0f
    private var playerBarHeight:Float = -1.0f
    private var screenHeight:Int = -1

    constructor(context: Context): super(context){
        initData()
    }

    constructor(context: Context, attributes: AttributeSet): super(context,attributes){
        initData()
    }

    fun initData(){
        mTouchSlop = ViewConfiguration.get(context).scaledTouchSlop
        playerBarHeight = UIUtils.dip2Px(context,56f)
        screenHeight = UIUtils.getScreenHeight(context)
    }

    fun addOnSwipeListener(onSwipeListener: OnSwipeListener){
        mOnSwipeListener = onSwipeListener
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        Log.e("ZBTUO","Swipe FrameLayout intercept touch event")
        if (ev!!.rawY >= (screenHeight - playerBarHeight)){
            Log.e("ZBTUO","Swipe FrameLayout intercept touch event is intercept = true")
            isIntercept = true
            return true
        }
        return super.onInterceptTouchEvent(ev)
    }

    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        if (isIntercept){
            Log.e("ZBTUO","Swipe Framelayout on touch event")
            when(ev!!.action){
                MotionEvent.ACTION_DOWN -> {
                    Log.e("ZBTUO","Swipe FrameLayout ontouch down")
                    mTouchDownX = ev.rawX
                    mTouchDownY = ev.rawY
                }
                MotionEvent.ACTION_MOVE -> {
                    mCurrentTouchDownX = ev.rawX
                    mCurrentTouchDownY = ev.rawY
                    mCurrentDX = mCurrentTouchDownX - mTouchDownX
                    mCurrentDY = mCurrentTouchDownY - mTouchDownY
                    if (Math.abs(mCurrentDX) > Math.abs(mCurrentDY)){
                        if (mCurrentDX > 0){
                            Log.e("ZBTUO","Right Swipe")
                            mOnSwipeListener.swipeRight()
                        }else{
                            Log.e("ZBTUO","Left Swipe")
                            mOnSwipeListener.swipeLeft()
                        }
                    }
                }
                MotionEvent.ACTION_UP -> {

                }
            }
            return true
        }
        return super.onTouchEvent(ev)
    }

    interface OnSwipeListener{
        fun swipeLeft()
        fun swipeRight()
    }
}