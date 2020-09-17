# :dart: Debug

## :pushpin: MainActivity.java

    @Override  
	  protected void onCreate(Bundle savedInstanceState) {  
	        super.onCreate(savedInstanceState);  
	  setContentView(R.layout.activity_main);  
	  
	  String android = "android";  
	  
	  Log.e("MainActivity : ", android); // 앱이 실행될 때 로그 출력  
	  
	  int a = 10;  
	  
	  Log.e("MainActivity", String.valueOf(a));  
	  
	  }  
	}

### Log를 출력하는 코드

<br>

### < 출력 > 
<image src="https://user-images.githubusercontent.com/34594339/93419160-19ab1e00-f8e7-11ea-9873-39a947568ac3.png" width="80%">
<br>
