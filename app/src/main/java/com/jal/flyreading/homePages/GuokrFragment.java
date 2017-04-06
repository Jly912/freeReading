package com.jal.flyreading.homePages;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jal.flyreading.bean.GuokrHandpickNews;
import com.jal.flyreading.contract.GuokrContract;

import java.util.ArrayList;

/**
 * Created by SEELE on 2017/4/6.
 */

public class GuokrFragment extends Fragment implements GuokrContract.View {

    public GuokrFragment(){}

    public static GuokrFragment getInstance(){
        return new GuokrFragment();
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
    public void showResults(ArrayList<GuokrHandpickNews.ResultBean> data) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void stopLoading() {

    }

    @Override
    public void setPresenter(GuokrContract.Presenter presenter) {

    }

    @Override
    public void initViews(View view) {

    }
}
