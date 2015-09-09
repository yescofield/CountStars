package com.yezimm.yesco.countstars.utils;

import com.yezimm.yesco.countstars.config.Global;

/**
 * 坐标生成器
 * Created by yesco on 2015/9/8.
 */
public class XYUtils {

    /**
     * 根据priority生成Body的X轴与Y轴的坐标,这里的XY值为Body中心坐标值
     * @param priority onDraw优先级，主要是区分Scene与Stars
     * @return size为2的int [] xy = new int[2]数组，xy[0]为X轴坐标，xy[1]为Y轴坐标
     */
    public static int[] getXY(int priority, int width, int height) {
        int [] xy = new int[2] ;
        switch (priority) {
            case Global.PRIORITY_SCENE:
                xy[0] = 0;
                xy[1] = 0;
                break;
            case Global.PRIORITY_STARS:
                xy[0] = getRandom(SysUtils.getScreenW() - width);
                xy[1] = getRandom(SysUtils.getScreenH() - height);
                if (xy[0] < width) {
                    xy[0] = width;
                }
                if (xy[1] < height) {
                    xy[1] = height;
                }
                break;
            case Global.PRIORITY_DEFAULT:
                xy[0] = getRandom(SysUtils.getScreenW() - width);
                xy[1] = getRandom(SysUtils.getScreenH() - height);
                if (xy[0] < width) {
                    xy[0] = width;
                }
                if (xy[1] < height) {
                    xy[1] = height;
                }
                break;
            default:
                xy[0] = 0;
                xy[1] = 0;
                break;
        }
        return xy ;
    }

    private static int getRandom(int max) {
        return (int) (Math.random() * max);
    }
}
