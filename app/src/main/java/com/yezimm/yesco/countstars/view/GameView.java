package com.yezimm.yesco.countstars.view;

import org.jbox2d.collision.AABB;
import org.jbox2d.collision.PolygonDef;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.World;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

import com.yezimm.yesco.countstars.R;
import com.yezimm.yesco.countstars.config.Global;
import com.yezimm.yesco.countstars.scene.SpiritContain;
import com.yezimm.yesco.countstars.spirit.Spirit;
import com.yezimm.yesco.countstars.spirit.Stars;
import com.yezimm.yesco.countstars.utils.XYUtils;

public class GameView extends SurfaceView implements Callback, Runnable {
    private Thread th;
    private SurfaceHolder sfh;
    private Canvas canvas;
    private Paint paint;
    private boolean flag;
    // ----添加一个物理世界---->>
    World world;// 声明一个物理世界对象
    AABB aabb;// 声明一个物理世界的范围对象
    Vec2 gravity;// 声明一个重力向量对象

    private Bitmap starsBmp ;

    public GameView(Context context) {
        super(context);
        this.setKeepScreenOn(true);
        sfh = this.getHolder();
        sfh.addCallback(this);
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Style.STROKE);
        this.setFocusable(true);
        // --添加一个物理世界--->>
        aabb = new AABB();// 实例化物理世界的范围对象
        gravity = new Vec2(0, 10);// 实例化物理世界重力向量对象
        aabb.lowerBound.set(-100, -100);// 设置物理世界范围的左上角坐标
        aabb.upperBound.set(100, 100);// 设置物理世界范围的右下角坐标
        world = new World(aabb, gravity, true);// 实例化物理世界对象

        starsBmp = BitmapFactory.decodeResource(getResources(), R.mipmap.bird_yellow);
        int [] xy ;
        for (int i = 0; i < 5; i ++) {
            xy = XYUtils.getXY(Global.PRIORITY_STARS, starsBmp.getWidth(), starsBmp.getHeight());
            Stars stars = new Stars(xy[0], xy[1], starsBmp) ;
            createBodyBySpirit(stars, true);
            SpiritContain.getInstance().addSpirit(stars);
        }

    }

    public void surfaceCreated(SurfaceHolder holder) {
        flag = true;
        th = new Thread(this);
        th.start();
    }

    /**
     * 根据Spirit创建Body
     * @param spirit 精灵
     * @param isStatic 该物体是否为静物
     * @return 物理世界中的Body
     */
    public Body createBodyBySpirit(Spirit spirit, boolean isStatic) {
        PolygonDef pd = new PolygonDef();
        if (isStatic) {
            pd.density = 0;
        } else {
            pd.density = 1;
        }
        pd.friction = 0.8f; //设置图片body的摩擦力
        pd.restitution = 0.3f; //设置图片body的恢复力
        //设置图片Body快捷成盒子（矩形）
        //两个参数为图片Body宽高的一半
        pd.setAsBox(spirit.getBodyBmp().getWidth() / 2 / Global.RATE, spirit.getBodyBmp().getHeight() / 2 / Global.RATE);
        //创建刚体
        BodyDef bd = new BodyDef();//实例一个刚体对象
        bd.position.set(spirit.getX() / Global.RATE, spirit.getY() / Global.RATE);
        Body body = world.createBody(bd);
        //在body中保存自定义类
        body.m_userData = spirit;
        body.createShape(pd);//为body添加皮肤
        body.setMassFromShapes();//将整个body计算打包
        return body;
    }

    public void myDraw() {
        try {
            canvas = sfh.lockCanvas();
            if (canvas != null) {
                canvas.drawColor(Color.WHITE);
                Body body = world.getBodyList();
                for (int i = 1; i < world.getBodyCount(); i++) {
                    ((Spirit) body.m_userData).onDraw(canvas, paint);
                    body = body.m_next;
                }
            }
        } catch (Exception e) { } finally {
            if (canvas != null)
                sfh.unlockCanvasAndPost(canvas);
        }
    }

    public void Logic() {
        // --开始模拟物理世界--->>
        world.step(Global.timeStep, Global.iterations);// 物理世界进行模拟
        // 取出body链表表头
        Body body = world.getBodyList();
        for (int i = 1; i < world.getBodyCount(); i++) {
            // 执行SpiritContain中的logic
            Spirit mc = (Spirit) body.m_userData;
            mc.logic(body);
            // 将链表指针指向下一个body元素
            body = body.m_next;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // --开始模拟物理世界--->>
        world.step(Global.timeStep, Global.iterations);// 物理世界进行模拟
        // 取出body链表表头
        Body body = world.getBodyList();
        for (int i = 1; i < world.getBodyCount(); i++) {
            // 执行SpiritContain中的logic
            Spirit mc = (Spirit) body.m_userData;
            mc.onTouch(event, body);
            // 将链表指针指向下一个body元素
            body = body.m_next;
        }
        return super.onTouchEvent(event);
    }

    public void run() {
        while (flag) {
            myDraw();
            Logic();
            try {
                Thread.sleep((long) Global.timeStep * 1000);
            } catch (Exception ex) {
                Log.e("YESCO", "Thread is Error!");
            }
        }
    }

    public void surfaceChanged(SurfaceHolder holder, int format, int width,
                               int height) {
    }

    public void surfaceDestroyed(SurfaceHolder holder) {
        flag = false;
    }

}

