package com.yezimm.yesco.countstars;

import android.app.Application;

/**
 * Created by admin on 2015/9/8.
 */
public class StarsApplication extends Application {

    private static StarsApplication sInstance;

    public static StarsApplication getInstance() {
        return sInstance;
    }

    public StarsApplication() {
        sInstance = this;
    }

}
