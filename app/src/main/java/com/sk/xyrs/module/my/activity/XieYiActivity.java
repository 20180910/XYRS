package com.sk.xyrs.module.my.activity;

import android.support.v4.content.ContextCompat;
import android.view.View;

import com.library.base.BaseObj;
import com.library.base.view.richedit.TheEditor;
import com.sk.xyrs.IntentParam;
import com.sk.xyrs.R;
import com.sk.xyrs.base.BaseActivity;
import com.sk.xyrs.base.MyCallBack;
import com.sk.xyrs.module.my.network.ApiRequest;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/6/21.
 */

public class XieYiActivity extends BaseActivity {
    String type="1";
    @BindView(R.id.te_xieyi)
    TheEditor te_xieyi;
    @Override
    protected int getContentView() {
        setAppTitle("用户协议");
        return R.layout.xie_yi_act;
    }

    @Override
    protected void initView() {
        type=getIntent().getStringExtra(IntentParam.xieYiType);
        switch (type){
            case "1":
                setAppTitle("用户协议");
            break;
        }
        showProgress();
        getData(1,false);
    }

    @Override
    protected void getData(int page, boolean isLoad) {
        super.getData(page, isLoad);
        Map<String,String> map=new HashMap<String,String>();
        map.put("type",type);
        map.put("sign",getSign(map));
        ApiRequest.getXieYi(map, new MyCallBack<BaseObj>(mContext,pl_load,pcfl) {
            @Override
            public void onSuccess(BaseObj obj, int errorCode, String msg) {
                te_xieyi.setHtml(obj.getAgreement());
                te_xieyi.setInputEnabled(false);
                te_xieyi.setEditorFontColor(ContextCompat.getColor(mContext,R.color.theme_text1));
                te_xieyi.setEditorFontSize(13);
            }
        });

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onViewClick(View v) {

    }
}
