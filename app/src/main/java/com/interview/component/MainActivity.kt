package com.interview.component

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import com.interview.component.encryption.EncryptedActivity
import com.interview.component.receiver.ReceiverActivity
import com.kotlin.common.ui.BannerActivity
import com.kotlin.livedata.CircleListActivity

class MainActivity : AppCompatActivity() {

    private val TAG: String = "MainActivity-Zhu"



    //属性初始化, 构造器要求属性初始化
    private val kotlinBtn by lazy{ //只有 btn_kotlin首次访问 创建
        findViewById<Button>(R.id.btn_kotlin)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        kotlinBtn.post {
            Log.i(TAG, "TextView post: " + kotlinBtn.width + " " + kotlinBtn.height +
                    " 测量高度="+ kotlinBtn.measuredHeight) //1080 2657 测量高度=2657
        }

        lifecycle.addObserver(object : DefaultLifecycleObserver {
            override fun onCreate(owner: LifecycleOwner) {
                Log.i(TAG,"onCreate--")
            }

            override fun onResume(owner: LifecycleOwner) {
                Log.i(TAG,"onResume--")
            }

            override fun onPause(owner: LifecycleOwner) {
                Log.i(TAG,"onPause--")
            }

            override fun onStart(owner: LifecycleOwner) {
                Log.i(TAG,"onStart--")
            }

            override fun onStop(owner: LifecycleOwner) {
                Log.i(TAG,"onStop--")
            }

            override fun onDestroy(owner: LifecycleOwner) {
                Log.i(TAG,"onDestroy--")
            }

        })

        lifecycle.addObserver(object:LifecycleEventObserver{
            override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
                when(event){

                    Lifecycle.Event.ON_CREATE->

                        Log.i(TAG,"onCreate")
                    Lifecycle.Event.ON_START->

                        Log.i(TAG,"onStart")
                    Lifecycle.Event.ON_RESUME->

                        Log.i(TAG,"onResume")
                    Lifecycle.Event.ON_PAUSE->

                        Log.i(TAG,"onPause")
                    Lifecycle.Event.ON_STOP->

                        Log.i(TAG,"onStop")
                    Lifecycle.Event.ON_DESTROY->

                        Log.i(TAG,"onDestory")
                }
            }

        })

    }

    fun onReceiver(v:View){
        val intent = Intent(this,ReceiverActivity::class.java)
        startActivity(intent)
    }

    fun onEncryption(v: View){
        val intent = Intent(this,EncryptedActivity::class.java)
        startActivity(intent)
        //如果不加 call.isExecuted() ,会怎么样 clone

    }

    fun onLiveData(v: View){
//        val intent = Intent(this,CircleListActivity::class.java)
//        startActivity(intent)

        val intent = Intent(this,BannerActivity::class.java)
        startActivity(intent)
    }
}
