package org.neighborpi.myapplication;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.neighborpi.myapplication.databinding.ActivityWriteMemoBinding;

public class WriteMemoActivity extends AppCompatActivity {

    ActivityWriteMemoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setActivity(this);
        binding.setMemo(new MemoData("ㅈㅈㅈ", "ㅋㅋㅋ"));

        //setContentView(R.layout.activity_write_memo);
    }
}
