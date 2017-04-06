package com.jal.flyreading.homePages;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.jal.flyreading.R;
import com.jal.flyreading.adpter.MainPagerAdapter;
import com.jal.flyreading.presenter.DoubanPresenter;
import com.jal.flyreading.presenter.GuokrPresenter;
import com.jal.flyreading.presenter.ZhiHuDailyPresenter;

import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by SEELE on 2017/4/6.
 */

public class MainFragment extends Fragment {

    @Bind(R.id.tab)
    TabLayout tab;
    @Bind(R.id.main_vp)
    ViewPager mainVp;
    @Bind(R.id.fab_button)
    FloatingActionButton fabButton;


    private Context context;
    private MainPagerAdapter adapter;

    private ZhiHuDailyFragment zhiHuDailyFragment;
    private GuokrFragment guokrFragment;
    private DoubanFragment doubanFragment;

    private ZhiHuDailyPresenter zhiHuDailyPresenter;
    private GuokrPresenter guokrPresenter;
    private DoubanPresenter doubanPresenter;

    public MainFragment() {
    }

    public static MainFragment getInstance() {
        return new MainFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.context = getActivity();

        if (savedInstanceState != null) {
            FragmentManager manager = getChildFragmentManager();
            zhiHuDailyFragment = (ZhiHuDailyFragment) manager.getFragment(savedInstanceState, "zhihu");
            guokrFragment = (GuokrFragment) manager.getFragment(savedInstanceState, "guokr");
            doubanFragment = (DoubanFragment) manager.getFragment(savedInstanceState, "douban");
        } else {
            zhiHuDailyFragment = ZhiHuDailyFragment.getInstance();
            guokrFragment = GuokrFragment.getInstance();
            doubanFragment = DoubanFragment.getInstance();
        }

        zhiHuDailyPresenter = new ZhiHuDailyPresenter(context, zhiHuDailyFragment);
        guokrPresenter = new GuokrPresenter(context, guokrFragment);
        doubanPresenter = new DoubanPresenter(context, doubanFragment);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);
        initViews(view);

        /**
         * 通过onCreateOptionsMenu()，fragment可以为activity的Options Menu提供菜单项。为了确保这一方法成功实现回调。必须在onCreate()期间调用setHasOptionsMenu()告知Options Menu fragment要添加菜单项。

         通过fragment添加的菜单会添加在已有菜单之后。选中菜单项时，fragment也会接收onOptionsItemSelected()回调。

         通过registerForContextMenu()注册，onCreateContextMenu()接收用户打开信息，onContextItemSelected()接收用户点击信息可以实现Context Menu。

         用户点击菜单的信息首先传递给activity，如果activity不处理，则传递给fragment。
         */
        setHasOptionsMenu(true);

        // 当tab layout位置为果壳精选时，隐藏fab
        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 1) {
                    fabButton.hide();
                } else {
                    fabButton.show();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return view;
    }

    private void initViews(View view) {
        mainVp.setOffscreenPageLimit(3);
        adapter = new MainPagerAdapter(getChildFragmentManager(), context, zhiHuDailyFragment, guokrFragment, doubanFragment);
        mainVp.setAdapter(adapter);
        tab.setupWithViewPager(mainVp);
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.main, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_feel_lucky) {
            feelLucky();
        }

        return true;
    }

    /**
     * 将状态保存
     *
     * @param outState
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        FragmentManager manager = getChildFragmentManager();
        manager.putFragment(outState, "zhihu", zhiHuDailyFragment);
        manager.putFragment(outState, "douban", doubanFragment);
        manager.putFragment(outState, "guokr", guokrFragment);

    }


    private void feelLucky() {
        Random random = new Random();
        int type = random.nextInt(3);
        switch (type) {
            case 0:
                zhiHuDailyPresenter.freeLook();
                break;
            case 1:
                guokrPresenter.freeLook();
                break;
            default:
                doubanPresenter.freeLook();
        }

    }


    public MainPagerAdapter getAdapter() {
        return adapter;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
