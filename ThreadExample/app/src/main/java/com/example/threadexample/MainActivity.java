package com.example.threadexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn_start, btn_exit;
    Thread thread;
    boolean isThread = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // thread === > 백그라운드에서 사용할 수 있게 해준다.

        // thread start
        btn_start = (Button)findViewById(R.id.btn_start);
        btn_exit = (Button)findViewById(R.id.btn_exit);

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                isThread = true;
                thread = new Thread() {
                    public void run(){
                        System.out.println("thread start");
                        while (isThread){
                            try {
                                sleep(5000); // 5초동안 sleep
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            handler.sendEmptyMessage(0);
                        }
                    }
                };
                thread.start();
            }
        });

        // thread exit
        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isThread = false; // 백그라운드에서 실행되고 있던 thread 시작 onclick 함수의 반복문 종료
            }
        });
    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            Toast.makeText(getApplicationContext(), "hello world", Toast.LENGTH_SHORT).show();
        }
    };
}