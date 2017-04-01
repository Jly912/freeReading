package com.jal.flyreading.app;

import android.app.Application;
import android.content.Context;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheEntity;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.cookie.store.PersistentCookieStore;

import java.util.logging.Level;

/**
 * Created by SEELE on 2017/4/1.
 */

public class AppContext extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        init();

    }

    private void init() {
        //OkGo的初始化
        OkGo.init(this);

        OkGo.getInstance()
                // 打开该调试开关,打印级别INFO,并不是异常,是为了显眼,不需要就不要加入该行
                // 最后的true表示是否打印okgo的内部异常，一般打开方便调试错误
                .debug("OkGo", Level.INFO, true)

                //如果使用默认的 60秒,以下三行也不需要传
//                .setConnectTimeout(OkGo.DEFAULT_MILLISECONDS)//全局连接超时时间
//                .setReadTimeOut(OkGo.DEFAULT_MILLISECONDS)//全局读取超时时间
//                .setWriteTimeOut(OkGo.DEFAULT_MILLISECONDS)//全局写入超时时间
                //可以全局统一设置缓存模式,默认是不使用缓存,可以不传
                .setCacheMode(CacheMode.NO_CACHE)
                //可以全局统一设置缓存时间,默认永不过期,具体使用方法看 github 介绍
                .setCacheTime(CacheEntity.CACHE_NEVER_EXPIRE)
                //可以全局统一设置超时重连次数,默认为三次,那么最差的情况会请求4次(一次原始请求,三次重连请求),不需要可以设置为0
                .setRetryCount(3)
//               如果不想让框架管理cookie（或者叫session的保持）,以下不需要
                .setCookieStore(new PersistentCookieStore());

    }

    public static Context getContext() {
        return context;
    }
}
