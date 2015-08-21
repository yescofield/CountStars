package com.yezimm.yesco.countstars.scene;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;

import com.yezimm.yesco.countstars.spirit.Spirit;

/**
 * Created by yesco on 2015/8/21.
 */
public class Scene extends Spirit{

    private Bitmap mBgBmp ;

    public Scene(float x, float y, Bitmap bgBmp) {
        super(x, y);
        mBgBmp = bgBmp ;
    }

    @Override
    public void onDraw(Canvas canvas, Paint paint) {
        canvas.drawBitmap(mBgBmp, getX() - mBgBmp.getWidth() / 2, getY() - mBgBmp.getHeight() / 2, paint);
    }

    @Override
    public void onTouch(Spirit spirit, MotionEvent event) {
        super.onTouch(spirit, event);
    }
}
