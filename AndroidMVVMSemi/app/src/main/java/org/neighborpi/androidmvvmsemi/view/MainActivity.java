package org.neighborpi.androidmvvmsemi.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import org.neighborpi.androidmvvmsemi.ImageActivity;
import org.neighborpi.androidmvvmsemi.viewmodel.ICallAnotherActivityNavigator;
import org.neighborpi.androidmvvmsemi.viewmodel.IToast;
import org.neighborpi.androidmvvmsemi.viewmodel.MainViewModel;
import org.neighborpi.androidmvvmsemi.R;
import org.neighborpi.androidmvvmsemi.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements ICallAnotherActivityNavigator, IToast {

    //private MainViewModel model = new MainViewModel(this, this);
    private MainViewModel model = new MainViewModel(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setModel(model);
        model.onCreate();
    }

    @Override
    protected void onResume() {
        super.onResume();
        model.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        model.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        model.onDestory();
    }

    @Override
    public void callActivity(int activityId) {
        if(activityId == MainViewModel.INPUT_ACTIVITY_ID.get()){
            startActivity(new Intent(getApplicationContext(), InputActivity.class));
        }
        else if(activityId == MainViewModel.LISTVIEW_ACTIIVITY_ID.get()){
            startActivity(new Intent(getApplicationContext(), ListActivity.class));
            //startActivity(new Intent(getApplicationContext(), ListActivity.class));
        } else if (activityId == MainViewModel.IMAGE_ACTIVITY_ID.get()) {
            startActivity(new Intent(getApplicationContext(), ImageActivity.class));
        } else {
            model.errorToast();
        }
        /*switch (activityId) {
            case MainViewModel.INPUT_ACTIVITY_ID.get():
                startActivity(new Intent(getApplicationContext(), InputActivity.class));
                break;
            case MainViewModel.LISTVIEW_ACTIIVITY_ID.get():
                startActivity(new Intent(getApplicationContext(), ListActivity.class));
                break;
            default:
                model.errorToast();
                break;
        }*/
    }

    @Override
    public void callFragment(int fragmentId) {
        FragmentManager manager = getSupportFragmentManager();
        if(fragmentId == MainViewModel.INPUT_FRAGMENT_ID.get()){
            InputFragment fragment = new InputFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.container, fragment).commit();
        }
    }

    @Override
    public void toast(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }
}
