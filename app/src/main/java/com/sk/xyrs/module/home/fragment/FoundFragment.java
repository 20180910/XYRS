package com.sk.xyrs.module.home.fragment;

import android.os.Bundle;
import android.view.View;

import com.sk.xyrs.R;
import com.sk.xyrs.base.BaseFragment;

/**
 * Created by Administrator on 2018/6/20.
 */

public class FoundFragment extends BaseFragment {
    @Override
    protected int getContentView() {
        return R.layout.found_frag;
    }

    public static FoundFragment newInstance() {
        Bundle args = new Bundle();

        FoundFragment fragment = new FoundFragment();
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
