package com.interview.server.http;

/**
 * author : Wislie
 * e-mail : 254457234@qq.comn
 * date   : 4/5/21 4:35 PM
 * desc   :
 * version: 1.0
 */
public interface HttpCallback {

    byte[] onResponse(String content);
}
