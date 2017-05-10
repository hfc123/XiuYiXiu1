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

public class Xiu2 extends View {

    private int n;
    private Paint paint;
    private int r;
    private int extress;

    public int getExtress() {
        return extress;
    }

    public void setExtress(int extress) {
        this.extress = extress;
        invalidate();
    }
    public final static Property<Xiu2,Integer> EXTRESS=new Property<Xiu2, Integer>(Integer.class,"extress") {

        @Override
        public Integer get(Xiu2 object) {
            return object.getExtress();
        }

        @Override
        public void set(Xiu2 object, Integer value) {
          //  super.set(object, value);
            object.setExtress(value);
        }
    };
    public Xiu2(Context context) {
        super(context);
        init();
    }

    public Xiu2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public Xiu2(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        extress = 0;
        n = 4;
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(4);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int r1= getWidth();
        int r2= getHeight();
        r = Math.min(r1,r2);
        if (r ==r1){
            for (int i = 0; i <n ; i++) {
                paint.setAlpha(30);
                canvas.drawCircle(r /2,getHeight()/2, r /2/n*4+extress,paint);
                paint.setAlpha(20);
                canvas.drawCircle(r /2,getHeight()/2, r /2/n*3+extress,paint);
                paint.setAlpha(20);
                canvas.drawCircle(r /2,getHeight()/2, r /2/n*2+extress,paint);
                paint.setAlpha(20);
                canvas.drawCircle(r /2,getHeight()/2, r /2/n+extress,paint);
            }
        }
    }
}
