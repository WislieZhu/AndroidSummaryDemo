package com.kotlin.common.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kotlin.common.contact.IMvpView

abstract class BaseMvpActivity<P : BasePresenterImpl<*, *>> : AppCompatActivity(), IMvpView {

    val presenter: P by lazy {
        createPresenter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getContentLayoutId())
        lifecycle.addObserver(presenter);
        init()
    }

    abstract fun getContentLayoutId(): Int

    abstract fun init()

    abstract fun createPresenter(): P

}