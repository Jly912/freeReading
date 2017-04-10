package com.jal.flyreading.adpter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jal.flyreading.R;
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

    public static final int TYPE_ZHIHU_NORMAL = 0;
    public static final int TYPE_ZHIHU_HEAD = 1;
    public static final int TYPE_DOUBAN_NORMAL = 2;
    public static final int TYPE_DOUBAN_HEAD = 3;
    public static final int TYPE_GUOKR_NORMAL = 4;
    public static final int TYPE_GUOKR_HEAD = 5;


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
        switch (viewType) {
            case TYPE_DOUBAN_NORMAL:
            case TYPE_GUOKR_NORMAL:
            case TYPE_ZHIHU_NORMAL:
                View inflate = LayoutInflater.from(context).inflate(R.layout.item_bookmark, parent, false);
                return new NormalViewHolder(inflate, this.listener);
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_bookmark_header, parent, false);
        return new WithTypeViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (types.get(position)) {
            case TYPE_ZHIHU_HEAD:
                ((WithTypeViewHolder) holder).tvType.setText(R.string.zhihu_daily);
                break;
            case TYPE_ZHIHU_NORMAL:
                if (!zhihuData.isEmpty()) {
                    ZhiHuDailyNewsEntity.StoriesBean storiesBean = zhihuData.get(position - 1);

                    ((NormalViewHolder) holder).tvTitle.setText(storiesBean.getTitle());
                    Glide.with(context)
                            .load(storiesBean.getImages().get(0))
                            .placeholder(R.mipmap.placeholder)
                            .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                            .error(R.mipmap.placeholder)
                            .centerCrop()
                            .into(((NormalViewHolder) holder).ivCover);
                }

                break;
            case TYPE_DOUBAN_HEAD:
                ((WithTypeViewHolder) holder).tvType.setText(R.string.douban_moment);
                break;
            case TYPE_DOUBAN_NORMAL:
                if (!doubanData.isEmpty()) {
                    DoubanMomentEntity.PostsBean postsBean = doubanData.get(position - 3);
                    ((NormalViewHolder) holder).tvTitle.setText(postsBean.getTitle());
                    if (postsBean.getThumbs().size() == 0) {
                        ((NormalViewHolder) holder).ivCover.setVisibility(View.INVISIBLE);
                    } else {
                        Glide.with(context)
                                .load(postsBean.getThumbs().get(0).getMedium().getUrl())
                                .asBitmap()
                                .placeholder(R.mipmap.placeholder)
                                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                                .error(R.mipmap.placeholder)
                                .centerCrop()
                                .into(((NormalViewHolder) holder).ivCover);
                    }


                }
                break;
            case TYPE_GUOKR_HEAD:
                ((WithTypeViewHolder) holder).tvType.setText(R.string.guokr_handpick);
                break;
            case TYPE_GUOKR_NORMAL:
                if (!guokrData.isEmpty()) {
                    GuokrHandpickNews.ResultBean resultBean = guokrData.get(position - 2);
                    ((NormalViewHolder) holder).tvTitle.setText(resultBean.getTitle());

                    Glide.with(context)
                            .load(resultBean.getHeadline_img_tb())
                            .asBitmap()
                            .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                            .error(R.mipmap.placeholder)
                            .centerCrop()
                            .into(((NormalViewHolder) holder).ivCover);
                }
                break;
        }

    }

    public void setListener(OnRyOnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public int getItemViewType(int position) {
        return types.get(position);
    }

    @Override
    public int getItemCount() {
        return types.size();
    }

    public class NormalViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tvTitle;
        ImageView ivCover;
        OnRyOnClickListener listener;

        public NormalViewHolder(View itemView, OnRyOnClickListener listener) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            ivCover = (ImageView) itemView.findViewById(R.id.iv_cover);
            this.listener = listener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (listener != null) {
                Log.e("print", "getadapter:" + getAdapterPosition() + "getlayout:" + getLayoutPosition());
                listener.onItemClick(v, getAdapterPosition());
            }
        }
    }

    public class WithTypeViewHolder extends RecyclerView.ViewHolder {

        TextView tvType;

        public WithTypeViewHolder(View itemView) {
            super(itemView);
            tvType = (TextView) itemView.findViewById(R.id.tv_type);
        }
    }
}
