
# :dart: Camera Activity

## :pushpin: build.gradle(app)의 dependencies

	implementation 'gun0912.ted:tedpermission:2.0.0'

### tedpermission : 안드로이드 권한을 묻는 창을 띄운다.

<br>

## MainActivity.java

###  권한 팝업 알려주는 코드

	TedPermission.with(getApplicationContext())  
	        .setPermissionListener(permissionListener)  
	        .setRationaleMessage("카메라 권한이 필요합니다.") // 카메라 권한 팝업을 알려줄 때  
	  .setDeniedMessage("거부하셨습니다.")   // 권한을 거부 했을 때  
	  .setPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA);

<br>

### 카메라 액티비티를 띄우는 코드

	findViewById(R.id.btn_capture).setOnClickListener(new View.OnClickListener() {  
	    @Override  
	  public void onClick(View v) {  
	        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);  	// 이미지 촬영을 띄운다.
	 if (intent.resolveActivity(getPackageManager())!=null){  
	            File photoFile = null;  
	 try{  
	                photoFile = createImageFile();  
	  } catch (IOException e){  
	  
	            }  
	  
	            if (photoFile!=null){  
	                photoUri = FileProvider.getUriForFile(getApplicationContext(), getPackageName(), photoFile);  
	  intent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);  
	  startActivityForResult(intent, REQUEST_IMAGE_CAPTURE); // 다음 액티비티로부터 값을 가져오는 역할을 수행  (onActivityResult로 이동)
	  }  
	        }  
	    }  
	});

<br>

### 화면이 회전하는 경우 각도를 알려주는 코드

	private int exifOrientationToDegrees(int exifOrientation){  
	    if (exifOrientation==ExifInterface.ORIENTATION_ROTATE_90){  
	        return 90;  
	  } else if (exifOrientation==ExifInterface.ORIENTATION_ROTATE_180){  
	        return 180;  
	  } else if (exifOrientation==ExifInterface.ORIENTATION_ROTATE_270){  
	        return 270;  
	  }  
	    return 0;  
	}

## AndroidManifest.xml

### provider 추가 : App 내부 폴더의 파일을 외부 APP에 공유
  
	<provider  
	  android:authorities="com.example.cameraexample"  
	  android:name="androidx.core.content.FileProvider"  
	  android:exported="false"  
	  android:grantUriPermissions="true">  
	  
	 <meta-data  android:name="android.support.FILE_PROVIDER_PATHS"  
	  android:resource="@xml/file_paths"/>  
	</provider>

<br>

## file_path.xml

	<?xml version="1.0" encoding="utf-8"?>  
	<paths xmlns:android="http://schemas.android.com/apk/res/android">  
	<external-path  
	  name="my_images"  
	  path="Android/data/com.example.cameraexample/files/Pictures"/>  
	</paths>