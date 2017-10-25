package com.study.neteasemusic.base.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

abstract class StatusBarCompatActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        initData()
    }

    abstract fun initView()
    abstract fun initData()
    abstract fun initStatusBarColor(): Int
}
