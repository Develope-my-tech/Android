# SharedPreference

## MainActivity.java

	@Override  
	protected void onCreate(Bundle savedInstanceState) {  
	    super.onCreate(savedInstanceState);  
	  setContentView(R.layout.activity_main);  
	  
	  
	  et_save = (EditText) findViewById(R.id.et_save);  
	  
	  SharedPreferences sharedPreferences = getSharedPreferences(shared, 0);  
	  String value = sharedPreferences.getString("home", "");  
	  et_save.setText(value);  
	  
	}

### "home"가 key인 sharedpreferences가 있다면 string을 가져오고, 없다면 디폴트 값이 ""을  value에 저장한다.<br>
### 그 value 값을 EditTextView인 et_save에 저장한다. <br>

	@Override  
	protected void onDestroy() {    // 액티비티가 파괴될 때 호출되는 함수  
	  super.onDestroy();  
	  
	  SharedPreferences sharedPreferences = getSharedPreferences(shared, 0);  
	  SharedPreferences.Editor editor = sharedPreferences.edit();  
	  String value = et_save.getText().toString();  
	  editor.putString("home", value);  
	  editor.commit(); // 액티비티를 나갈 때 edittext의 내용을 저장  
	}

### activity가 파괴될 때 호출되는 함수로, commit()을 통해 액티비티가 나갈 때 editText의 내용을 저장한다. <br>
### 다시 액티비티를 실행할 때 저장되있던 값이 다시 들어간다.