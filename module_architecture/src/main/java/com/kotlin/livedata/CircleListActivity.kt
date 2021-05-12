package com.kotlin.livedata

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer

/**
 *    author : Wislie
 *    e-mail : 254457234@qq.comn
 *    date   : 4/22/21 10:52 PM
 *    desc   :
 *    version: 1.0
 */
class CircleListActivity:AppCompatActivity() {

    val TAG = "CircleListActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_circle_list)

        FocusRepository.focusLiveData.observeForever(Observer {
            Log.i(TAG, "observer circle receive:"+System.currentTimeMillis())
        })

        Log.i(TAG, "生命周期--onCreate: ")
    }

    //Activity A 处于onStop状态下
    //Activity B 发送消息过来，会什么时候收到

    fun onDetail(v: View){
        startActivity(Intent(this,CircleDetailActivity::class.java))
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(TAG, "生命周期--onRestart: ")
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "生命周期--onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "生命周期--onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "生命周期--onPause: ")
    }
    
    override fun onStop() {
        super.onStop()
        Log.i(TAG, "生命周期--onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "生命周期--onDestroy: ")
    }
}