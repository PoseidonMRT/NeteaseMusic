package com.study.neteasemusic

import android.content.Intent
import kotlinx.android.synthetic.main.activity_splash.*;
import android.os.CountDownTimer
import com.study.neteasemusic.base.FullScreenActivity

class SplashActivity : FullScreenActivity() {

    private var timer :SplashCountDownTimer? = null

    override fun initView() {
        setContentView(R.layout.activity_splash)
    }

    override fun initData() {
        timer = SplashCountDownTimer(10000,1000)
        (timer as SplashCountDownTimer).start()
    }


    inner class SplashCountDownTimer(millisInFuture: Long,countDownInterval: Long) : CountDownTimer(millisInFuture,countDownInterval){
        override fun onFinish() {
            val intent:Intent = Intent(this@SplashActivity,MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        override fun onTick(millisUntilFinished: Long) {
            splash_count_down_text.text = (millisUntilFinished / 1000).toString()
        }
    }
}
