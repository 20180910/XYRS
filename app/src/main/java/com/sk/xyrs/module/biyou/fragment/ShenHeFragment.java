package com.sk.xyrs.module.biyou.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.github.baseclass.adapter.MyRecyclerViewHolder;
import com.sk.xyrs.R;
import com.sk.xyrs.adapter.MyAdapter;
import com.sk.xyrs.base.BaseFragment;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/6/28.
 */

public class ShenHeFragment extends BaseFragment {
    @BindView(R.id.rv_shenhe)
    RecyclerView rv_shenhe;
    MyAdapter adapter;
    @Override
    protected int getContentView() {
        return R.layout.shen_he_frag;
    }

    public static ShenHeFragment newInstance() {
        Bundle args = new Bundle();

        ShenHeFragment fragment = new ShenHeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initView() {
        adapter=new MyAdapter(mContext,R.layout.shen_he_item,pageSize) {
            @Override
            public void bindData(MyRecyclerViewHolder holder, int position, Object bean) {

            }
        };
        adapter.setOnLoadMoreListener(this);
        rv_shenhe.setAdapter(adapter);

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onViewClick(View v) {

    }
}
