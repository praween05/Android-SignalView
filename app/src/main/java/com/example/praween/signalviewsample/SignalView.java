package com.example.praween.signalviewsample;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by praween on 9/9/16.
 */
public class SignalView extends View {
    private int mLineCount = 5;
    private Paint mPaint;
    private int mWidth;
    private int mHeight;
    private int mStroke = 5;
    private float mRadius = 3;
    private int mLineWidth;
    int mSpacing = 10;
    private int mTop;
    private int mPadding = 3;
    private Paint mProgressPaint;
    private int mProgress = 3;
    private Context mContext;
    private int mPrimaryColor = R.color.colorPrimary;
    private int mProgressColor = R.color.colorPrimaryDark;

    public SignalView(Context context) {
        super(context);
        mContext = context;
        init();
    }

    public SignalView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        setAttributes(attrs);
        init();
    }

    public SignalView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        setAttributes(attrs);
        init();
    }

    /**
     * set the default attributes for the view
     *
     * @param attrs
     */
    private void setAttributes(AttributeSet attrs) {
        TypedArray typedArray = mContext.getTheme().obtainStyledAttributes(attrs, R.styleable.SignalView, 0, 0);
        mLineCount = typedArray.getInt(R.styleable.SignalView_line_count, mLineCount);
        mPrimaryColor = typedArray.getInt(R.styleable.SignalView_primary_color, ContextCompat.getColor(mContext, mPrimaryColor));
        mProgressColor = typedArray.getInt(R.styleable.SignalView_progress_color, ContextCompat.getColor(mContext, mProgressColor));
        mProgress = typedArray.getInt(R.styleable.SignalView_progress, mProgress);
        mStroke = typedArray.getInt(R.styleable.SignalView_stroke_width, mStroke);
        mRadius = typedArray.getFloat(R.styleable.SignalView_corner_radius, mRadius);;
        mSpacing = typedArray.getInt(R.styleable.SignalView_line_spacing, mSpacing);;
    }

    @SuppressWarnings("ResourceAsColor")
    private void init() {
        mPaint = new Paint();
        mPaint.setColor(mPrimaryColor);
        mPaint.setDither(false);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(mStroke);
        mPaint.setAntiAlias(true);
        mPaint.setStrokeJoin(Paint.Join.ROUND);

        mProgressPaint = new Paint();
        mProgressPaint.setColor(mProgressColor);
        mProgressPaint.setDither(false);
        mProgressPaint.setStyle(Paint.Style.FILL);
        mProgressPaint.setStrokeWidth(mStroke);
        mProgressPaint.setAntiAlias(true);
        mProgressPaint.setStrokeJoin(Paint.Join.ROUND);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int top = mTop;
        int left = 0;
        for (int i = 0; i < mLineCount; i++) {
            RectF rect = new RectF(left, mHeight - top, left + mLineWidth, mHeight);
            if (i < mProgress) {
                canvas.drawRoundRect(rect, mRadius, mRadius, mProgressPaint);
            } else {
                canvas.drawRoundRect(rect, mRadius, mRadius, mPaint);
            }
            left += mLineWidth + mPadding;
            top += mTop;
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = getWidth();
        mHeight = getHeight();
        mLineWidth = mWidth / mLineCount - mSpacing;
        mTop = mHeight / mLineCount;
        mPadding = mSpacing / mLineCount;
    }

    /**
     * change selected color
     *
     * @param colorResId color resource id
     */
    public void setProgressColor(int colorResId) {
        mProgressPaint.setColor(colorResId);
        invalidate();
    }

    /**
     * change selected color
     *
     * @param progress number of line need to show filled
     */
    public void setProgress(int progress) {
        mProgress = progress;
        invalidate();
    }

    /**
     * change line count of view
     *
     * @param lineCount number of lines which need to display
     */
    public void setLineCount(int lineCount) {
        mLineCount = lineCount;
        invalidate();
    }

    /**
     * change width of view
     *
     * @param width width of view
     */
    public void setWidth(int width) {
        mWidth = width;
    }

    public void setHeight(int height) {
        mHeight = height;
    }

}
