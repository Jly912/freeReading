package com.jal.flyreading.base;

import android.view.View;

/**
 * Created by SEELE on 2017/4/1.
 */

public interface BaseView<T> {
    //为view设置Presenter
    void setPresenter(T presenter);

    //初始化界面控件
    void initViews(View view);
}
