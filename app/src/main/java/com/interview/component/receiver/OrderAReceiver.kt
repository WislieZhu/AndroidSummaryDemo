package com.interview.component.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast

/**
 *    author : Wislie
 *    e-mail : 254457234@qq.comn
 *    date   : 3/25/21 10:17 PM
 *    desc   : 广播A
 *    version: 1.0
 */
class OrderAReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {

        Toast.makeText(context,"A",Toast.LENGTH_SHORT).show()

        val bundle = Bundle()
        bundle.putString("data","B")
        setResultExtras(bundle)
    }
}