package com.sk.xyrs.module.home.fragment;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.TextView;

import com.sk.xyrs.R;
import com.sk.xyrs.base.BaseFragment;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/6/20.
 */

public class MyFragment extends BaseFragment {
    @BindView(R.id.app_title)
    TextView app_title;
    @BindView(R.id.app_right_tv)
    TextView app_right_tv;

    @Override
    protected int getContentView() {
        return R.layout.my_frag;
    }

    public static MyFragment newInstance() {

        Bundle args = new Bundle();

        MyFragment fragment = new MyFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initView() {
        app_title.setText("我的");
        app_title.setTextColor(ContextCompat.getColor(mContext,R.color.theme_text1));

        app_right_tv.setText("设置");
        app_right_tv.setTextColor(ContextCompat.getColor(mContext,R.color.theme_text2));
    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.app_right_tv})
    protected void onViewClick(View v) {
        switch (v.getId()){
            case R.id.app_right_tv:

            break;
        }
    }
}