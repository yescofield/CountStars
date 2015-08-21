package com.yezimm.yesco.countstars.spirit;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;

/**
 * Created by yesco on 2015/8/21.
 */
public abstract class Spirit {

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

    public Spirit() { }

    /**
     * the axis is game world's axis. so that, the axis center is the spirit center that not in phone start location
     * @param x the real world x-axis
     * @param y the real world y-axis
     */
    public Spirit(float x, float y) {
        this.x = x ;
        this.y = y ;
    }

    /**
     * in the game world, pre spirit must to described, so the function is to do it.
     * @param canvas
     *              <p>pre spirit have a canvas in game world, It's like life that apply colours to a drawing</p>
     * @param paint
     *              <p>Paint pen</p>
     */
    public abstract void onDraw(Canvas canvas, Paint paint) ;

    /**
     * callback function when user touch the spirit
     * @param spirit
     *              <p>the spirit</p>
     * @param event
     *              <p>touch event</p>
     */
    public void onTouch(Spirit spirit, MotionEvent event) {
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
            onClickListener.onClick(spirit);
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
