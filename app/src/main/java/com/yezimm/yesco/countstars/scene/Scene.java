package com.yezimm.yesco.countstars.scene;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;

import com.yezimm.yesco.countstars.spirit.Spirit;

import org.jbox2d.dynamics.Body;

/**
 * Created by yesco on 2015/8/21.
 */
public class Scene extends Spirit{

    public Scene(float x, float y, Bitmap bodyBmp) {
        super(x, y, bodyBmp);
    }

    @Override
    public void onDraw(Canvas canvas, Paint paint) {
        super.onDraw(canvas, paint);
    }

    @Override
    public void logic(Body body) {

    }

    @Override
    public void onTouch(MotionEvent event, Body b) {
        super.onTouch(event, b);
    }
}
