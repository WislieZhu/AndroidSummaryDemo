package com.kotlin.common.base

import androidx.lifecycle.LifecycleOwner
import com.kotlin.common.contact.IMvpModel
import com.kotlin.common.contact.IMvpPresenter
import com.kotlin.common.contact.IMvpView
import java.lang.ref.WeakReference

abstract class BasePresenterImpl<M : IMvpModel, V : IMvpView>(private val v: IMvpView) :
    BaseLifecycleObserver {

    //持有model引用
    protected val model: M by lazy {
        createModel()
    }

    private var ref: WeakReference<V>? = null

    //创建model
    protected abstract fun createModel(): M

    //绑定View
    private fun bindView(view: IMvpView) {
        ref = WeakReference(view as V)
    }

    //解绑
    private fun unbindView() {
        ref?.clear()
        ref = null
    }

    //获取持有的View
    protected fun getView(): V? = ref?.get()

    override fun onAny(owner: LifecycleOwner) {

    }

    override fun onCreate(owner: LifecycleOwner) {
        bindView(v)
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
        unbindView()
    }
}