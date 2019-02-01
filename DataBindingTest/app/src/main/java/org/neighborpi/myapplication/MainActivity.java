package org.neighborpi.myapplication;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import org.neighborpi.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    public ActivityMainBinding binding;
    public String tvString ="시작하기2";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setActivity(this);
        //binding.btnStart.setText("버튼");
        //binding.setMemo(new MemoData("제목", "내용"));
        //setContentView(R.layout.activity_main);
    }

//    public void nextActivity(View view){
//        Intent intent = new Intent(MainActivity.this, WriteMemoActivity.class);
//        startActivity(intent);
//    }
//
//    public void sendMemoData(MemoData memoData){
//        Log.e("Test", "title:" + memoData.getTitle() + ", content:" + memoData.getContent());
//    }
}
