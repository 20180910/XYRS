package com.sk.xyrs.module.my.fragment;

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

public class LiuLanHistoryFragment extends BaseFragment {
    @BindView(R.id.rv_history)
    RecyclerView rv_history;
    MyAdapter adapter;
    @Override
    protected int getContentView() {
        return R.layout.liulan_history_frag;
    }

    @Override
    protected void initView() {

        adapter=new MyAdapter(mContext,R.layout._item,pageSize) {
            @Override
            public void bindData(MyRecyclerViewHolder holder, int position, Object bean) {

            }
        };
        adapter.setOnLoadMoreListener(this);
        rv_history.setAdapter(adapter);

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onViewClick(View v) {

    }
}
