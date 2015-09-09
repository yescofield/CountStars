package com.yezimm.yesco.countstars.config;

/**
 * Created by yesco on 2015/9/8.
 */
public class Global {

    //优先级priority
    public final static int PRIORITY_SCENE = 1 ;
    public final static int PRIORITY_STARS = 2 ;
    public final static int PRIORITY_DEFAULT = 3 ;

    //游戏相关设置
    public final static float RATE = 30;// 屏幕到现实世界的比例 30px：1m;
    public final static float timeStep = 1f / 60f;// 物理世界模拟的的频率
    public final static int iterations = 10;// 迭代值，迭代越大模拟越精确，但性能越低

}
