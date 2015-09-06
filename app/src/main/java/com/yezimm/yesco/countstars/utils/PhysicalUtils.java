package com.yezimm.yesco.countstars.utils;

import org.jbox2d.dynamics.Body;

/**
 * 用于做一些物理世界中的规则处理
 * 例如：碰撞检测
 * Created by scofield on 2015/9/6.
 */
public class PhysicalUtils {

    /**
     *
     * @param bodyA
     * @param bodyB
     * @return
     */
    public static boolean isCollision(Body bodyA, Body bodyB) {
        return false;
    }

    /**
     * 两个矩形之间的碰撞检测，最基础的碰撞检测
     * <p>分为矩形A与矩形B，参数分别为矩形的属性</p>
     * <p>这里的坐标全部使用world世界坐标，也就是中心点坐标</p>
     * @param ax 矩形A的x轴坐标
     * @param ay 矩形A的y轴坐标
     * @param bx 矩形B的x轴坐标
     * @param by 矩形B的y轴坐标
     * @param aw 矩形A的宽
     * @param ah 矩形A的高
     * @param bw 矩形B的宽
     * @param bh 矩形B的高
     * @return
     */
    public static boolean isCollision(float ax, float ay, float bx, float by,
                                float aw, float ah, float bw, float bh) {
        
        return false;
    }
}
