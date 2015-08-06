package com.seu.yoyoschoolbeta.adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.seu.yoyoschoolbeta.R;

import java.util.List;

/**
 * Created by wufan on 2015/7/30.
 */
public class FreeGoodsListViewAdapter extends BaseAdapter{

    List<String> list;
    LayoutInflater inflater;
    FragmentActivity activity;

    public FreeGoodsListViewAdapter(FragmentActivity fragmentActivity, List<String> list) {
        this.list = list;
        this.activity = fragmentActivity;
        inflater = (LayoutInflater) fragmentActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = inflater.inflate(R.layout.list_item_free_goods, null);
        }
        return view;
    }
}
