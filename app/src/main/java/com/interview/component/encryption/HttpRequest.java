package com.interview.component.encryption;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * author : Wislie
 * e-mail : 254457234@qq.comn
 * date   : 4/5/21 7:27 PM
 * desc   :
 * version: 1.0
 */
public class HttpRequest {

    public static void request(String url, Callback callback){
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .build();
        Request request = new Request
                .Builder()
                .get()
                .url(url)
                .build();
        Call call = okHttpClient.newCall(request);
        if(call.isExecuted()){
            call.clone().enqueue(callback);
        }else {
            call.enqueue(callback);
        }
    }
}
