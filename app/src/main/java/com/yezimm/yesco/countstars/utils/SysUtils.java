package com.yezimm.yesco.countstars.utils;

import android.content.Context;
import android.view.WindowManager;

import com.yezimm.yesco.countstars.StarsApplication;

/**
 * Created by yesco on 2015/9/8.
 */
public class SysUtils {

    public static int getScreenW() {
        WindowManager wm = (WindowManager) StarsApplication.getInstance()
                .getSystemService(Context.WINDOW_SERVICE);
        return wm.getDefaultDisplay().getWidth();
    }

    public static int getScreenH() {
        WindowManager wm = (WindowManager) StarsApplication.getInstance()
                .getSystemService(Context.WINDOW_SERVICE);
        return wm.getDefaultDisplay().getHeight();
    }

}
