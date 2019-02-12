package org.neighborpi.androidmvvmsemi.view;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import org.neighborpi.androidmvvmsemi.R;
import org.neighborpi.androidmvvmsemi.databinding.ActivityListBinding;
import org.neighborpi.androidmvvmsemi.viewmodel.UserListViewAdapter;
import org.neighborpi.androidmvvmsemi.viewmodel.UserViewModel;
import org.neighborpi.androidmvvmsemi.viewmodel.UsersViewModel;

public class ListActivity extends AppCompatActivity {

    private UsersViewModel usersViewModel = new UsersViewModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityListBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_list);
        binding.setModel(usersViewModel);
        usersViewModel.onCreate();
        // 이렇게 해도 잘된단다
        // ViewDataBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_list);
        // binding.setVariable(BR.model, usersViewModel);

        //setContentView(R.layout.activity_list);
    }


    // setUserList()는 액티비티에 들어가도 되고, ViewModel에 들어가도 되는데
    // 같은 뷰 모델을 여기서는 리스트 뷰, 다른 곳에서는 리사이클 뷰를 쓴다면
    // 아무래도 액티비티에 넣는 것이 나을 것 같다
    @BindingAdapter("app:items")
    public static void setUserList(ListView listView, ObservableArrayList<UserViewModel> users) {
        UserListViewAdapter adapter;

        if (listView.getAdapter() == null) {
            adapter = new UserListViewAdapter();
            listView.setAdapter(adapter);
        } else{
            adapter = (UserListViewAdapter) listView.getAdapter();
        }
        adapter.addAll(users);

    }
}
