
# :dart: RecylerView

<image src="https://user-images.githubusercontent.com/34594339/93327518-6cd49080-f855-11ea-950e-e934470dc528.png" width="35%"> <image src="https://user-images.githubusercontent.com/34594339/93327543-7827bc00-f855-11ea-85e7-a86cc758a423.png" width="35%">

### ⇒ 추가 하면 RecyclerView에 생성 / 한번 클릭하면 Toast 실행(우측 화면) / 길게 누르면 삭제

<br>

## :pushpin: build.gradle(app)의 dependencies

	implementation 'androidx.recyclerview:recyclerview:1.1.0'

### recyclerview를 사용하기 위하여  gradle에 추가한다.

<br>

## :pushpin: Activity_main.xml

	<?xml version="1.0" encoding="utf-8"?>  
	<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"  
	  xmlns:app="http://schemas.android.com/apk/res-auto"  
	  xmlns:tools="http://schemas.android.com/tools"  
	  android:orientation="vertical"  
	  android:layout_width="match_parent"  
	  android:layout_height="match_parent"  
	  tools:context=".MainActivity">  
	     <androidx.recyclerview.widget.RecyclerView  
	  android:layout_width="match_parent"  
	  android:layout_height="match_parent"  
	  android:id="@+id/rv"  
	  android:scrollbarFadeDuration="0"  
	  android:scrollbarSize="5dp"  
	  android:scrollbarThumbVertical="@android:color/darker_gray"  
	  android:scrollbars="vertical"  
	  android:layout_weight="1"></androidx.recyclerview.widget.RecyclerView>  
	  
	 <Button  android:id="@+id/btn_add"  
	  android:layout_weight="8"  
	  android:layout_width="match_parent"  
	  android:layout_height="match_parent"  
	  android:text="추가" />  
	</LinearLayout>

### recyclerView를 추가하고, 버튼을 추가<br>
### scrollbarThumbVertical : 스크롤바 색상<br>
###  layout_weight : 레이아웃의 고정 비율을 1로 설정 ⇒ [[참고]](https://yoo-hyeok.tistory.com/56)

<br>

## :pushpin: item_list.xml

### recycle view에 생성할 레이아웃을 만든다.

	<?xml version="1.0" encoding="utf-8"?>  
	<LinearLayout  
	  xmlns:android="http://schemas.android.com/apk/res/android" android:layout_width="match_parent"  
	  android:layout_height="wrap_content">  
	  
	 <LinearLayout  android:layout_width="match_parent"  
	  android:layout_height="wrap_content"  
	  android:orientation="horizontal">  
	  
	 <ImageView  android:id="@+id/iv_profile"  
	  android:layout_width="wrap_content"  
	  android:layout_height="wrap_content"  
	  android:src="@mipmap/ic_launcher"/>  
	  
	 <LinearLayout  android:layout_width="match_parent"  
	  android:layout_height="match_parent"  
	  android:gravity="center_vertical"  
	  android:orientation="vertical">  
	 <TextView  android:id="@+id/tv_name"  
	  android:layout_width="match_parent"  
	  android:layout_height="wrap_content"  
	  android:text="안드로이드 연습"/>  
	  
	 <TextView  android:id="@+id/tv_content"  
	  android:layout_width="match_parent"  
	  android:layout_height="wrap_content"  
	  android:text="리사이클러뷰"/>  
	 </LinearLayout> </LinearLayout>  
	</LinearLayout>
  
<br>

## :pushpin: MainData.java

<image src="https://user-images.githubusercontent.com/34594339/93323386-82df5280-f84f-11ea-8711-483e9817ffc6.png" width="60%">

### Alt + Insert 키 누르면 generate 창이 열린다.

	package com.example.recyclerviewexample;  
	  
	public class MainData {  
	  
	    private int iv_profile;  
	 private String tv_name;  
	 private String tv_content;  
	  
	 public MainData(int iv_profile, String tv_name, String tv_content) {  
	        this.iv_profile = iv_profile;  
	 this.tv_name = tv_name;  
	 this.tv_content = tv_content;  
	  }  
	  
	    public int getIv_profile() {  
	        return iv_profile;  
	  }  
	  
	    public void setIv_profile(int iv_profile) {  
	        this.iv_profile = iv_profile;  
	  }  
	  
	    public String getTv_name() {  
	        return tv_name;  
	  }  
	  
	    public void setTv_name(String tv_name) {  
	        this.tv_name = tv_name;  
	  }  
	  
	    public String getTv_content() {  
	        return tv_content;  
	  }  
	  
	    public void setTv_content(String tv_content) {  
	        this.tv_content = tv_content;  
	  }  
	}

### 생성자와 Getter(), Setter() 생성

<br>

## :pushpin: MainAdapter. java

### ``Adapter`` 란 데이터 테이블을 목록 형태로 보여주기 위하여 사용되는 것으로 데이터와 리스트 뷰 사이에 존재하는 객체이다. <br>

### Long Click을 눌렀을 때 adapt view를 삭제


	@Override  
	public void onBindViewHolder(@NonNull final MainAdapter.CustomViewHolder holder, int position) {  // 추가 될 때 생명 주기  
	  
	  holder.iv_profile.setImageResource(arrayList.get(position).getIv_profile());  
	  holder.tv_name.setText(arrayList.get(position).getTv_name());  
	  holder.tv_content.setText(arrayList.get(position).getTv_content());  
	  
	  // 리스트 뷰가 클릭 되었을때  
	  
	  holder.itemView.setTag(position);  
	  holder.itemView.setOnClickListener(new View.OnClickListener(){  
	  
	        @Override  
	  public void onClick(View v) {  
	            String curName = holder.tv_name.getText().toString(); // 현재 클릭한 아이템을 가져옴  
	  Toast.makeText(v.getContext(), curName, Toast.LENGTH_SHORT).show();  
	  }  
	    });  
	  
	  holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {  
	        @Override  
	  public boolean onLongClick(View v) {  
	            remove(holder.getAdapterPosition());  
	 return false;  }  
	    });  
	}

	public void remove(int position) {  
	    try{  
	        arrayList.remove(position);  
	  notifyItemRemoved(position); // 새로 고침  
	  } catch (IndexOutOfBoundsException ex) {  
	        ex.printStackTrace();  
	  }  
	}

<br>

## :pushpin: MainActivity.java


	@Override  
	protected void onCreate(Bundle savedInstanceState) {  
	    super.onCreate(savedInstanceState);  
	  setContentView(R.layout.activity_main);  
	  
	  recyclerView = (RecyclerView)findViewById(R.id.rv);  
	  linearLayoutManager = new LinearLayoutManager(this);  
	  recyclerView.setLayoutManager(linearLayoutManager);  
	  
	  arrayList = new ArrayList<>();  
	  mainAdapter = new MainAdapter(arrayList);  
	  recyclerView.setAdapter(mainAdapter);  
	  
	  Button btn_add = (Button)findViewById(R.id.btn_add);  
	  btn_add.setOnClickListener(new View.OnClickListener() {  
	        @Override  
	  public void onClick(View v) {  
	            MainData mainData = new MainData(R.mipmap.ic_launcher, "안드로이드", "recycler view");  
	  arrayList.add(mainData);  
	  mainAdapter.notifyDataSetChanged(); // 새로 고침 완료  
	  }  
	    });  
	  
	}

### 추가 버튼을 누르면 recyclerView에 data를 추가
