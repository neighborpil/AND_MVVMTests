package org.neighborpi.androidmvvmsemi.viewmodel;

import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.view.View;

import org.neighborpi.androidmvvmsemi.view.MainActivity;

public class MainViewModel implements IBaseViewModel {

    public static final ObservableInt INPUT_ACTIVITY_ID = new ObservableInt(0);
    public static final ObservableInt LISTVIEW_ACTIIVITY_ID = new ObservableInt(1);
    public static final ObservableInt INPUT_FRAGMENT_ID = new ObservableInt(2);
    public static final ObservableInt IMAGE_ACTIVITY_ID = new ObservableInt(3);

    public final ObservableField<String> helloText = new ObservableField<>();
    private ICallAnotherActivityNavigator navigator;
    private IToast toast;

    public MainViewModel(Object obj) {
        MainActivity main = (MainActivity)obj;
        this.navigator = main;
        this.toast = main;
    }

    public MainViewModel(ICallAnotherActivityNavigator navigator, IToast toast) {
        this.navigator = navigator;
        this.toast = toast;
    }

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

    public void callActivity(int activityId){
        navigator.callActivity(activityId);
    }

    public void callFragment(int fragmentId) {
        navigator.callFragment(fragmentId);
    }
    public void errorToast(){
        toast.toast("It's not valid activity id");
    }

}
