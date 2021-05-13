package com.kotlin.common.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseMvpActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getContentLayoutId())

        lifecycle.addObserver(BasePresenterImpl());
        init()
    }

    abstract fun getContentLayoutId():Int

    abstract fun init()
}