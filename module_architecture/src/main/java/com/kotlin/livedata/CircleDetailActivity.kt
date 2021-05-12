package com.kotlin.livedata

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.*

/**
 *    author : Wislie
 *    e-mail : 254457234@qq.comn
 *    date   : 4/23/21 8:23 AM
 *    desc   :
 *    version: 1.0
 */
class CircleDetailActivity : AppCompatActivity() {

    val TAG = "CircleDetailActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_circle_detail)
        Log.i(TAG, "生命周期--onCreate: ")


        FocusRepository.focusLiveData.observeForever(Observer {
            Log.i(TAG, "observer circle receive:"+System.currentTimeMillis())
        })
//        FocusRepository.focusLiveData.observe(Observer {
//
//        })

        lifecycle.addObserver(object: LifecycleEventObserver {
            override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
            }
        })

        Lifecycle.State.INITIALIZED //1
        Lifecycle.State.CREATED //2
        Lifecycle.State.STARTED //3
        Lifecycle.State.RESUMED //4
        Lifecycle.State.DESTROYED //0
    }

    fun onAttention(v: View) {
        Log.i(TAG, "observer circle dispatch:"+System.currentTimeMillis())
        FocusRepository.focusLiveData.postValue(Pair("12", true))
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