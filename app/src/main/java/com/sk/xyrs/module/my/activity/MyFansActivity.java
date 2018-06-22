package com.sk.xyrs.module.my.activity;

import android.view.View;

import com.github.baseclass.adapter.MyRecyclerViewHolder;
import com.library.base.view.MyRecyclerView;
import com.sk.xyrs.R;
import com.sk.xyrs.adapter.MyAdapter;
import com.sk.xyrs.base.BaseActivity;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/6/21.
 */

public class MyFansActivity extends BaseActivity  {


    @Override
    protected int getContentView() {
        setAppRightTitle("我的粉丝");
        return R.layout.my_fans_act;
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
