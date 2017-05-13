package com.zwonb.percentlayout;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Created by bin on 2017/5/13.
 */

public class Test extends FrameLayout {

    public Test(@NonNull Context context) {
        super(context);
        initView(context);
    }

    public Test(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    private void initView(@NonNull Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.test, this, false);
        addView(inflate);
    }

}
