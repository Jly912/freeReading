package com.jal.flyreading.homePages;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jal.flyreading.bean.DoubanMomentEntity;
import com.jal.flyreading.contract.DoubanContract;

import java.util.ArrayList;

/**
 * Created by SEELE on 2017/4/6.
 */

public class DoubanFragment extends Fragment implements DoubanContract.View {

    public DoubanFragment(){}

    public static DoubanFragment getInstance(){
        return new DoubanFragment();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void showError() {

    }

    @Override
    public void startLoading() {

    }

    @Override
    public void stopLoading() {

    }

    @Override
    public void showResults(ArrayList<DoubanMomentEntity.PostsBean> data) {

    }

    @Override
    public void setPresenter(DoubanContract.Presenter presenter) {

    }

    @Override
    public void initViews(View view) {

    }
}
