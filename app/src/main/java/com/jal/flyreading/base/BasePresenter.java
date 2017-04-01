package com.jal.flyreading.base;

/**
 * Created by SEELE on 2017/4/1.
 */

public interface BasePresenter {
    // 获取数据并改变界面显示，在todo-mvp的项目中的调用时机为Fragment的OnResume()方法中
    void start();
}
