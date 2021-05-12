package com.kotlin.livedata

import androidx.lifecycle.MutableLiveData
import github.leavesc.eventlivedata.EventLiveData

/**
 *    author : Wislie
 *    e-mail : 254457234@qq.comn
 *    date   : 4/22/21 10:51 PM
 *    desc   :
 *    version: 1.0
 */
object FocusRepository {

    //String 表示圈子ID，Boolean 表示对该圈子的关注状态
//    val focusLiveData = MutableLiveData<Pair<String, Boolean>>()

    val focusLiveData = EventLiveData<Pair<String, Boolean>>()

}