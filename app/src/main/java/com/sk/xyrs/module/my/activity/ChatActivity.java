package com.sk.xyrs.module.my.activity;

import android.view.View;

import com.github.baseclass.adapter.MyRecyclerViewHolder;
import com.library.base.view.MyRecyclerView;
import com.sk.xyrs.R;
import com.sk.xyrs.adapter.MyAdapter;
import com.sk.xyrs.base.BaseActivity;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/6/22.
 */

public class ChatActivity extends BaseActivity {
    @BindView(R.id.rv_chat)
    MyRecyclerView rv_chat;
    MyAdapter adapter;
    @Override
    protected int getContentView() {
        setAppRightImg(R.drawable.chat_more);
        return R.layout.chat_act;
    }

    @Override
    protected void initView() {
        setAppTitle("聊天");
        adapter=new MyAdapter(mContext,R.layout.chat_item,pageSize) {
            @Override
            public void bindData(MyRecyclerViewHolder holder, int position, Object bean) {

            }
        };
        adapter.setOnLoadMoreListener(this);
        rv_chat.setAdapter(adapter,0);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onViewClick(View v) {

    }
}
