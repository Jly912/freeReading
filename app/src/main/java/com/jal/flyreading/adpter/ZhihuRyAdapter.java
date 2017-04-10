package com.jal.flyreading.adpter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.jal.flyreading.bean.ZhiHuDailyNewsEntity;
import com.jal.flyreading.interfaces.OnRyOnClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SEELE on 2017/4/10.
 */

public class ZhihuRyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<ZhiHuDailyNewsEntity.StoriesBean> data=new ArrayList<>();
    private OnRyOnClickListener listener;

    private static int TYPE_NORMAL=0;
    private static int TYPE_FOOTER=1;

    public ZhihuRyAdapter(Context context,List<ZhiHuDailyNewsEntity.StoriesBean> data){
        this.context=context;
        this.data=data;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemViewType(int position) {
        if(position==data.size()){
            return TYPE_FOOTER;
        }
        return TYPE_NORMAL;
    }

    public void setListener(OnRyOnClickListener listener){
        this.listener=listener;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ZhiHuNormalViewHolder extends RecyclerView.ViewHolder{

        public ZhiHuNormalViewHolder(View itemView) {
            super(itemView);
        }
    }

    public class FooterViewHolder extends RecyclerView.ViewHolder{

        public FooterViewHolder(View itemView) {
            super(itemView);
        }
    }

}
