package com.kotlin.common.ui

import android.view.View
import android.widget.Button
import com.kotlin.common.R
import com.kotlin.common.base.BaseMvpActivity
import com.kotlin.common.presenter.BannerPresenter
import com.kotlin.common.presenter.contact.IBannerContact

class BannerActivity : BaseMvpActivity<BannerPresenter>(), IBannerContact.IBannerView {

    private val btn: Button by lazy {
        findViewById(R.id.btn)
    }

    override fun getContentLayoutId(): Int {
        return R.layout.activity_banner
    }

    override fun init() {
        btn.setOnClickListener(View.OnClickListener {
            presenter.getBanners()
        })


    }

    override fun createPresenter(): BannerPresenter {
        return BannerPresenter(this)
    }
}