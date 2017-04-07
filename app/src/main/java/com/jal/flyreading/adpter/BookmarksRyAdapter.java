package com.jal.flyreading.adpter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.jal.flyreading.bean.DoubanMomentEntity;
import com.jal.flyreading.bean.GuokrHandpickNews;
import com.jal.flyreading.bean.ZhiHuDailyNewsEntity;
import com.jal.flyreading.interfaces.OnRyOnClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SEELE on 2017/4/7.
 */

public class BookmarksRyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<DoubanMomentEntity.PostsBean> doubanData;
    private List<GuokrHandpickNews.ResultBean> guokrData;
    private List<ZhiHuDailyNewsEntity.StoriesBean> zhihuData;

    private List<Integer> types;

    public OnRyOnClickListener listener;

    private static final int TYPE_ZHIHU_NORMAL = 0;
    private static final int TYPE_ZHIHU_HEAD = 1;
    private static final int TYPE_DOUBAN_NORMAL = 2;
    private static final int TYPE_DOUBAN_HEAD = 3;
    private static final int TYPE_GUOKR_NORMAL = 4;
    private static final int TYPE_GUOKR_HEAD = 5;


    public BookmarksRyAdapter(@Nullable Context context, ArrayList<ZhiHuDailyNewsEntity.StoriesBean> zhihuData,
                              ArrayList<GuokrHandpickNews.ResultBean> guokrData,
                              ArrayList<DoubanMomentEntity.PostsBean> doubanData,
                              ArrayList<Integer> types) {
        this.context = context;
        this.doubanData = doubanData;
        this.zhihuData = zhihuData;
        this.guokrData = guokrData;

        this.types = types;

    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case TYPE_DOUBAN_NORMAL:
            case TYPE_GUOKR_NORMAL:
            case TYPE_ZHIHU_NORMAL:
//                LayoutInflater.from(context).inflate(R.layout)
//                return
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
