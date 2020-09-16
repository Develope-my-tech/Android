# :dart: Fragment Layout

<image src="https://user-images.githubusercontent.com/34594339/93340446-c8a81500-f867-11ea-8610-1d65d79cd4b4.png" width="35%"> <image src="https://user-images.githubusercontent.com/34594339/93340468-cfcf2300-f867-11ea-9a91-024ab531e381.png" width="35%">

### (좌) 메뉴1 버튼 클릭<br>
### (우) 메뉴3 버튼 클릭<br>

<br>


## :pushpin: Activity_main.xml

	<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"  
	  xmlns:app="http://schemas.android.com/apk/res-auto"  
	  xmlns:tools="http://schemas.android.com/tools"  
	  android:layout_width="match_parent"  
	  android:layout_height="match_parent"  
	  tools:context=".MainActivity">  
	  
	 <FrameLayout  android:id="@+id/frame"  
	  android:layout_width="match_parent"  
	  android:layout_height="match_parent">  
	     </FrameLayout>  
	 <LinearLayout  android:layout_width="match_parent"  
	  android:layout_height="50dp"  
	  android:layout_alignParentBottom="true">  
	  
	 <Button  android:id="@+id/btn_1"  
	  android:layout_width="wrap_content"  
	  android:layout_height="wrap_content"  
	  android:layout_weight="1"  
	  android:text="메뉴1"/>  
	  
	 <Button  android:id="@+id/btn_2"  
	  android:layout_width="wrap_content"  
	  android:layout_height="wrap_content"  
	  android:layout_weight="1"  
	  android:text="메뉴2"/>  
	  
	 <Button  android:id="@+id/btn_3"  
	  android:layout_width="wrap_content"  
	  android:layout_height="wrap_content"  
	  android:layout_weight="1"  
	  android:text="메뉴3"/>  
	  
	 <Button  android:id="@+id/btn_4"  
	  android:layout_width="wrap_content"  
	  android:layout_height="wrap_content"  
	  android:layout_weight="1"  
	  android:text="메뉴4"/>  
	  
	 </LinearLayout></RelativeLayout>

### RelativeLayout으로 설정 & Fragment를 사용하기 위해FramLayout 설정 &  LinearLayout 안에 button 4개 설정

<br>

## :pushpin: fragment1.xml / fragment2.xml

	<?xml version="1.0" encoding="utf-8"?>  
	<FrameLayout  
	  xmlns:android="http://schemas.android.com/apk/res/android" android:layout_width="match_parent"  
	  android:layout_height="match_parent">  
	  
	 <TextView  android:layout_width="wrap_content"  
	  android:layout_height="wrap_content"  
	  android:textSize="30sp"  
	  android:text="Frame Layout fragment1"/>  
	  
	</FrameLayout>

<br>

## :pushpin: MainActivity.java

	public class MainActivity extends AppCompatActivity {  
	    Button btn1, btn2, btn3, btn4;  
	  
	  @Override  
	  protected void onCreate(Bundle savedInstanceState) {  
	        super.onCreate(savedInstanceState);  
	  setContentView(R.layout.activity_main);  
	  
	  btn1 = (Button)findViewById(R.id.btn_1);  
	  btn2 = (Button)findViewById(R.id.btn_2);  
	  btn3 = (Button)findViewById(R.id.btn_3);  
	  btn4 = (Button)findViewById(R.id.btn_4);  
	  
	  btn1.setOnClickListener(new View.OnClickListener() {  
	   @Override  
	  public void onClick(View v) {  
	      FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();  
		  Fragment1 fragment1 = new Fragment1();  
		  transaction.replace(R.id.frame, fragment1); // 조각을 교체해라 	 
		  transaction.commit(); // 저장  
	  }  
	});
	}
### Button 4개 생성

<br>

## :pushpin: Fragment1.java

	public class Fragment1 extends Fragment {  
	
	public Fragment1(){  
	  
	}

	@Nullable  
	@Override  
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {  
	    return super.onCreateView(inflater, container, savedInstanceState);  
	}
	}

### - Fragment 상속<br>
### - onCreateView() : ``ctrl+o`` 로 자동 생성. MainActivity의 onCreate()와 같은 fragment의 생명주기.<br>
