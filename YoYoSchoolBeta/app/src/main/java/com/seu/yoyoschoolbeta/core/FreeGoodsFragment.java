package com.seu.yoyoschoolbeta.core;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.seu.yoyoschoolbeta.R;
import com.seu.yoyoschoolbeta.adapter.TabFragmentPagerAdapter;
import com.seu.yoyoschoolbeta.sharedata.StaticData;
import com.seu.yoyoschoolbeta.view.SlidingTabs.BaseFragment;
import com.seu.yoyoschoolbeta.view.SlidingTabs.SlidingTabLayout;

import java.util.LinkedList;

/**
 * Created by wufan on 2015/8/5.
 */
public class FreeGoodsFragment extends Fragment {

    private SlidingTabLayout tabs;
    private ViewPager pager;
    private FragmentPagerAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_free_goods, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        //adapter
        final LinkedList<BaseFragment> fragments = geFragments();
        adapter = new TabFragmentPagerAdapter(getFragmentManager(), fragments);
        //pager
        pager = (ViewPager) view.findViewById((R.id.free_goods_pager));
        pager.setAdapter(adapter);
        //tabs
        tabs = (SlidingTabLayout) view.findViewById(R.id.free_goods_tabs);
        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {    //引导线与间隔线的颜色设置
            @Override
            public int getIndicatorColor(int position) {
                return fragments.get(position).getIndicatorColor();
            }

            @Override
            public int getDividerColor(int position) {
                return fragments.get(position).getDividerColor();
            }
        });
        tabs.setCustomTabView(R.layout.tabs_text_free_goods, R.id.free_goods_tabs_text);  //tabs的各选项设置
        tabs.setDividerEnable(true);
        tabs.setDistributeEvenly(true);
        tabs.setBackgroundResource(R.color.tab_color);   //tab背景颜色
        tabs.setViewPager(pager);
    }

    private LinkedList<BaseFragment> geFragments() {
        int indicatorColor = Color.parseColor(this.getResources().getString(R.color.yellow));
        int dividerColor = Color.TRANSPARENT;     //间隔线隐藏
        LinkedList<BaseFragment> fragments = new LinkedList<BaseFragment>();
        //tabs title的数据是静态的,直接获取。
        fragments.add(new FreeGoodsTabListViewFragment().newInstance("最新", indicatorColor, dividerColor));
        fragments.add(new FreeGoodsTabListViewFragment().newInstance("最热", indicatorColor, dividerColor));
        fragments.add(new FreeGoodsTabListViewFragment().newInstance(StaticData.FreeGoodsKinds[0], indicatorColor, dividerColor));
        fragments.add(new FreeGoodsTabListViewFragment().newInstance(StaticData.FreeGoodsKinds[1], indicatorColor, dividerColor));
        fragments.add(new FreeGoodsTabListViewFragment().newInstance(StaticData.FreeGoodsKinds[2], indicatorColor, dividerColor));
        fragments.add(new FreeGoodsTabListViewFragment().newInstance(StaticData.FreeGoodsKinds[3], indicatorColor, dividerColor));

        return fragments;
    }
}


