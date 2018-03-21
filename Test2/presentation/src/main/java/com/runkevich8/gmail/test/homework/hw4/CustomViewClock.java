package com.runkevich8.gmail.test.homework.hw4;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;

import java.util.Calendar;

public class CustomViewClock extends View {
    private Paint paintCustomViewClock;
    private float radius;
    private float cx;
    private float cy;
    private int mPadding = 0;
    private Rect mRect = new Rect();
    private int[] mClockHours = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

    public CustomViewClock(Context context) {
        super(context);
        init();
    }

    public CustomViewClock(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomViewClock(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CustomViewClock(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init(){
        paintCustomViewClock = new Paint();
        paintCustomViewClock.setColor(Color.GRAY);
        paintCustomViewClock.setAntiAlias(true);//плавные края делает

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        cx = w/2;
        cy = h/2;
        radius = w>h ?cx/2 : cy/2;

        mPadding = (int) (radius*0.1);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        paintCustomViewClock.setColor(Color.GRAY);
        canvas.drawCircle(cx,cy,radius+mPadding, paintCustomViewClock);

        int fontSize = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 14, getResources().getDisplayMetrics());
        paintCustomViewClock.setTextSize(fontSize);

        for (int hour : mClockHours) {
            String tmp = String.valueOf(hour);
            paintCustomViewClock.getTextBounds(tmp, 0, tmp.length(), mRect);

            paintCustomViewClock.setColor(Color.BLACK);
            double angle = Math.PI / 6 * (hour - 3);
            float x = (float) (cx + Math.cos(angle) * radius - mRect.width()/2);
            float y = (float) (cy + Math.sin(angle) * radius + mRect.height()/2);

          canvas.drawText(String.valueOf(hour), x, y, paintCustomViewClock);

        }

        paintCustomViewClock.setStrokeWidth(8);
        for (int i = 0; i < 12; i++) {
            if (i%3==0){
                paintCustomViewClock.setColor(Color.BLUE);
                canvas.drawLine(cx-radius-mPadding, cy, cx-radius-mPadding/3, cy, paintCustomViewClock);
            } else {
                paintCustomViewClock.setColor(Color.BLACK);
                canvas.drawLine(cx-radius-mPadding, cy, cx-radius-mPadding/2, cy, paintCustomViewClock);
            }

            canvas.rotate(30, cx, cy);
        }
        canvas.save();
        Calendar calendar = Calendar.getInstance();
        float hour = calendar.get(Calendar.HOUR_OF_DAY);
        hour = hour > 12 ? hour - 12 : hour;

        drawHandLine(canvas, (hour + calendar.get(Calendar.MINUTE) / 60) * 5f, true, false); // draw hours
        drawHandLine(canvas, calendar.get(Calendar.MINUTE), false, false); // draw minutes
        drawHandLine(canvas, calendar.get(Calendar.SECOND), false, true); // draw seconds

        postInvalidateDelayed(500);
        invalidate();
    }
    private void drawHandLine(Canvas canvas, double moment, boolean isHour, boolean isSecond) {
        double angle = Math.PI * moment / 30 - Math.PI / 2;
        int handRadius = (int) (isHour ? radius - mPadding*5 : radius - mPadding*2);
        if (isSecond) paintCustomViewClock.setColor(Color.BLUE);
        canvas.drawLine(cx, cy, (float) (cx+ Math.cos(angle) * handRadius), (float) (cy + Math.sin(angle) * handRadius), paintCustomViewClock);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()){

            case MotionEvent.ACTION_DOWN:{
                break;
            }
            case MotionEvent.ACTION_UP:{
                break;
            }
            case MotionEvent.ACTION_MOVE:{

                return false;
            }
        }
        return true;
    }
}
