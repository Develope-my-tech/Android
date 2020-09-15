# WebView

## MainActivity

<image src="https://user-images.githubusercontent.com/34594339/93247144-ccd12580-f7c8-11ea-84f6-7f335e57b927.png" width="35%">
<br>

## AndroidManifest.xml

    <uses-permission android:name="android.permission.INTERNET"/>

### 안드로이드 인터넷 권한 주기

<br>

## MainActivity.java

	@Override  
	protected void onCreate(Bundle savedInstanceState) {  
	    super.onCreate(savedInstanceState);  
	  setContentView(R.layout.activity_main);  
	  
	  webView = findViewById(R.id.webView);  
	  webView.getSettings().getJavaScriptEnabled(); // webview의 자바스크립트를 허용  
	  webView.loadUrl(url);  
	  webView.setWebChromeClient(new WebChromeClient()); // 크롬 브라우저에서 쾌적하게 쓸 수 있도록 최적화  
	  webView.setWebViewClient(new WebViewClientClass());  
	  
	  // 인터넷 권한이 주어졌는 지 확인
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

### 처음 webview가 계속 실행이 되지 않아 권한이 주어졌는 지 확인하는 코드를 추가하였다. 그러나 원인은 네이버가 안 들어가지는 것이었다.<br>
### 네이버를 사용하려면 모바일 버전인 m.naver.com을 사용하면 된다.<br>

<br>

### 특정 키를 입력하는 경우

	@Override  
	public boolean onKeyDown(int keyCode, KeyEvent event) { // 특정 키들을 입력했을 때 동작 지시  
	  if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()){ // 뒤로가기를 눌렀고, 뒤로 갈 수 있는 상황이면  
	  webView.goBack();  
	 return true;  }  
	  
	    return super.onKeyDown(keyCode, event);  
	}


<br>

### WebViewClientClass

	private class WebViewClientClass extends WebViewClient {  
	    @Override  
	  public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) { // 현재 페이지의 url을 읽어옴.  
	  view.loadUrl(url);  
	 return true;  }  
	}


