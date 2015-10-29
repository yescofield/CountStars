package com.yezimm.yesco.countstars.spirit;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.widget.Toast;

import com.yezimm.yesco.countstars.MainActivity;

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
        Rect rect = new Rect((int)getX(), (int)getY(), getBodyBmp().getWidth(), getBodyBmp().getHeight());
        MainActivity.getInstance().getExplosionField().explode(getBodyBmp(), rect, 100, 1000);
        Toast.makeText(MainActivity.getInstance(), "Stars", Toast.LENGTH_SHORT).show();
    }
}
