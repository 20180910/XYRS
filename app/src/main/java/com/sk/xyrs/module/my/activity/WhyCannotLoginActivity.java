package com.sk.xyrs.module.my.activity;

import android.view.View;
import android.widget.TextView;

import com.sk.xyrs.IntentParam;
import com.sk.xyrs.R;
import com.sk.xyrs.base.BaseActivity;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/6/25.
 */

public class WhyCannotLoginActivity extends BaseActivity {

    private String title;
    private String content;

    @BindView(R.id.tv_why_question)
    TextView tv_why_question;

    @Override
    protected int getContentView() {
        return R.layout.why_cannot_login_act;
    }

    @Override
    protected void initView() {
        title = getIntent().getStringExtra(IntentParam.title);
        content = getIntent().getStringExtra(IntentParam.content);
        setAppShortTitle(title);
        tv_why_question.setText(content);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onViewClick(View v) {

    }
}
