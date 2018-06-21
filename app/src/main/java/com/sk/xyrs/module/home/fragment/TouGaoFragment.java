package com.sk.xyrs.module.home.fragment;

import android.os.Bundle;
import android.view.View;

import com.sk.xyrs.R;
import com.sk.xyrs.base.BaseFragment;

/**
 * Created by Administrator on 2018/6/20.
 */

public class TouGaoFragment extends BaseFragment {
    @Override
    protected int getContentView() {
        return R.layout.my_frag;
    }

    public static TouGaoFragment newInstance() {
        Bundle args = new Bundle();

        TouGaoFragment fragment = new TouGaoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onViewClick(View v) {

    }
}