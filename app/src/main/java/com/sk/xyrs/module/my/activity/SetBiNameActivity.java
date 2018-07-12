package com.sk.xyrs.module.my.activity;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.library.base.BaseObj;
import com.sk.xyrs.R;
import com.sk.xyrs.base.BaseActivity;
import com.sk.xyrs.base.MyCallBack;
import com.sk.xyrs.module.my.network.ApiRequest;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

public class SetBiNameActivity extends BaseActivity {
    @BindView(R.id.et_set_biname)
    EditText et_set_biname;
    @Override
    protected int getContentView() {
        setAppTitle("设置笔名");
        setAppRightTitle("确定");
        return R.layout.set_biname_act;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.app_right_tv})
    protected void onViewClick(View v) {
        switch (v.getId()){
            case R.id.app_right_tv:
                if(TextUtils.isEmpty(getSStr(et_set_biname))){
                    showMsg("请输入笔名");
                    return;
                }
                setBiName(getSStr(et_set_biname));
            break;
        }
    }

    private void setBiName(String biName) {
        showLoading();
        Map<String,String> map=new HashMap<String,String>();
        map.put("user_id",getUserId());
        map.put("bi_name",biName);
        map.put("sign",getSign(map));
        ApiRequest.setBiName(map, new MyCallBack<BaseObj>(mContext) {
            @Override
            public void onSuccess(BaseObj obj, int errorCode, String msg) {
                showMsg(msg);
                finish();
            }
        });

    }
}
