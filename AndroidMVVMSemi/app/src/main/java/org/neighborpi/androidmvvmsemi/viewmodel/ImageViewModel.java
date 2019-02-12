package org.neighborpi.androidmvvmsemi.viewmodel;

import android.content.Context;
import android.content.res.Resources;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.support.v4.content.ContextCompat;

import org.neighborpi.androidmvvmsemi.R;

public class ImageViewModel implements IBaseViewModel {
    private Context context;
    public final ObservableField<Drawable> realImg = new ObservableField<>();
    public final ObservableField<Drawable> blurImg = new ObservableField<>();

    public ImageViewModel(Context context) {
        this.context = context;
    }

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

    public void start() {
        int resId = R.mipmap.ic_launcher;
        Resources resources = context.getResources();
        realImg.set(ContextCompat.getDrawable(context, resId));
        Bitmap bitmap = BitmapFactory.decodeResource(resources, resId);

        RenderScript rs = RenderScript.create(context);
        Allocation input = Allocation.createFromBitmap(rs, bitmap);
        Allocation output = Allocation.createTyped(rs, input.getType());
        ScriptIntrinsicBlur script = ScriptIntrinsicBlur.create(rs, Element.U8_4(rs));
        script.setRadius(15.f);
        script.setInput(input);
        script.forEach(output);
        output.copyTo(bitmap);

        blurImg.set(new BitmapDrawable(resources, bitmap));
    }
}
