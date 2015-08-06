package com.seu.yoyoschoolbeta.core;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.seu.yoyoschoolbeta.R;
import com.seu.yoyoschoolbeta.adapter.FreeGoodsListViewAdapter;
import com.seu.yoyoschoolbeta.view.SlidingTabs.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wufan on 2015/8/5.
 */
public class FreeGoodsTabListViewFragment extends BaseFragment {

    private static final String DATA_NAME = "name";

    private String title = "";

    private PullToRefreshListView mPullToRefreshListView;
    private List<String> mGoodsListData = null;
    FreeGoodsListViewAdapter mFreeGoodsListAdapter;

    public static FreeGoodsTabListViewFragment newInstance(String title, int indicatorColor, int dividerColor) {
        FreeGoodsTabListViewFragment f = new FreeGoodsTabListViewFragment();
        f.setTitle(title);
        f.setIndicatorColor(indicatorColor);
        f.setDividerColor(dividerColor);

        //pass data
        Bundle args = new Bundle();
        args.putString(DATA_NAME, title);
        f.setArguments(args);

        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //get data
        title = getArguments().getString(DATA_NAME);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.list_free_goods, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mPullToRefreshListView = (PullToRefreshListView) view.findViewById(R.id.free_goods_pager_list);
        mPullToRefreshListView.setMode(com.handmark.pulltorefresh.library.PullToRefreshBase.Mode.BOTH);

        mGoodsListData = getData();
        mFreeGoodsListAdapter = new FreeGoodsListViewAdapter(getActivity(), mGoodsListData);
        mPullToRefreshListView.setAdapter(mFreeGoodsListAdapter);

//        mPullToRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
//            @Override
//            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
//                mFreeGoodsListAdapter.notifyDataSetChanged();
//                mPullToRefreshListView.onRefreshComplete();
//            }
//
//            @Override
//            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
//                mFreeGoodsListAdapter.notifyDataSetChanged();
//                mPullToRefreshListView.onRefreshComplete();
//            }
//        });
        //  mPullToRefreshListView.setEmptyView(emptyView);
//        mPullToRefreshListView.setOnScrollListener(new AbsListView.OnScrollListener() {
//            @Override
//            public void onScrollStateChanged(AbsListView view, int scrollState) {
//            }
//
//            @Override
//            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
//                if (firstVisibleItem + visibleItemCount == totalItemCount) {
//                    adapter.notifyDataSetChanged();
//                }
//            }
//        });


//        mPullToRefreshListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//            }
//        });
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public List<String> getData() {     //动态的从后台获取定额数据用于更新
        int size = 0;
        if (mGoodsListData != null) {
            size = mGoodsListData.size();
        }
        if (mGoodsListData == null) {
            mGoodsListData = new ArrayList<String>();
        }

        for (int i = 0; i < 20; i++) {
            mGoodsListData.add("item" + i + size);
        }

        return mGoodsListData;
    }
}
