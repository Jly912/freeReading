package com.jal.flyreading.contract;

import com.jal.flyreading.base.BasePresenter;
import com.jal.flyreading.base.BaseView;
import com.jal.flyreading.bean.GuokrHandpickNews;

import java.util.ArrayList;

/**
 * Created by SEELE on 2017/4/6.
 */

public interface GuokrContract {

    interface View extends BaseView<Presenter> {
        void showError();

        void showResults(ArrayList<GuokrHandpickNews.ResultBean> data);

        void showLoading();

        void stopLoading();
    }


    interface Presenter extends BasePresenter {

        void loadPosts();

        void refresh();

        void startReading(int position);

        void freeLook();

    }

}
