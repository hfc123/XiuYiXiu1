package com.cheerchip.xiuyixiu;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

/**
 * Created by noname on 2017/5/8.
 */

public class Xiu extends View {

    private Paint paint;
    private int n;
    private int excess;
    private int r;

    public Xiu(Context context) {
        super(context);
        init();
    }

    public int getExcess() {
        return excess;
    }

    public void setExcess(int excess) {
        this.excess = excess;
    }

    private void init() {
        //初始化圆的数目
        n = 4;
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(4);
    }

    public Xiu(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Xiu(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
       int r1= getWidth();
       int r2= getHeight();
        r = Math.min(r1,r2);
        if (r ==r1){
            for (int i = 0; i <n ; i++) {
                canvas.drawCircle(r /2,getHeight()/2, r /2/n*4+excess,paint);
                canvas.drawCircle(r /2,getHeight()/2, r /2/n*3+excess,paint);
                canvas.drawCircle(r /2,getHeight()/2, r /2/n*2+excess,paint);
                canvas.drawCircle(r /2,getHeight()/2, r /2/n+excess,paint);
            }
        }
    }

    public void sartanimotion(){
        ValueAnimator animator=ValueAnimator.ofInt(0,r/4);
        animator.setInterpolator(new LinearInterpolator());
        animator.setDuration(2000);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                        excess= ((int) animation.getAnimatedValue());
                        invalidate();
            }
        });
        animator.start();
    }
}
