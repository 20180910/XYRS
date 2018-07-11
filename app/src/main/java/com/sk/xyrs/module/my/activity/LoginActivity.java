package com.sk.xyrs.module.my.activity;

import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.androidtools.SPUtils;
import com.github.rxbus.RxBus;
import com.library.base.BaseObj;
import com.library.base.tools.ZhengZeUtils;
import com.sk.xyrs.AppXml;
import com.sk.xyrs.Constant;
import com.sk.xyrs.IntentParam;
import com.sk.xyrs.R;
import com.sk.xyrs.base.BaseActivity;
import com.sk.xyrs.base.MyCallBack;
import com.sk.xyrs.event.LoginSuccessEvent;
import com.sk.xyrs.module.my.network.ApiRequest;
import com.sk.xyrs.module.my.network.response.LoginObj;
import com.sk.xyrs.network.NetApiRequest;
import com.sk.xyrs.view.MyEditText;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/6/20.
 */

public class LoginActivity extends BaseActivity {

    @BindView(R.id.tv_pwd_login)
    TextView tv_pwd_login;

    @BindView(R.id.iv_pwd_login_close)
    ImageView iv_pwd_login_close;

    @BindView(R.id.et_login_phone)
    MyEditText et_login_phone;

    @BindView(R.id.et_login_code)
    MyEditText et_login_code;

    @BindView(R.id.ll_login_disanfang)
    LinearLayout ll_login_disanfang;

    @BindView(R.id.tv_login_yuyin)
    TextView tv_login_yuyin;

    @BindView(R.id.tv_login_xieyi)
    TextView tv_login_xieyi;

    @BindView(R.id.tv_login_getcode)
    TextView tv_login_getcode;

    @BindView(R.id.iv_login_login)
    ImageView iv_login_login;

    @BindView(R.id.ll_login_queding)
    LinearLayout ll_login_queding;

    @BindView(R.id.tv_login_question)
    TextView tv_login_question;

    String msgCode;

    @Override
    protected int getContentView() {
        return R.layout.login_act;
    }

    @Override
    protected void initView() {
        ll_login_disanfang.setVisibility(View.VISIBLE);
        ll_login_queding.setVisibility(View.GONE);

        et_login_phone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                if(TextUtils.isEmpty(s.toString())){
                    ll_login_disanfang.setVisibility(View.VISIBLE);
                    ll_login_queding.setVisibility(View.GONE);
                }else{
                    ll_login_disanfang.setVisibility(View.GONE);
                    ll_login_queding.setVisibility(View.VISIBLE);
                }
            }
        });
        et_login_code.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                if(!TextUtils.isEmpty(msgCode)&&!TextUtils.isEmpty(et_login_code.getText().toString())&&!TextUtils.isEmpty(et_login_phone.getText().toString())&&msgCode.equals(getSStr(et_login_code))){
                    login();
                }
            }
        });
    }
    private void login() {
        showLoading();
        Map<String,String>map=new HashMap<String,String>();
        map.put("mobile",et_login_phone.getText().toString());
        map.put("code",et_login_code.getText().toString());
        map.put("registrationid", SPUtils.getString(mContext, Constant.registrationId,"0"));
        map.put("sign",getSign(map));
        ApiRequest.loginForMsg(map, new MyCallBack<LoginObj>(mContext) {
            @Override
            public void onSuccess(LoginObj obj, int errorCode, String msg) {
                setUserData(obj);
            }
            private void setUserData(LoginObj obj) {

                SPUtils.setPrefString(mContext, AppXml.userId,obj.getUser_id());
                SPUtils.setPrefString(mContext, AppXml.mobile,obj.getMobile());
                SPUtils.setPrefString(mContext, AppXml.bi_name,obj.getBi_name());
                SPUtils.setPrefString(mContext, AppXml.signature,obj.getSignature());
                SPUtils.setPrefString(mContext, AppXml.sex,obj.getSex());
                SPUtils.setPrefString(mContext, AppXml.birthday,obj.getBirthday());
                SPUtils.setPrefString(mContext, AppXml.province,obj.getProvince());
                SPUtils.setPrefString(mContext, AppXml.area,obj.getArea());
                SPUtils.setPrefString(mContext, AppXml.city,obj.getCity());

                SPUtils.setPrefInt(mContext, AppXml.rongshu_leaf,obj.getRongshu_leaf());
                SPUtils.setPrefInt(mContext, AppXml.card_bag,obj.getCard_bag());
                SPUtils.setPrefInt(mContext, AppXml.guanzhu,obj.getGuanzhu());
                SPUtils.setPrefInt(mContext, AppXml.fensi,obj.getFensi());
                SPUtils.setPrefInt(mContext, AppXml.create_value,obj.getCreate_value());

                SPUtils.setPrefString(mContext, AppXml.create_name,obj.getCreate_name());

                SPUtils.setPrefInt(mContext, AppXml.create_fenshu,obj.getCreate_fenshu());
                SPUtils.setPrefInt(mContext, AppXml.create_xing_num,obj.getCreate_xing_num());
                SPUtils.setPrefInt(mContext, AppXml.read_value,obj.getRead_value());

                SPUtils.setPrefString(mContext, AppXml.read_name,obj.getRead_name());

                SPUtils.setPrefInt(mContext, AppXml.read_fenshu,obj.getRead_fenshu());
                SPUtils.setPrefInt(mContext, AppXml.read_xing_num,obj.getRead_xing_num());
                SPUtils.setPrefInt(mContext, AppXml.is_show_biaoqian,obj.getIs_show_biaoqian());
                SPUtils.setPrefInt(mContext, AppXml.is_show_nicheng,obj.getIs_show_nicheng());

                RxBus.getInstance().post(new LoginSuccessEvent(LoginSuccessEvent.status_1));
                finish();
            }
        });

    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.tv_login_yuyin,R.id.tv_login_xieyi,R.id.tv_login_getcode,R.id.tv_pwd_login, R.id.iv_pwd_login_close, R.id.iv_login_login, R.id.tv_login_question})
    public void onViewClick(View view) {
        switch (view.getId()) {
            case R.id.tv_login_yuyin:
                break;
            case R.id.tv_login_xieyi:
                Intent intent=new Intent();
                intent.putExtra(IntentParam.xieYiType,"1");
                STActivity(intent,XieYiActivity.class);
                break;
            case R.id.tv_login_getcode:
                if(ZhengZeUtils.notMobile(getSStr(et_login_phone))){
                    showMsg("请输入正确手机号");
                    return;
                }
                getMsgCode(getSStr(et_login_code));
                break;
            case R.id.tv_pwd_login:

                break;
            case R.id.iv_pwd_login_close:
                finish();
                break;
            case R.id.iv_login_login:
                if(TextUtils.isEmpty(et_login_phone.getText().toString())){
                    showMsg("请输入手机号");
                    return;
                }else if(TextUtils.isEmpty(msgCode)||!msgCode.equals(getSStr(et_login_code))){
                    showMsg("请输入正确验证码");
                    return;
                }
                login();
                break;
            case R.id.tv_login_question:
                STActivity(LoginQuestionActivity.class);
                break;
        }
    }

    private void getMsgCode(String phone) {
        showLoading();
        Map<String,String> map=new HashMap<String,String>();
        map.put("mobile",phone);
        map.put("type","1");
        map.put("sign",getSign(map));
        NetApiRequest.getMsgCode(map, new MyCallBack<BaseObj>(mContext) {
            @Override
            public void onSuccess(BaseObj obj, int errorCode, String msg) {
                msgCode=obj.getSMSCode();
                countDown(tv_login_getcode);
            }
        });
    }
}
