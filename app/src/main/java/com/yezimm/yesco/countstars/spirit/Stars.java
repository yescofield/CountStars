package com.yezimm.yesco.countstars.spirit;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;

import org.jbox2d.dynamics.Body;

/**
 * Created by yesco on 2015/8/21.
 */
public class Stars extends Spirit{

    public Stars(float x, float y, Bitmap bodyBmp) {
        super(x, y, bodyBmp);
    }

    @Override
    public void onDraw(Canvas canvas, Paint paint) {
        super.onDraw(canvas, paint);
    }

    @Override
    public void logic(Body body) {
        super.logic(body);
    }

    @Override
    public void onClick(Body body) {

    }
}
