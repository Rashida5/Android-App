package com.example.aboutme;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class myFont extends androidx.appcompat.widget.AppCompatTextView {

    @RequiresApi(api = Build.VERSION_CODES.P)
    public myFont(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.setTypeface(Typeface.create(Typeface.DEFAULT,400,false));
    }
}
