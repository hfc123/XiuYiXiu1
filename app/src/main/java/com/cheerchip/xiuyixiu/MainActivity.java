package com.cheerchip.xiuyixiu;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;

public class MainActivity extends AppCompatActivity {

    private GroupXiu xiu;
    boolean scan=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        xiu = ((GroupXiu) findViewById(R.id.xiu));
      //  startanimation( xiu);
    }

    public void startanimation(View view) {
        //Xiu3 xiu=((Xiu3) findViewById(R.id.xiu));
        if (scan){
            xiu.startani();
            scan=false;
        }else {
            xiu.stopani();
        }

      //  set.play();
     //  view.startAnimation(set);
        /*        AnimatorSet animSet = new AnimatorSet(true);
        animSet.play()
        animSet.play(anim1).with(anim2);
        animSet.play(anim2).with(anim3);
        animSet.play(anim4).after(anim3);
        animSet.setDuration(1000);
        animSet.start();*/
    }
}
