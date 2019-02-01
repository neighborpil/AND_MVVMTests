package org.neighborpi.androidmvvmsemi;

import android.databinding.ObservableField;
import android.view.View;

public class MainViewModel implements BaseViewModel {

    public final ObservableField<String> helloText = new ObservableField<>();

    @Override
    public void onCreate() {
        helloText.set("hello!");
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onDestory() {

    }

    public  void showCurrentTime(){
        helloText.set(String.valueOf(System.currentTimeMillis()));
    }
    public View.OnClickListener currentTime2ClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            showCurrentTime();
        }
    };
}
