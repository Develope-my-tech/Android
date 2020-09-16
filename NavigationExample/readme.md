# :dart: Navigation View

## :pushpin: MainActivity

<image src="https://user-images.githubusercontent.com/34594339/93242948-7b259c80-f7c2-11ea-9334-61b40e46f015.png" width="35%">

<br>

## :pushpin: Activity_main_drawer.xml

<image src="https://user-images.githubusercontent.com/34594339/93245022-9b0a8f80-f7c5-11ea-8890-5d3d1e5e1479.png" width="70%">
<br>

## :pushpin: MainActivity.java

### AppBarConfiguration 객체를 이용하여 탐색 버튼을 관리한다.

	mAppBarConfiguration = new AppBarConfiguration.Builder(  
        R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,  
		  R.id.nav_tools, R.id.nav_share, R.id.nav_send) .setDrawerLayout(drawer).build();
		  
 
### "NavController"를 이용하여 AppBarConfiguration 객체를 컨트롤한다.<br>
 
  <image src="https://user-images.githubusercontent.com/34594339/93244608-f7b97a80-f7c4-11ea-83d0-68a1510c9042.png" width="80%">


### 뒤로 가기를 누른 경우

	@Override  
	public void onBackPressed() {  
	    DrawerLayout drawer = (DrawerLayout)findViewById(R.id.drawer_layout );  
	 if (drawer.isDrawerOpen(GravityCompat.START)){  // drawer layout이 열려있다면  
	  drawer.closeDrawer(GravityCompat.START); // 닫아라.  
	  } else {  
	        super.onBackPressed();  
	  }  
	}
