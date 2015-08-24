package com.yezimm.yesco.countstars.spirit;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;

import org.jbox2d.dynamics.Body;

/**
 * Created by yesco on 2015/8/21.
 */
public abstract class Spirit {

    /**
     * default priority by the spirit
     */
    public static final int PRIORITY_DEFAULT = 5 ;

    /**
     * <p>pre spirit is a life in the game world, so the spirit have a location<p/>
     * <p>the x-axis about the spirit's location</p>
     */
    private float x ;

    /**
     * <p>pre spirit is a life in the game world, so the spirit have a location<p/>
     * <p>the y-axis about the spirit's location</p>
     */
    private float y ;

    /**
     * a see body
     */
    private Bitmap body ;

    /**
     * the spirit show priority
     */
    private int priority ;

    /**
     * the axis is game world's axis. so that, the axis center is the spirit center that not in phone start location
     * @param x the real world x-axis
     * @param y the real world y-axis
     */
    public Spirit(float x, float y, Bitmap body) {
        this.x = x ;
        this.y = y ;
        this.body = body ;
        this.priority = PRIORITY_DEFAULT ;
    }

    /**
     * the axis is game world's axis. so that, the axis center is the spirit center that not in phone start location
     * @param x the real world x-axis
     * @param y the real world y-axis
     * @param priority the spirit show priority
     */
    public Spirit(float x, float y, Bitmap body, int priority) {
        this.x = x ;
        this.y = y ;
        this.body = body ;
        this.priority = priority ;
    }

    /**
     * in the game world, pre spirit must to described, so the function is to do it.
     * @param canvas
     *              <p>pre spirit have a canvas in game world, It's like life that apply colours to a drawing</p>
     * @param paint
     *              <p>Paint pen</p>
     */
    public void onDraw(Canvas canvas, Paint paint) {
        canvas.drawBitmap(body, x - body.getWidth() / 2, y - body.getHeight() / 2, paint);
    }

    /**
     * Everyone Spirit have to a life, so in game world that the spirit have a lifetime what it is logic.
     */
    public abstract void logic(Body b) ;

    /**
     * callback function when user touch the spirit
     * @param event
     *              <p>touch event</p>
     */
    public void onTouch(MotionEvent event) {
        boolean isClick = false ;
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN :
                isClick = true ;
                break;
            case MotionEvent.ACTION_MOVE :
                isClick = false ;
                break;
            case MotionEvent.ACTION_UP :
                break;
        }
        if (isClick) {
            onClickListener.onClick(this);
        }
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public Bitmap getBody() {
        return body;
    }

    public void setBody(Bitmap body) {
        this.body = body;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    private OnClickListener onClickListener ;

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    /**
     * the listener function is when user click register this listener spirit callback method .
     */
    public interface OnClickListener {
        void onClick(Spirit spirit);
    }

}
