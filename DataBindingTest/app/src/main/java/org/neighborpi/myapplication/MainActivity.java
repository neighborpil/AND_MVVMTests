package org.neighborpi.myapplication;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import org.neighborpi.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    public String tvString ="시작하기2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setActivity(this);

        binding.btnStart.setText("버튼");
        //setContentView(R.layout.activity_main);
    }

    public void nextActivity(View view){
        Intent intent = new Intent(MainActivity.this, WriteMemoActivity.class);
        startActivity(intent);
    }
}
