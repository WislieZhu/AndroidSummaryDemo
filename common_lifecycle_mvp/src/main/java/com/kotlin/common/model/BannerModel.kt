package com.kotlin.common.model

import com.kotlin.common.base.BaseModel
import com.kotlin.common.contact.IMvpModel
import com.kotlin.common.presenter.contact.IBannerContact
import com.kotlin.common.util.RetrofitManager

class BannerModel(p: IBannerContact.IBannerPresenter) : BaseModel<IBannerContact.IBannerPresenter>(p), IMvpModel {


    fun getBanner() {
        RetrofitManager.test()

    }


}