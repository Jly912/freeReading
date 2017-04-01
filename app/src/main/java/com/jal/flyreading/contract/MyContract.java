package com.jal.flyreading.contract;

import com.jal.flyreading.base.BasePresenter;
import com.jal.flyreading.base.BaseView;

import java.util.ArrayList;

/**
 * Created by SEELE on 2017/4/1.
 * 契约类，用于统一管理View和Presenter
 */

public interface MyContract {

    interface View extends BaseView<Presenter> {

        //显示加载或其他类型的错误
        void showError();

        //显示正在加载
        void showLoading();

        //停止显示正在加载
        void stopLoading();

        // 成功获取到数据后，在界面中显示
        void showResults(ArrayList<Object> list);

        // 显示用于加载指定日期的date picker dialog
        void showPicDialog();
    }

    interface Presenter extends BasePresenter {
        //请求数据
        void loadPosts(long time, boolean isClear);

        //刷新数据
        void refresh();

        //加载更多文章
        void loadMore(long time);

        //显示详情
        void startReading(int position);

        //随便看看
        void freeLook();
    }

}
