package org.neighborpi.androidmvvmsemi.viewmodel;

import android.databinding.Observable;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.RatingBar;

public class InputViewModel implements IBaseViewModel {

    private IToast toast;
    public final ObservableField<String> name = new ObservableField<>();
    public final ObservableField<String> email = new ObservableField<>();
    public final ObservableInt score = new ObservableInt();
    public final ObservableBoolean isValid = new ObservableBoolean();

    public InputViewModel(){

    }

    public InputViewModel(IToast toast){
        this.toast = toast;
    }

    @Override
    public void onCreate() {
        score.set(0);
        isValid.set(false);

        name.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                validation();
            }
        });
        email.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                validation();
            }
        });
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

    private void validation(){
        boolean isValidName = !TextUtils.isEmpty(name.get());
        boolean isValidEmail = !TextUtils.isEmpty(email.get()) && Patterns.EMAIL_ADDRESS.matcher(email.get()).matches();
        boolean isValidScore = score.get() > 0;
        isValid.set(isValidName && isValidEmail && isValidScore);
    }

    public RatingBar.OnRatingBarChangeListener scoreChangeListener = new RatingBar.OnRatingBarChangeListener() {
        @Override
        public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
            score.set((int) v);
            validation();
        }
    };

    public void toast() {
        if(this.toast != null){
            String result = "Name:" + this.name.get() + ", Email: " + this.email.get() + ", Rating:" + this.score.get();
            toast.toast(result);
        }
    }
}
