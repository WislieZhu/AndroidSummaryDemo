package com.interview.component.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

/**
 *    author : Wislie
 *    e-mail : 254457234@qq.comn
 *    date   : 3/25/21 11:27 PM
 *    desc   : 本地广播
 *    version: 1.0
 */
class LocalReceiver:BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context,"本地广播",Toast.LENGTH_SHORT).show()
    }
}