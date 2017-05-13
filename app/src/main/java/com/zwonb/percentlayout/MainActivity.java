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
    private TextView left;
    private TextView right;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        top_view = (TextView) findViewById(R.id.top_view);
        left = (TextView) findViewById(R.id.left);
        right = (TextView) findViewById(R.id.right);
        left_view = (TextView) findViewById(R.id.left_view);
        right_view = (TextView) findViewById(R.id.right_view);

        top_view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        left.getViewTreeObserver().addOnGlobalLayoutListener(this);
        right.getViewTreeObserver().addOnGlobalLayoutListener(this);
        left_view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        right_view.getViewTreeObserver().addOnGlobalLayoutListener(this);

        ((LinearLayout)findViewById(R.id.add_view_layout)).addView(new Test(this));
    }

    @Override
    public void onGlobalLayout() {
        top_view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        top_view.setText("aspectRatio=300%,width=" + top_view.getWidth()
                + ",height=" + top_view.getHeight());

        left.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        LinearLayout.LayoutParams leftLayoutParams = (LinearLayout.LayoutParams) left.getLayoutParams();
        left.setText("aspectRatio=100%,width=" + left.getWidth()
                + ",height=" + left.getHeight()
                + ",ml=" + leftLayoutParams.leftMargin
                + ",mt=" + leftLayoutParams.topMargin
                + ",mr=" + leftLayoutParams.rightMargin
                + ",mb=" + leftLayoutParams.bottomMargin);

        right.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        LinearLayout.LayoutParams rightLayoutParams = (LinearLayout.LayoutParams) right.getLayoutParams();
        right.setText("aspectRatio=100%,width=" + right.getWidth()
                + ",height=" + right.getHeight()
                + ",ml=" + rightLayoutParams.leftMargin
                + ",mt=" + rightLayoutParams.topMargin
                + ",mr=" + rightLayoutParams.rightMargin
                + ",mb=" + rightLayoutParams.bottomMargin);

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
