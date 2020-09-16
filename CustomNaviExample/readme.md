# :dart: Custom Navigation Menu

## :pushpin: MainActivity

<image src="https://user-images.githubusercontent.com/34594339/93285999-19d8ea00-f811-11ea-9d98-a763679b5ea5.png" width="35%"> <image src="https://user-images.githubusercontent.com/34594339/93286054-383ee580-f811-11ea-9814-88d2504327d7.png" width="34%">

<br>

## :pushpin: Activity_drawer.xml
### 버튼 / 텍스트 뷰 만들기 
	<Button  
	  android:id="@+id/btn_close"  
	  android:layout_width="match_parent"  
	  android:layout_height="wrap_content"  
	  android:text="메뉴 닫기"/>  
	<TextView  
	  android:layout_width="match_parent"  
	  android:layout_height="wrap_content"  
	  android:gravity="center"  
	  android:text="메뉴"/>  
	  
	<LinearLayout  
	  android:layout_width="match_parent"  
	  android:layout_height="wrap_content"  
	  android:background="#513C75"  
	  android:layout_margin="10dp"  
	  android:orientation="vertical">  
	  
	 <TextView  android:layout_width="match_parent"  
	  android:layout_height="wrap_content"  
	  android:gravity="center"  
	  android:text="테스트 내용"/>

### ⇒ LinearLayout을 안에서 재생성

<image src="https://user-images.githubusercontent.com/34594339/93286276-d468ec80-f811-11ea-822f-3fc8423cb78c.png" width="70%">

#### 왼쪽 색깔을 두번 클릭하여 변경이 가능하다.

<br>

## :pushpin: Activity_main.xml

### drawerlayout으로 생성

	<?xml version="1.0" encoding="utf-8"?>  
	<androidx.drawerlayout.widget.DrawerLayout 
	  
	</androidx.drawerlayout.widget.DrawerLayout>


### LinearLayout에 버튼 생성 및 Activity_drawer layout 을 activity_main.xml에 추가

	<LinearLayout  
	  android:layout_width="match_parent"  
	  android:layout_height="match_parent">  
	 <Button  android:id="@+id/btn_open"  
	  android:layout_width="match_parent"  
	  android:layout_height="wrap_content"  
	  android:text="열려라 참깨"/>  
	</LinearLayout>  
	<include layout="@layout/activity_drawer"/>

<br>

## :pushpin: MainActivity.java

### 닫기 / 열기 버튼

	Button btn_close = (Button) findViewById(R.id.btn_close);  
	btn_close.setOnClickListener(new View.OnClickListener() {  
	    @Override  
	  public void onClick(View v) {  
	        drawerLayout.closeDrawers();  
	  }  
	});  
	  
	Button btn_open = (Button) findViewById(R.id.btn_open);  
	btn_open.setOnClickListener(new View.OnClickListener() {  
	    @Override  
	  public void onClick(View v) {  
	        drawerLayout.openDrawer(drawerView);  
	  }  
	});

### DrawerLayout의 listener

	drawerLayout.setDrawerListener(listner);  
	drawerView.setOnTouchListener(new View.OnTouchListener() {  
	    @Override  
	  public boolean onTouch(View v, MotionEvent event) {  
	        return true;  
	  }  
	});

#### ⇒ onCreate 안에 생성

	// DrawLayout에서 상태값을 받아와 호출되는 함수들  
	DrawerLayout.DrawerListener listner = new DrawerLayout.DrawerListener() {  
	    @Override  
	  public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {  
	  
	    }  
	  
	    @Override  
	  public void onDrawerOpened(@NonNull View drawerView) {  
	  
	    }  
	  
	    @Override  
	  public void onDrawerClosed(@NonNull View drawerView) {  
	  
	    }  
	  
	    @Override  
	  public void onDrawerStateChanged(int newState) {  
	  
	    }  
	};

#### ⇒ onCreate 밖에 생성