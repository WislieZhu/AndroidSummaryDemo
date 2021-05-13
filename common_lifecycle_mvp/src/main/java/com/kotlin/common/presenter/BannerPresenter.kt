package com.kotlin.common.presenter

import com.kotlin.common.model.BannerModel
import com.kotlin.common.presenter.contact.IBannerContact

class BannerPresenter(bannerView:IBannerContact.IBannerView) : IBannerContact.IBannerPresenter {

    private var bannerModel = BannerModel()

    fun getBanners(){
        bannerModel.getBanner()
    }
}