package com.jal.flyreading.homePages;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jal.flyreading.R;
import com.jal.flyreading.bean.DoubanMomentEntity;
import com.jal.flyreading.bean.GuokrHandpickNews;
import com.jal.flyreading.bean.ZhiHuDailyNewsEntity;
import com.jal.flyreading.contract.BookmarksContract;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by SEELE on 2017/4/7.
 */

public class BookmarksFragment extends Fragment implements BookmarksContract.View {

    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;
    @Bind(R.id.refreshLayout)
    SwipeRefreshLayout refreshLayout;

    public BookmarksFragment() {
    }

    public static BookmarksFragment getInstance() {
        return new BookmarksFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bookmarks, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void showResults(ArrayList<ZhiHuDailyNewsEntity.StoriesBean> zhihu, ArrayList<GuokrHandpickNews.ResultBean> guokr, ArrayList<DoubanMomentEntity.PostsBean> douban, ArrayList<Integer> types) {

    }

    @Override
    public void notifyDataChanged() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void stopLoading() {

    }

    @Override
    public void setPresenter(BookmarksContract.Presenter presenter) {

    }

    @Override
    public void initViews(View view) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
