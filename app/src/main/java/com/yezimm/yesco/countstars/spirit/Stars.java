package com.yezimm.yesco.countstars.spirit;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;

/**
 * Created by yesco on 2015/8/21.
 */
public class Stars extends Spirit{

    private Bitmap mStarsBmp;

    public Stars(float x, float y, Bitmap bgBmp) {
        super(x, y);
        mStarsBmp = bgBmp ;
    }

    @Override
    public void onDraw(Canvas canvas, Paint paint) {
        canvas.drawBitmap(mStarsBmp, getX() - mStarsBmp.getWidth() / 2, getY() - mStarsBmp.getHeight() / 2, paint);
    }

    @Override
    public void onTouch(Spirit spirit, MotionEvent event) {
        super.onTouch(spirit, event);
    }
}
