# :dart: ThreadExample

<image src="https://user-images.githubusercontent.com/34594339/93421677-f7b49a00-f8ec-11ea-8ab9-eac1dd026dcd.png" width="35%">
<br>


## :pushpin: MainActivity.java

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // thread === > 백그라운드에서 사용할 수 있게 해준다.

        // thread start
        btn_start = (Button)findViewById(R.id.btn_start);
        btn_exit = (Button)findViewById(R.id.btn_exit);

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                isThread = true;
                thread = new Thread() {
                    public void run(){
                        System.out.println("thread start");
                        while (isThread){
                            try {
                                sleep(5000); // 5초동안 sleep
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            handler.sendEmptyMessage(0);
                        }
                    }
                };
                thread.start();
            }
        });

        // thread exit
        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isThread = false; // 백그라운드에서 실행되고 있던 thread 시작 onclick 함수의 반복문 종료
            }
        });
    }

### 버튼을 연결&Thread를 호출/중지하는 코드

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            Toast.makeText(getApplicationContext(), "hello world", Toast.LENGTH_SHORT).show();
        }
    };

### Handler를 이용하여 Thread 시작 시 Toast를 띄우는 코드

<br>
