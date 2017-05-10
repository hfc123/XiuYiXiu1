package com.cheerchip.xiuyixiu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;

/**
 * Created by noname on 2017/5/8.
 */

public class Xiu3 extends View {

    private int n;
    private Paint paint;
    private int r;

    public Xiu3(Context context) {
        super(context);
        init();
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
        invalidate();
    }

    public Xiu3(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public Xiu3(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    private void init() {
         //extress = 0;
        //设置圆的数目
        n = 4;
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(4);
    }

    public Paint getPaint() {
        return paint;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }

    public final static Property<Xiu3,Integer> R=new Property<Xiu3, Integer>(Integer.class,"r") {
       @Override
       public Integer get(Xiu3 object) {
           return object.getR();
       }

       @Override
       public void set(Xiu3 object, Integer value) {
           //super.set(object, value);
           object.setR(value);
       }
   };
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        /*int r1= getWidth();
        int r2= getHeight();
        r = Math.min(r1,r2);*/
        canvas.drawCircle(getWidth()/2,getHeight()/2, r/2,paint);
    }

}
