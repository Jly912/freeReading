package com.jal.flyreading.adpter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.jal.flyreading.R;
import com.jal.flyreading.homePages.DoubanFragment;
import com.jal.flyreading.homePages.GuokrFragment;
import com.jal.flyreading.homePages.ZhiHuDailyFragment;

/**
 * Created by SEELE on 2017/4/6.
 */

public class MainPagerAdapter extends FragmentPagerAdapter {

    private String[] titles;

    private Context context;

    private ZhiHuDailyFragment zhiHuDailyFragment;
    private GuokrFragment guokrFragment;
    private DoubanFragment doubanFragment;

    public ZhiHuDailyFragment getZhiHuDailyFragment() {
        return zhiHuDailyFragment;
    }

    public GuokrFragment getGuokrFragment() {
        return guokrFragment;
    }

    public DoubanFragment getDoubanFragment() {
        return doubanFragment;
    }

    public MainPagerAdapter(FragmentManager fm, Context context,
                            ZhiHuDailyFragment zhiHuDailyFragment,
                            GuokrFragment guokrFragment,
                            DoubanFragment doubanFragment) {
        super(fm);
        this.context = context;
        titles = new String[]{context.getResources().getString(R.string.zhihu_daily),
                context.getResources().getString(R.string.guokr_handpick),
                context.getResources().getString(R.string.douban_moment)};

        this.zhiHuDailyFragment = zhiHuDailyFragment;
        this.guokrFragment = guokrFragment;
        this.doubanFragment = doubanFragment;
    }


    @Override
    public Fragment getItem(int position) {
        if (position == 1) {
            return guokrFragment;
        } else if (position == 2) {
            return doubanFragment;
        }
        return zhiHuDailyFragment;
    }

    @Override
    public int getCount() {
        return titles.length > 0 ? titles.length : 0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return super.getPageTitle(position);
    }
}
