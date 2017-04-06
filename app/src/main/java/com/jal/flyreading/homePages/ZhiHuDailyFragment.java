package com.jal.flyreading.homePages;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jal.flyreading.bean.ZhiHuDailyNewsEntity;
import com.jal.flyreading.contract.ZhiHuContract;

import java.util.ArrayList;

/**
 * Created by SEELE on 2017/46.
 */

public class ZhiHuDailyFragment extends Fragment implements ZhiHuContract.View {

    public ZhiHuDailyFragment() {

    }

    public static ZhiHuDailyFragment getInstance() {
        return new ZhiHuDailyFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return null;
    }

    @Override
    public void showError() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void stopLoading() {

    }

    @Override
    public void showResults(ArrayList<ZhiHuDailyNewsEntity.StoriesBean> list) {

    }

    @Override
    public void showPicDialog() {

    }

    @Override
    public void setPresenter(ZhiHuContract.Presenter presenter) {

    }

    @Override
    public void initViews(View view) {

    }
}
