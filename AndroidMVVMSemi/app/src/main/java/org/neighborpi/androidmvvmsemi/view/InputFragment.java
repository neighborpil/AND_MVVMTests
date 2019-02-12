package org.neighborpi.androidmvvmsemi.view;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.neighborpi.androidmvvmsemi.R;
import org.neighborpi.androidmvvmsemi.databinding.ActivityInputBinding;
import org.neighborpi.androidmvvmsemi.viewmodel.IToast;
import org.neighborpi.androidmvvmsemi.viewmodel.InputViewModel;


/**
 * A simple {@link Fragment} subclass.
 */
public class InputFragment extends Fragment{


    public InputFragment() {
        // Required empty public constructor
    }

    public static InputFragment instance(){
        return new InputFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return DataBindingUtil.inflate(inflater, R.layout.activity_input, container, false).getRoot();
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_input, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        InputViewModel model = new InputViewModel();
        ActivityInputBinding binding = DataBindingUtil.getBinding(getView());
        binding.setModel(model);
        model.onCreate();
    }
}
