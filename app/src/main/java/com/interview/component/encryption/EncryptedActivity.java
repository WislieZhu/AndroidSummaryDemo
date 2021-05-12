package com.interview.component.encryption;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.interview.component.R;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * author : Wislie
 * e-mail : 254457234@qq.comn
 * date   : 4/5/21 7:22 PM
 * desc   :
 * version: 1.0
 */
public class EncryptedActivity extends AppCompatActivity {

    private String TAG = "EncryptedActivity";

    //openSSL
    //基本操作 RSA/AES

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encrypted);

    }

    public void onEncryption(View view){ //todo 最好获取本地的ip地址
        String url = "http://192.168.124.6:333/";
        HttpRequest.request(url, new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.i(TAG, "onFailure: "+e.getMessage());
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                Log.i(TAG, "onResponse: "+response.body().string());
            }
        });
    }
}
