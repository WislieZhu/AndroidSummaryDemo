package com.kotlin.common.base

import com.kotlin.common.contact.IMvpModel
import com.kotlin.common.contact.IMvpPresenter

abstract class BaseModel<P : IMvpPresenter>(val p: P) : IMvpModel {


}