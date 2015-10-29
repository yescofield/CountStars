package com.yezimm.yesco.countstars.spirit;

import android.graphics.*;
import android.view.MotionEvent;

import com.yezimm.yesco.countstars.config.Global;
import com.yezimm.yesco.countstars.utils.PhysicalUtils;

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
     * a see bodyBmp
     */
    private Bitmap bodyBmp;

    /**
     * the spirit in world angle
     */
    private float angle ;

    /**
     * the spirit show priority
     */
    private int priority ;

    /**
     * the axis is game world's axis. so that, the axis center is the spirit center that not in phone start location
     * @param x the real world x-axis
     * @param y the real world y-axis
     */
    public Spirit(float x, float y, Bitmap bodyBmp) {
        this.x = x ;
        this.y = y ;
        this.bodyBmp = bodyBmp ;
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
        this.bodyBmp = body ;
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
        canvas.save();
        canvas.rotate(angle, x, y);
        canvas.drawBitmap(bodyBmp, x - bodyBmp.getWidth() / 2, y - bodyBmp.getHeight() / 2, paint);
        canvas.restore();
    }

    /**
     * Everyone Spirit have to a life, so in game world that the spirit have a lifetime what it is logic.
     */
    public void logic(Body b) {
        // 得到当前body的角度
        float angele = (float) (b.getAngle() * 180 / Math.PI);
        // 得到当前body的质点X坐标
        float bodyX = b.getPosition().x * Global.RATE - bodyBmp.getWidth() / 2;
        // 得到当前body的质点Y坐标
        float bodyY = b.getPosition().y * Global.RATE - bodyBmp.getHeight() / 2;
        this.setAngle(angele);
        this.setX(bodyX);
        this.setY(bodyY);
    }

    /**
     * callback function when user touch the spirit
     * @param event
     *              <p>touch event</p>
     */
    public void onTouch(MotionEvent event, Body b) {
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
        if (isClick && PhysicalUtils.isCollision(event.getX(), event.getY(), x, y, 0, 0, bodyBmp.getWidth(), bodyBmp.getHeight())) {
            if (onClickListener != null) {
                onClickListener.onClick(b);
            }
            onClick(b, new Point((int)event.getX(), (int)event.getY()));
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

    public Bitmap getBodyBmp() {
        return bodyBmp;
    }

    public void setBodyBmp(Bitmap bodyBmp) {
        this.bodyBmp = bodyBmp;
    }

    /**
     * 设置Body的旋转角度
     * @param angle
     */
    public void setAngle(float angle) {
        this.angle = angle;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    /**
     * 被点击了回调
     */
    public abstract void onClick(Body body, Point point) ;

    private OnClickListener onClickListener ;

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    /**
     * the listener function is when user click register this listener spirit callback method .
     */
    public interface OnClickListener {
        void onClick(Body body);
    }

}
