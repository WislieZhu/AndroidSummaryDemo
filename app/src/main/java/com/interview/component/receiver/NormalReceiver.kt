package com.interview.component.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

/**
 * author : Wislie
 * e-mail : 254457234@qq.comn
 * date   : 3/25/21 8:30 PM
 * desc   : 标准广播
 * version: 1.0
 */
class NormalReceiver : BroadcastReceiver() {
    private val TAG = "NormalReceiver"
    override fun onReceive(context: Context, intent: Intent) {
        val msg = intent.getStringExtra("name")
        Log.i(TAG, "onReceive: $msg")
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show()
    }
}