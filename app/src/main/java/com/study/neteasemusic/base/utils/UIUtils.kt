package com.study.neteasemusic.base.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Point
import android.util.DisplayMetrics
import android.view.WindowManager

/**
 * Created by tuozhaobing on 17/9/3.
 */
object UIUtils {
    fun nextPageAndFinishThis(activity: Context,next: Class<Activity>){
        var intent: Intent = Intent(activity,next)
        activity.startActivity(intent)
        (activity as Activity).finish()
    }

    fun getScreenHeight(context: Context): Int{
        var point:Point = Point()
        var wm:WindowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        wm.defaultDisplay.getSize(point)
        return point.y
    }

    fun getScreenWidth(context: Activity): Int{
        var point:Point = Point()
        var wm:WindowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        wm.defaultDisplay.getSize(point)
        return point.x
    }

    fun dip2Px(context: Context,dpValue:Float): Float{
        var scale = context.resources.displayMetrics.density
        return (dpValue*scale + 0.5f)
    }

    fun px2Dip(context: Context,pxValue:Float): Float{
        var scale = context.resources.displayMetrics.density
        return (pxValue/scale + 0.5f)
    }
}