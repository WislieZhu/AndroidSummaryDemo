package com.interview.component.receiver

import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.interview.component.R

/**
 *    author : Wislie
 *    e-mail : 254457234@qq.comn
 *    date   : 3/25/21 9:54 PM
 *    desc   : 广播
 *    version: 1.0
 */
class ReceiverActivity : AppCompatActivity() {
    companion object {
        const val ACTION_NORMAL = "normal.receiver"
        const val ACTION_ORDER = "order.receiver"
        const val ACTION_LOCAL = "local.receiver"
    }

    private var receiver: NormalReceiver? = null
    private var orderAReceiver: OrderAReceiver? = null
    private var orderBReceiver: OrderBReceiver? = null
    private var localReceiver: LocalReceiver? = null
    private var localBroadcastManager: LocalBroadcastManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_normal_receiver)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) { //8.0及以上需要动态注册
            receiver = NormalReceiver()
            val intentFilter = IntentFilter()
            intentFilter.addAction(ACTION_NORMAL)
            registerReceiver(receiver, intentFilter)

            orderAReceiver = OrderAReceiver()
            val orderAIntentFilter = IntentFilter()
            orderAIntentFilter.addAction(ACTION_ORDER)
            registerReceiver(orderAReceiver, orderAIntentFilter)

            orderBReceiver = OrderBReceiver()
            val orderBIntentFilter = IntentFilter()
            orderBIntentFilter.addAction(ACTION_ORDER)
            registerReceiver(orderBReceiver, orderBIntentFilter)

        }

        localReceiver = LocalReceiver()
        val localIntentFilter = IntentFilter()
        localIntentFilter.addAction(ACTION_LOCAL)
        localBroadcastManager = LocalBroadcastManager.getInstance(this)
        localBroadcastManager?.registerReceiver(localReceiver!!, localIntentFilter)

    }

    fun onNormalReceiver(v: View) { //标准广播
        val intent = Intent(ACTION_NORMAL)
        intent.putExtra("name", "标准广播")
        sendBroadcast(intent)
    }

    fun onOrderReceiver(v: View) { //顺序广播
        val intent = Intent(ACTION_ORDER)
        sendOrderedBroadcast(intent, null)
    }

    fun onLocalReceiver(v: View){ //本地广播
        val intent = Intent(ACTION_LOCAL)
        localBroadcastManager?.sendBroadcast(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        if (receiver != null) {
            unregisterReceiver(receiver)
        }
        if (orderAReceiver != null) {
            unregisterReceiver(orderAReceiver)
        }
        if (orderBReceiver != null) {
            unregisterReceiver(orderBReceiver)
        }
        if (localReceiver != null) {
            localBroadcastManager?.unregisterReceiver(localReceiver!!)
        }
    }
}