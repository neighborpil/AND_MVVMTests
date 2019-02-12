package org.neighborpi.androidmvvmsemi.view;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import org.neighborpi.androidmvvmsemi.viewmodel.IToast;
import org.neighborpi.androidmvvmsemi.viewmodel.InputViewModel;
import org.neighborpi.androidmvvmsemi.R;
import org.neighborpi.androidmvvmsemi.databinding.ActivityInputBinding;

public class  InputActivity extends AppCompatActivity implements IToast {

    private InputViewModel model = new InputViewModel(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityInputBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_input);
        binding.setModel(model);
        model.onCreate();

        //setContentView(R.layout.activity_input);
    }

    @Override
    public void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

}
