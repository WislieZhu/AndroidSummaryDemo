package com.kotlin.common.presenter

import com.kotlin.common.base.BasePresenterImpl
import com.kotlin.common.model.BannerModel
import com.kotlin.common.presenter.contact.IBannerContact

class BannerPresenter(bannerView: IBannerContact.IBannerView) : BasePresenterImpl<BannerModel, IBannerContact.IBannerView>(bannerView),
        IBannerContact.IBannerPresenter {

    override fun createModel(): BannerModel {
        return BannerModel(this)
    }

    fun getBanners() {
        model.getBanner()


//        getView() 去实现接口


    }

}