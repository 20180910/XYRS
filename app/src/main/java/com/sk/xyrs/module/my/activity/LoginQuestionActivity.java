package com.sk.xyrs.module.my.activity;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.github.baseclass.adapter.MyRecyclerViewHolder;
import com.library.base.BaseObj;
import com.sk.xyrs.R;
import com.sk.xyrs.adapter.MyAdapter;
import com.sk.xyrs.base.BaseActivity;
import com.sk.xyrs.base.MyCallBack;
import com.sk.xyrs.module.my.network.ApiRequest;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/6/25.
 */

public class LoginQuestionActivity extends BaseActivity {
    @BindView(R.id.rv_question)
    RecyclerView rv_question;
    MyAdapter adapter;

    @Override
    protected int getContentView() {
        setAppTitle("登录遇到的问题");
        return R.layout.login_question_act;
    }

    @Override
    protected void initView() {
        adapter=new MyAdapter(mContext,R.layout.login_question_item,pageSize) {
            @Override
            public void bindData(MyRecyclerViewHolder holder, int position, Object bean) {

            }
        };
        adapter.setOnLoadMoreListener(this);
        rv_question.setAdapter(adapter);
    }

    @Override
    protected void initData() {
        showProgress();
        getData(1,false);
    }

    @Override
    protected void getData(int page, boolean isLoad) {
        super.getData(page, isLoad);
        Map<String,String> map=new HashMap<String,String>();
        map.put("rnd",getRnd());
        map.put("sign",getSign(map));
        ApiRequest.getLoginProblems(map, new MyCallBack<BaseObj>(mContext,pl_load,pcfl) {
            @Override
            public void onSuccess(BaseObj obj, int errorCode, String msg) {

            }
        });

    }

    @Override
    protected void onViewClick(View v) {

    }
}
