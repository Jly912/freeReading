package com.jal.flyreading.contract;

import com.jal.flyreading.base.BasePresenter;
import com.jal.flyreading.base.BaseView;
import com.jal.flyreading.bean.BeanType;
import com.jal.flyreading.bean.DoubanMomentEntity;
import com.jal.flyreading.bean.GuokrHandpickNews;
import com.jal.flyreading.bean.ZhiHuDailyNewsEntity;

import java.util.ArrayList;

/**
 * Created by SEELE on 2017/4/7.
 */

public interface BookmarksContract {

    interface View extends BaseView<Presenter> {
        void showResults(ArrayList<ZhiHuDailyNewsEntity.StoriesBean> zhihu,
                         ArrayList<GuokrHandpickNews.ResultBean> guokr,
                         ArrayList<DoubanMomentEntity.PostsBean> douban,
                         ArrayList<Integer> types);

        void notifyDataChanged();

        void showLoading();

        void stopLoading();
    }


    interface Presenter extends BasePresenter {

        void loadResults(boolean refresh);

        void startReading(BeanType beanType, int position);

        void checkForFreshData();

        void freeLook();

    }

}
