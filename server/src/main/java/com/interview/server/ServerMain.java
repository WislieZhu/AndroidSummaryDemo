package com.interview.server;

import com.interview.server.http.HttpCallback;
import com.interview.server.http.HttpSocket;

/**
 * author : Wislie
 * e-mail : 254457234@qq.comn
 * date   : 4/5/21 10:07 AM
 * desc   :
 * version: 1.0
 */
public class ServerMain {


    public static void main(String[] args) {
        System.out.println("-------start");

        HttpSocket httpSocket = new HttpSocket();
        httpSocket.startServer(new HttpCallback(){

            @Override
            public byte[] onResponse(String content) {
                return "android--interview".getBytes();
            }
        });
    }
}
