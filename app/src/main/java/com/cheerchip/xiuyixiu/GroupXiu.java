package com.cheerchip.xiuyixiu;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;
import android.widget.Scroller;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by noname on 2017/5/8.
 */

public class GroupXiu extends RelativeLayout {
    //scroller also can change the value to do thia animation but i don't like
    //private Scroller scroller;
    /*private Xiu3 xiu1;
    private Xiu3 xiu2;
    private Xiu3 xiu3;*/
    private List<Xiu3> xiu3s=new ArrayList<>();
    private int time;
    private int color;
    private int circlenums;

    public GroupXiu(Context context) {
        super(context);
     //   init();
    }

    public GroupXiu(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public GroupXiu(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public  void init(AttributeSet attrs){
       // LayoutInflater.from(getContext()).inflate(R.layout.xiu,this,false);
      //  scroller = new Scroller(getContext());
        //init the data
        TypedArray array=getContext().obtainStyledAttributes(attrs,R.styleable.GroupXiu);
         time= array.getInteger(R.styleable.GroupXiu_animationtime,3000);
        //set circle color
        color = array.getColor(R.styleable.GroupXiu_circlecolor, Color.RED);
        circlenums = array.getInteger(R.styleable.GroupXiu_circlenums,3);
       // time = 3000;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        //add view to group
        LayoutParams params=new LayoutParams(getWidth(),getHeight());
        for (int i = 0; i < circlenums; i++) {
            Xiu3 xiu=new Xiu3(getContext());
            //set params
            addView(xiu,params);
            xiu3s.add(xiu);
            //set paint color you can also set the paint you like
            xiu.getPaint().setColor(color);
            //
        }
        //this is the test
      //  xiu1 = new Xiu3(getContext());
      //  xiu2 = new Xiu3(getContext());
      //  xiu3 = new Xiu3(getContext());
      //  addView(xiu2,params);
     //    addView(xiu3,params);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        LayoutParams params=new LayoutParams(getWidth(),getHeight());
        for (int i = 0; i <xiu3s.size() ; i++) {
            xiu3s.get(i).setLayoutParams(params);
        }
     /*   xiu1.setLayoutParams(params);
        xiu2.setLayoutParams(params);
        xiu3.setLayoutParams(params);*/
    }

    public void startani(){

        for (int i = 0; i <xiu3s.size() ; i++) {
            if (i==0){
              startchildani(xiu3s.get(i));
            }else{
                //delayed to start animation
                final int finalI = i;
                postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startchildani(xiu3s.get(finalI));
                    }
                },time/xiu3s.size()*i);
            }

        }
    }
    List<AnimatorSet> sets=new ArrayList<>();
    public void startchildani(Xiu3 xiu){
        AnimatorSet set= new AnimatorSet();
        ObjectAnimator animator1=ObjectAnimator.ofInt(xiu,"r",0,xiu.getWidth());
        animator1.setRepeatCount(ValueAnimator.INFINITE);
        ObjectAnimator animator2=ObjectAnimator.ofFloat(xiu,"alpha",1f,0f);
        animator2.setRepeatCount(ValueAnimator.INFINITE);
        set.setInterpolator(new LinearInterpolator());
        set.play(animator1).with(animator2);
        set.setDuration(time);
        // AnimationSet set1;
        set.start();
        sets.add(set);
       // set.
    }
    public void stopani(){
       // set.end();
        removeCallbacks(null);
        for (int i = 0; i < sets.size(); i++) {
           // ((Xiu3) getChildAt(i)).clearAnimation();
            //stopanimation
            sets.get(i).end();
        }
    }
}
