package org.neighborpi.androidmvvmsemi.viewmodel;

import android.databinding.ObservableArrayList;

import org.neighborpi.androidmvvmsemi.viewmodel.IBaseViewModel;
import org.neighborpi.androidmvvmsemi.viewmodel.UserViewModel;

import java.util.Random;

public class UsersViewModel implements IBaseViewModel {
    public final ObservableArrayList<UserViewModel> users = new ObservableArrayList<>();

    @Override
    public void onCreate() {

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

    public void newUser(){
        users.add(new UserViewModel("name: " + random(), ", email: " + random()));
    }

    private int random() {
        return new Random().nextInt();
    }
}
