package com.zwonb.percentlayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ViewTreeObserver.OnGlobalLayoutListener {

    private TextView top_view;
    private TextView left_view;
    private TextView right_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        top_view = (TextView) findViewById(R.id.top_view);
        left_view = (TextView) findViewById(R.id.left_view);
        right_view = (TextView) findViewById(R.id.right_view);

        top_view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        left_view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        right_view.getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    @Override
    public void onGlobalLayout() {
        top_view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        top_view.setText("aspectRatio=298%,width=" + top_view.getWidth()
                + ",height=" + top_view.getHeight());

        left_view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        LinearLayout.LayoutParams leftParams = (LinearLayout.LayoutParams) left_view.getLayoutParams();
        left_view.setText("aspectRatio=100%,width=" + left_view.getWidth()
                + ",height=" + left_view.getHeight()
                + ",ml=" + leftParams.leftMargin
                + ",mt=" + leftParams.topMargin
                + ",mr=" + leftParams.rightMargin
                + ",mb=" + leftParams.bottomMargin);

        right_view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        LinearLayout.LayoutParams rightParams = (LinearLayout.LayoutParams) right_view.getLayoutParams();
        right_view.setText("aspectRatio=100%,width=" + right_view.getWidth()
                + ",height=" + right_view.getHeight()
                + ",ml=" + rightParams.leftMargin
                + ",mt=" + rightParams.topMargin
                + ",mr=" + rightParams.rightMargin
                + ",mb=" + rightParams.bottomMargin);

    }
}
