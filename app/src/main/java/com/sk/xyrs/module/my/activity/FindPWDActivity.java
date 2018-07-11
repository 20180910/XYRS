package com.sk.xyrs.module.my.activity;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.library.base.BaseObj;
import com.library.base.tools.ZhengZeUtils;
import com.sk.xyrs.R;
import com.sk.xyrs.base.BaseActivity;
import com.sk.xyrs.base.MyCallBack;
import com.sk.xyrs.module.my.network.ApiRequest;
import com.sk.xyrs.network.NetApiRequest;
import com.sk.xyrs.view.MyEditText;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/6/21.
 */

public class FindPWDActivity extends BaseActivity {
    @BindView(R.id.et_findpwd_phone)
    MyEditText et_findpwd_phone;
    @BindView(R.id.et_findpwd_code)
    MyEditText et_findpwd_code;
    @BindView(R.id.et_findpwd_pwd)
    MyEditText et_findpwd_pwd;
    @BindView(R.id.tv_findpwd_getcode)
    TextView tv_findpwd_getcode;
    @BindView(R.id.tv_findpwd_getyuyin)
    TextView tv_findpwd_getyuyin;
    private String msgCode;

    @Override
    protected int getContentView() {
        setAppTitle("找回密码");
        return R.layout.find_pwd_act;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.tv_findpwd_getcode, R.id.tv_findpwd_getyuyin, R.id.iv_findpwd_sure})
    public void onViewClick(View view) {
        switch (view.getId()) {
            case R.id.tv_findpwd_getcode:
                if(ZhengZeUtils.notMobile(getSStr(et_findpwd_phone))){
                    showMsg("请输入正确手机号");
                    return;
                }
                getMsgCode(getSStr(et_findpwd_phone));
                break;
            case R.id.tv_findpwd_getyuyin:
                break;
            case R.id.iv_findpwd_sure:
                String phone=getSStr(et_findpwd_phone);
                String code=getSStr(et_findpwd_code);
                String pwd=getSStr(et_findpwd_pwd);
                if(TextUtils.isEmpty(phone)){
                    showMsg("请输入手机号");
                    return;
                }else if(TextUtils.isEmpty(msgCode)||!msgCode.equals(code)){
                    showMsg("请输入正确验证码");
                    return;
                }else if(!ZhengZeUtils.isShuZiAndZiMu(pwd)||pwd.length()>20||pwd.length()<8){
                    showMsg("请输入8-20位数字加字母的密码");
                    return;
                }
                findPWD(phone,code,pwd);
                break;
        }
    }

    private void findPWD(String phone, String code, String pwd) {
        showLoading();
        Map<String,String>map=new HashMap<String,String>();
        map.put("mobile",phone);
        map.put("newPassword",pwd);
        map.put("sms_code",code);
        map.put("sign",getSign(map));
        ApiRequest.findPWD(map, new MyCallBack<BaseObj>(mContext) {
            @Override
            public void onSuccess(BaseObj obj, int errorCode, String msg) {
                showMsg(msg);
                finish();
            }
        });

    }

    private void getMsgCode(String phone) {
        showLoading();
        Map<String,String> map=new HashMap<String,String>();
        map.put("mobile",phone);
        map.put("type","2");
        map.put("sign",getSign(map));
        NetApiRequest.getMsgCode(map, new MyCallBack<BaseObj>(mContext) {
            @Override
            public void onSuccess(BaseObj obj, int errorCode, String msg) {
                msgCode =obj.getSMSCode();
                countDown(tv_findpwd_getcode);
            }
        });
    }
}
