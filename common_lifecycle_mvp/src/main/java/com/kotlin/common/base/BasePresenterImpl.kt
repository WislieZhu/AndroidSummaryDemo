package com.kotlin.common.base

import androidx.lifecycle.LifecycleOwner

class BasePresenterImpl :BaseLifecycleObserver {
    override fun onAny(owner: LifecycleOwner) {
    }

    override fun onCreate(owner: LifecycleOwner) {
    }

    override fun onStart(owner: LifecycleOwner) {
    }

    override fun onStop(owner: LifecycleOwner) {
    }

    override fun onResume(owner: LifecycleOwner) {
    }

    override fun onPause(owner: LifecycleOwner) {
    }

    override fun onDestroy(owner: LifecycleOwner) {
    }
}