package com.jal.flyreading.presenter;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.jal.flyreading.bean.ZhiHuDailyNewsEntity;
import com.jal.flyreading.contract.ZhiHuContract;
import com.jal.flyreading.http.Api;
import com.jal.flyreading.util.DateFormatUtil;
import com.jal.flyreading.util.NetworkStateUtil;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;

import java.util.ArrayList;
import java.util.Calendar;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by SEELE on 2017/4/6.
 */

public class ZhiHuDailyPresenter implements ZhiHuContract.Presenter {

    private ZhiHuContract.View view;
    private Context context;

    private Gson gson = new Gson();

    private ArrayList<ZhiHuDailyNewsEntity.StoriesBean> data = new ArrayList<>();

    public ZhiHuDailyPresenter(Context context, ZhiHuContract.View view) {
        this.context = context;
        this.view = view;
        this.view.setPresenter(this);
    }

    @Override
    public void loadPosts(long time, final boolean isClear) {
        if (isClear) {
            view.showLoading();
        }

        if (NetworkStateUtil.isNetworkConnected(context)) {
            OkGo.get(Api.ZHIHU_HISTORY + DateFormatUtil.zhuHuDailyDateFormart(time))
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {
                            Log.d("print", "知乎：" + s);
                            ZhiHuDailyNewsEntity zhiHuDailyNewsEntity = gson.fromJson(s, ZhiHuDailyNewsEntity.class);
                            if (isClear) {
                                data.clear();
                            }

                            for (ZhiHuDailyNewsEntity.StoriesBean storiesBean : zhiHuDailyNewsEntity.getStories()){
                                data.add(storiesBean);
                            }

                            view.showResults(data);
                            view.stopLoading();
                        }
                    });
        }else {
            if(isClear){
                data.clear();
                view.stopLoading();
                view.showResults(data);
            }else {
                view.showError();
            }
        }
    }

    @Override
    public void refresh() {
        loadPosts(Calendar.getInstance().getTimeInMillis(),true);
    }

    @Override
    public void loadMore(long time) {
        loadPosts(time,false);
    }

    @Override
    public void startReading(int position) {

    }

    @Override
    public void freeLook() {

    }

    @Override
    public void start() {
        loadPosts(Calendar.getInstance().getTimeInMillis(),true);
    }

}

