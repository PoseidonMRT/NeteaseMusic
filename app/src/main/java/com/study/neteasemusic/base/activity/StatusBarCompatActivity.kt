package com.study.neteasemusic.base.activity

import android.graphics.Color
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.study.neteasemusic.R
import com.study.neteasemusic.base.utils.StatusBarCompat

abstract class StatusBarCompatActivity : AppCompatActivity() {

    var statusBarColor = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        statusBarColor = initStatusBarColor()
        initView()
        initData()
        StatusBarCompat.compat(this,statusBarColor)
    }

    abstract fun initView()
    abstract fun initData()
    abstract fun initStatusBarColor(): Int
}
