package com.example.debugexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String android = "android";

        Log.e("MainActivity : ", android);  //   앱이 실행될 때 로그 출력
        int a = 10;
        Log.e("MainActivity", String.valueOf(a));
        
    }
}