package com.zwonb.percentlayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.percent.PercentLayoutHelper;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * The attributes that you can use are:
 * <ul>
 * <li>{@code layout_widthPercent}
 * <li>{@code layout_heightPercent}
 * <li>{@code layout_marginPercent}
 * <li>{@code layout_marginLeftPercent}
 * <li>{@code layout_marginTopPercent}
 * <li>{@code layout_marginRightPercent}
 * <li>{@code layout_marginBottomPercent}
 * <li>{@code layout_marginStartPercent}
 * <li>{@code layout_marginEndPercent}
 * <li>{@code layout_aspectRatio} 根据长比高的比例自动计算尺寸
 * </ul>
 * <p>
 * Created by zyb on 2017/5/9.
 */

public class PercentLinearLayout extends LinearLayout {

    private PercentLayoutHelper mHelper;

    public PercentLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        mHelper = new PercentLayoutHelper(this);
    }

//    @Override
//    protected LayoutParams generateDefaultLayoutParams() {
//        return new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
//    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new LayoutParams(getContext(), attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        mHelper.adjustChildren(widthMeasureSpec, heightMeasureSpec);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (mHelper.handleMeasuredStateTooSmall()) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        mHelper.restoreOriginalParams();
    }

    public static class LayoutParams extends LinearLayout.LayoutParams
            implements PercentLayoutHelper.PercentLayoutParams {
        private PercentLayoutHelper.PercentLayoutInfo mPercentLayoutInfo;

        public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            mPercentLayoutInfo = PercentLayoutHelper.getPercentLayoutInfo(c, attrs);
        }

        public LayoutParams(int width, int height) {
            super(width, height);
        }

        public LayoutParams(ViewGroup.LayoutParams source) {
            super(source);
        }

        public LayoutParams(MarginLayoutParams source) {
            super(source);
        }

//        public LayoutParams(LinearLayout.LayoutParams source) {
//            super((MarginLayoutParams) source);
//            gravity = source.gravity;
//        }

        @Override
        public PercentLayoutHelper.PercentLayoutInfo getPercentLayoutInfo() {
            if (mPercentLayoutInfo == null) {
                mPercentLayoutInfo = new PercentLayoutHelper.PercentLayoutInfo();
            }
            return mPercentLayoutInfo;
        }

        @Override
        protected void setBaseAttributes(TypedArray a, int widthAttr, int heightAttr) {
            PercentLayoutHelper.fetchWidthAndHeight(this, a, widthAttr, heightAttr);
        }

    }

}

