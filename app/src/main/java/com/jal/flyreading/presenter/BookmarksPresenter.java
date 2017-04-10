package com.jal.flyreading.presenter;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.google.gson.Gson;
import com.jal.flyreading.bean.BeanType;
import com.jal.flyreading.bean.DoubanMomentEntity;
import com.jal.flyreading.bean.GuokrHandpickNews;
import com.jal.flyreading.bean.ZhiHuDailyNewsEntity;
import com.jal.flyreading.contract.BookmarksContract;
import com.jal.flyreading.database.DatabaseHelper;

import java.util.ArrayList;

/**
 * Created by SEELE on 2017/4/7.
 */

public class BookmarksPresenter implements BookmarksContract.Presenter {

    private BookmarksContract.View view;
    private Context context;
    private Gson gson;

    private ArrayList<DoubanMomentEntity.PostsBean> douban;
    private ArrayList<GuokrHandpickNews.ResultBean> guokr;
    private ArrayList<ZhiHuDailyNewsEntity.StoriesBean> zhihu;

    private ArrayList<Integer> types;

    private DatabaseHelper dbhelper;
    private SQLiteDatabase db;

    public BookmarksPresenter(Context context, BookmarksContract.View view) {
        this.context = context;
        this.view = view;
        this.view.setPresenter(this);
        gson = new Gson();

        douban = new ArrayList<>();
        guokr = new ArrayList<>();
        zhihu = new ArrayList<>();
        types = new ArrayList<>();
    }


    @Override
    public void loadResults(boolean refresh) {
        if(!refresh){
            view.showLoading();
        }else {
            zhihu.clear();
            douban.clear();
            guokr.clear();
            types.clear();
        }

        checkForFreshData();
        view.showResults(zhihu,guokr,douban,types);
        view.stopLoading();
    }

    @Override
    public void startReading(BeanType beanType, int position) {

    }

    @Override
    public void checkForFreshData() {

    }

    @Override
    public void freeLook() {

    }

    @Override
    public void start() {

    }
}
