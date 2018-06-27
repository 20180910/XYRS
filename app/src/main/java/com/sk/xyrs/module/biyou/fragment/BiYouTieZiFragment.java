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
 * Created by Administrator on 2018/6/20.
 */

public class BiYouTieZiFragment extends BaseFragment {
    @BindView(R.id.rv_bihui_tiezi)
    RecyclerView rv_bihui_tiezi;
    MyAdapter adapter;
    @Override
    protected int getContentView() {
        return R.layout.biyou_tiezi_frag;
    }

    public static BiYouTieZiFragment newInstance() {

        Bundle args = new Bundle();

        BiYouTieZiFragment fragment = new BiYouTieZiFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initView() {
        adapter=new MyAdapter(mContext,R.layout.biyou_tiezi_item,pageSize) {
            @Override
            public void bindData(MyRecyclerViewHolder holder, int position, Object bean) {

            }
        };
        adapter.setOnLoadMoreListener(this);
        adapter.setTestListSize(11);

        rv_bihui_tiezi.setAdapter(adapter);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onViewClick(View v) {

    }
}
