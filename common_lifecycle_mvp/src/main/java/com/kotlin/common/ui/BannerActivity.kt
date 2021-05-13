package com.kotlin.common.ui

import android.view.View
import android.widget.Button
import com.kotlin.common.R
import com.kotlin.common.base.BaseMvpActivity
import com.kotlin.common.presenter.BannerPresenter
import com.kotlin.common.presenter.contact.IBannerContact

class BannerActivity:BaseMvpActivity(), IBannerContact.IBannerView {

    private val btn: Button by lazy{
        findViewById(R.id.btn)
    }

    override fun getContentLayoutId(): Int {
        return R.layout.activity_banner
    }

    override fun init() {
        btn.setOnClickListener(View.OnClickListener {
            BannerPresenter(this).getBanners()
        })


    }
}