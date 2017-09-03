package com.study.neteasemusic.base.utils

import android.app.Activity
import android.content.Context
import android.content.Intent

/**
 * Created by tuozhaobing on 17/9/3.
 */
object UIUtils {
    fun nextPageAndFinishThis(activity: Context,next: Class<Activity>){
        var intent: Intent = Intent(activity,next)
        activity.startActivity(intent)
        (activity as Activity).finish()
    }
}