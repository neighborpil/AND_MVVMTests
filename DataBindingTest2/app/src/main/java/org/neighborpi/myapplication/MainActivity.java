package org.neighborpi.myapplication;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import org.neighborpi.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    public static final String APP_NAME = "데이터바인딩";

    public ActivityMainBinding binding;
    //public String btnMemoOpen = "메모열기";
    public String tvString = "시작하기2";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setActivity(this);
        binding.btnStart.setText("메모열기");
        binding.setMemo(new MemoData("타이틀", "콘텐츠"));
        //setContentView(R.layout.activity_main);
    }

    public void nextActivity(View view){
        Intent intent = new Intent(MainActivity.this, WriteMemoActivity.class);
        startActivity(intent);
    }

    /*// onLongClick 이벤트 같은 경우 리턴타입이 boolean 이기 때문에, 메소드 생성시 리턴타입을 boolean으로 생성해야합니다.
    public boolean nextActivity2(View view){
        Intent intent = new Intent(MainActivity.this, WriteMemoActivity.class);
        startActivity(intent);
        return false;
    }*/


    public void sendMemoData(MemoData memoData){
        Log.d("Test", "title:" + memoData.getTitle() + ", content:" + memoData.getContent());
        binding.tvContent.setText("title:" + memoData.getTitle() + ", content:" + memoData.getContent());
    }
}
