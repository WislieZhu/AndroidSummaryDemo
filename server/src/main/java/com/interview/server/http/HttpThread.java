package com.interview.server.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

/**
 * author : Wislie
 * e-mail : 254457234@qq.comn
 * date   : 4/5/21 10:18 AM
 * desc   :
 * version: 1.0
 */
public class HttpThread implements Runnable {

    private Socket mSocket;
    private HttpCallback mCallback;


    public HttpThread(Socket socket, HttpCallback callback){
        mSocket = socket;
        mCallback = callback;
    }

    @Override
    public void run() {
        System.out.println("socket accept-----");
        OutputStream outputStream = null;
        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(mSocket.getInputStream()));
            String content = "";
            StringBuilder sb = new StringBuilder();
            while((content = br.readLine()) != null  && !"".equals(content.trim())){
                sb.append(content).append("\n");
            }
            String str = sb.toString();
            System.out.println("content="+str);
            //请求体
            byte []response = mCallback.onResponse(sb.toString());

            outputStream = mSocket.getOutputStream();
            //请求行
            String responseFirstLine = "HTTP/1.1 200 OK\r\n";
            //请求头
            String responseHead = "Content-Type:"+"text/html"+"\r\n";

            //发送请求行
            outputStream.write(responseFirstLine.getBytes());
            //发送请求头
            outputStream.write(responseHead.getBytes());
            //换行
            outputStream.write("\r\n".getBytes());
            //消息体
            outputStream.write(response);
            mSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
