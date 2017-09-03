package com.study.neteasemusic.base.utils

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.view.ViewGroup
import android.os.Build
import android.view.View
import android.annotation.TargetApi


/**
 * Created by tuozhaobing on 17/9/3.
 */
object StatusBarCompat {

    private val INVALID_VAL = -1
    private val COLOR_DEFAULT = Color.parseColor("#20000000")

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    fun compat(activity: Activity, statusColor: Int) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (statusColor != INVALID_VAL) {
                activity.window.statusBarColor = statusColor
            }
            return
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT && Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            var color = COLOR_DEFAULT
            val contentView = activity.findViewById(android.R.id.content) as ViewGroup
            if (statusColor != INVALID_VAL) {
                color = statusColor
            }
            val statusBarView = View(activity)
            val lp = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    getStatusBarHeight(activity))
            statusBarView.setBackgroundColor(color)
            contentView.addView(statusBarView, lp)
        }

    }

    fun compat(activity: Activity) {
        compat(activity, INVALID_VAL)
    }


    fun getStatusBarHeight(context: Context): Int {
        var result = 0
        val resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android")
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId)
        }
        return result
    }
}