package org.neighborpi.androidmvvmsemi;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.neighborpi.androidmvvmsemi.databinding.ActivityImageBinding;
import org.neighborpi.androidmvvmsemi.viewmodel.ImageViewModel;

public class ImageActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityImageBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_image);
        binding.setModel(new ImageViewModel(getApplicationContext()));
        //setContentView(R.layout.activity_image);
    }
}
