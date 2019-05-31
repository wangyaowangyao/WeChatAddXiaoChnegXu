package com.wy.we_chat_xiao_cheng_xu;

import android.app.Application;
import android.content.Context;

/**
 * Author: WangYao
 * Date: 2019/3/20
 * QQ: 1484991675
 */
public class MyApplication extends Application {

    private static MyApplication app;
    private Context mContext;

    public static MyApplication getInstance() {

        return app;
    }

    public Context getContext() {
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        mContext = getApplicationContext();
    }
}
