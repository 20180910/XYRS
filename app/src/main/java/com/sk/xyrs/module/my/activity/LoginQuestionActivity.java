package com.sk.xyrs.module.my.activity;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.github.androidtools.inter.MyOnClickListener;
import com.github.baseclass.adapter.MyRecyclerViewHolder;
import com.sk.xyrs.IntentParam;
import com.sk.xyrs.R;
import com.sk.xyrs.adapter.MyAdapter;
import com.sk.xyrs.base.BaseActivity;
import com.sk.xyrs.base.MyCallBack;
import com.sk.xyrs.module.my.network.ApiRequest;
import com.sk.xyrs.module.my.network.response.LoginQuestionObj;

import java.util.HashMap;
import java.util.List;
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
        adapter=new MyAdapter<LoginQuestionObj>(mContext,R.layout.login_question_item,pageSize) {
            @Override
            public void bindData(MyRecyclerViewHolder holder, int position, final LoginQuestionObj bean) {
                holder.setText(R.id.tv_login_question,bean.getTitle());
                holder.itemView.setOnClickListener(new MyOnClickListener() {
                    @Override
                    protected void onNoDoubleClick(View view) {
                        Intent intent=new Intent();
                        intent.putExtra(IntentParam.title,bean.getTitle());
                        intent.putExtra(IntentParam.content,bean.getContent());
                        STActivity(intent,WhyCannotLoginActivity.class);
                    }
                });
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
    protected void getData(int page, final boolean isLoad) {
        super.getData(page, isLoad);
        Map<String,String> map=new HashMap<String,String>();
        map.put("rnd",getRnd());
        map.put("sign",getSign(map));
        ApiRequest.getLoginProblems(map, new MyCallBack<List<LoginQuestionObj>>(mContext,pl_load,pcfl) {
            @Override
            public void onSuccess(List<LoginQuestionObj> list, int errorCode, String msg) {
                if(isLoad){
                    pageNum++;
                    adapter.addList(list,true);
                }else{
                    pageNum=2;
                    adapter.setList(list,true);
                }
            }
        });

    }

    @Override
    protected void onViewClick(View v) {

    }
}
