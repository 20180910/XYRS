package com.sk.xyrs.module.my.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.github.baseclass.adapter.MyRecyclerViewHolder;
import com.sk.xyrs.R;
import com.sk.xyrs.adapter.MyAdapter;
import com.sk.xyrs.base.BaseFragment;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/6/22.
 */

public class MyGuanZhuFragment extends BaseFragment {
    @BindView(R.id.rv_my_guanzhu)
    RecyclerView rv_my_guanzhu;

    MyAdapter adapter;

    @Override
    protected int getContentView() {
        return R.layout.my_guan_zhu_frag;
    }

    @Override
    protected void initView() {
        adapter=new MyAdapter(mContext,R.layout.my_guan_zhu_item,pageSize) {
            @Override
            public void bindData(MyRecyclerViewHolder holder, int position, Object bean) {

            }
        };
        adapter.setOnLoadMoreListener(this);
        rv_my_guanzhu.setAdapter(adapter);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onViewClick(View v) {

    }
}
