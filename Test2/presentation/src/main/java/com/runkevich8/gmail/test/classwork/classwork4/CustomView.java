package com.runkevich8.gmail.test.classwork.classwork4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;


public class CustomView extends View {

    private Paint paintCustomView;
    private float radius;
    private float cx;
    private float cy;
    private RectF rect;

    public CustomView(Context context) {
        super(context);
        init();
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init(){
        paintCustomView = new Paint();
        paintCustomView.setColor(Color.GREEN);
        paintCustomView.setAntiAlias(true);//плавные края делает

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        cx = w/2;
        cy = h/2;
        radius = w>h ?cx/4 : cy/4;

        rect = new RectF();

        float wRec = w*0.9f;
        float hRec = h*0.2f;

        rect.left = (w-wRec)/2;
        rect.top = (h-hRec)/2;
        rect.right = w-rect.left;
        rect.bottom = w-rect.top;

    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    //обязательно нужно переопределять при установке размера для рисования !!!(wrap_content)
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //подача размеров
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawCircle(cx,cy,radius, paintCustomView);
       // invalidate();

       // canvas.drawRect(rect,paintCustomView);
       //canvas.save();
       canvas.rotate(90,cx,cy);
      // canvas.drawLine(0,0,20,20,paintCustomView);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()){

            case MotionEvent.ACTION_DOWN:{

                rect.contains(event.getX(),event.getY());

                break;
            }
            case MotionEvent.ACTION_UP:{
                break;
            }
            case MotionEvent.ACTION_MOVE:{

                cx = event.getX();
                cy = event.getY();
                invalidate();
                return false;
            }

        }

        return true;
                //super.onTouchEvent(event);
    }
}
