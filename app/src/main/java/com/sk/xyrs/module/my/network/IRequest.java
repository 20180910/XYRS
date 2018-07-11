package com.sk.xyrs.module.my.network;

import com.library.base.BaseObj;
import com.library.base.ResponseObj;
import com.sk.xyrs.module.my.network.response.LoginObj;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by Administrator on 2017/6/28.
 */

public interface IRequest {
    //短信登录
    @GET("api/User/GetUserRegisterforMobileCode")
    Call<ResponseObj<LoginObj>> loginForMsg(@QueryMap Map<String, String> map);
    //获取用户资料
    @GET("api/User/GetUserInfo")
    Call<ResponseObj<LoginObj>> getUserInfo(@QueryMap Map<String, String> map);

    //协议-类别(1用户协议 2创作等级规则 3阅读等级规则 4充值协议 5投稿协议)
    @GET("api/Lib/GetUserAgreement")
    Call<ResponseObj<BaseObj>> getXieYi(@QueryMap Map<String, String> map);

    //获取登录遇到的问题
    @GET("api/Lib/GetLoginProblems")
    Call<ResponseObj<BaseObj>> getLoginProblems(@QueryMap Map<String, String> map);

}
