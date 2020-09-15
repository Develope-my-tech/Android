package com.example.webviewexample;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private WebView webView;
    private String url = "https://m.naver.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webView);
        webView.getSettings().getJavaScriptEnabled();   // webview의 자바스크립트를 허용
        webView.loadUrl(url);
        webView.setWebChromeClient(new WebChromeClient());  // 크롬 브라우저에서 쾌적하게 쓸 수 있도록 최적화
        webView.setWebViewClient(new WebViewClientClass());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            //For device above MarshMellow
            boolean permission = getInternetPermission();
            if (permission) {
                Toast.makeText(this, "obtain contact permission", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "failed to obtain contact permission", Toast.LENGTH_SHORT).show();
        }
        
    }

    public boolean getInternetPermission() {
        boolean hasPermission = (
                (ContextCompat.checkSelfPermission(this,
                        Manifest.permission.INTERNET) == PackageManager.PERMISSION_GRANTED));
        if (!hasPermission) {
            ActivityCompat.requestPermissions(this, new String[] {
                    Manifest.permission.INTERNET
            }, 1);
        }
        return hasPermission;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) { // 특정 키들을 입력했을 때 동작 지시
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()){ // 뒤로가기를 눌렀고, 뒤로 갈 수 있는 상황이면
            webView.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    private class WebViewClientClass extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) { // 현재 페이지의 url을 읽어옴.
            view.loadUrl(url);
            return true;
        }
    }
}
