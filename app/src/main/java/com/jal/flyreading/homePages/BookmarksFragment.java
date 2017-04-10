package com.jal.flyreading.homePages;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.jal.flyreading.R;
import com.jal.flyreading.adpter.BookmarksRyAdapter;
import com.jal.flyreading.bean.BeanType;
import com.jal.flyreading.bean.DoubanMomentEntity;
import com.jal.flyreading.bean.GuokrHandpickNews;
import com.jal.flyreading.bean.ZhiHuDailyNewsEntity;
import com.jal.flyreading.contract.BookmarksContract;
import com.jal.flyreading.interfaces.OnRyOnClickListener;

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

    private BookmarksRyAdapter adapter;
    private BookmarksContract.Presenter presenter;

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

        initViews(view);
        setHasOptionsMenu(true);

        Log.e("print","presenter"+presenter);
        presenter.loadResults(false);

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.loadResults(true);
            }
        });
        return view;
    }

    @Override
    public void showResults(ArrayList<ZhiHuDailyNewsEntity.StoriesBean> zhihu, ArrayList<GuokrHandpickNews.ResultBean> guokr, ArrayList<DoubanMomentEntity.PostsBean> douban, ArrayList<Integer> types) {
        if (adapter == null) {
            adapter = new BookmarksRyAdapter(getActivity(), zhihu, guokr, douban, types);
            adapter.setListener(new OnRyOnClickListener() {
                @Override
                public void onItemClick(View view, int position) {
                    int itemViewType = recyclerView.findContainingViewHolder(view).getItemViewType();
                    if (itemViewType == BookmarksRyAdapter.TYPE_DOUBAN_NORMAL) {
                        presenter.startReading(BeanType.TYPE_DOUBAN, position);
                    } else if (itemViewType == BookmarksRyAdapter.TYPE_ZHIHU_NORMAL) {
                        presenter.startReading(BeanType.TYPE_ZHIHU, position);
                    } else if (itemViewType == BookmarksRyAdapter.TYPE_GUOKR_NORMAL) {
                        presenter.startReading(BeanType.TYPE_GUOKR, position);
                    }
                }
            });
            recyclerView.setAdapter(adapter);
        } else {
            adapter.notifyDataSetChanged();
        }


    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_bookmarks, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_search) {
            //跳转到搜索
//            startActivity();
        } else if (item.getItemId() == R.id.action_feel_lucky) {
            presenter.freeLook();

        }
        return true;
    }

    @Override
    public void notifyDataChanged() {
        presenter.loadResults(true);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showLoading() {
        refreshLayout.setRefreshing(true);
    }

    @Override
    public void stopLoading() {
        refreshLayout.setRefreshing(false);
    }

    @Override
    public void setPresenter(BookmarksContract.Presenter presenter) {
        Log.d("print","presenter"+presenter);
        if (presenter != null) {
            this.presenter = presenter;
        }
    }

    @Override
    public void initViews(View view) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        refreshLayout.setColorSchemeResources(R.color.colorPrimary);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
