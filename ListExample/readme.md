# ListView

## Main Activity
<image src="https://user-images.githubusercontent.com/34594339/93245601-7f53b900-f7c6-11ea-9b19-f43b3fc4f957.png" width="35%">
<br>

## Activity_main.xml

<image src="https://user-images.githubusercontent.com/34594339/93245751-b629cf00-f7c6-11ea-914a-f47af360401f.png" width="70%">

### 1. <LinearLayout : LinearLayout 설정 <br>
### 2. android:id="@+id/list" : 리스트뷰의 id를 list로 설정<br>

<br>

## MainActivity.java

<image src="https://user-images.githubusercontent.com/34594339/93246042-246e9180-f7c7-11ea-8727-f684b5e14199.png" width="70%">

### 1. ArrayList<String>를 만든다. <br>
### 2. ArrayAdapter를 이용하여 ArrayList 배열과 ListView를 연결한다. (이때, 안드로이드에서 제공하는 리스트 뷰 형식인 android.R.layout.simple_list_item_1을 사용하였다.)
### 3. data를 모두 추가한 뒤, notifyDataSetChanged()를 통해 저장 완료