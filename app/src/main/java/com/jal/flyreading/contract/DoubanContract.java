package com.jal.flyreading.contract;

import com.jal.flyreading.base.BasePresenter;
import com.jal.flyreading.base.BaseView;
import com.jal.flyreading.bean.DoubanMomentEntity;

import java.util.ArrayList;

/**
 * Created by SEELE on 2017/4/6.
 */

public interface DoubanContract {

    interface View extends BaseView<Presenter> {

        void showError();

        void startLoading();

        void stopLoading();

        void showResults(ArrayList<DoubanMomentEntity.PostsBean> data);

    }


    interface Presenter extends BasePresenter {

        void startReading(int position);

        void loadPosts(long date, boolean clearing);

        void refresh();

        void loadMore(long date);

        void freeLook();

    }

}
