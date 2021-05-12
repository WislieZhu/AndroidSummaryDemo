package com.interview.server.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * author : Wislie
 * e-mail : 254457234@qq.comn
 * date   : 4/5/21 4:25 PM
 * desc   :
 * version: 1.0
 */
public class HttpSocket {

    private boolean mIsRunning = false;


    public void startServer(HttpCallback callback){
        mIsRunning = true;
        try {
            ServerSocket serverSocket = new ServerSocket(333);
            while (mIsRunning){
                Socket socket = serverSocket.accept();
                ExecutorService  threadPool = Executors.newCachedThreadPool();
                threadPool.execute(new HttpThread(socket, callback));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
