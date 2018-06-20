package com.sk.xyrs.module.my.network;

import com.github.retrofitutil.NoNetworkException;
import com.library.base.BaseApiRequest;
import com.sk.xyrs.Config;
import com.sk.xyrs.base.MyCallBack;
import com.sk.xyrs.module.home.network.*;

import java.util.Map;

/**
 * Created by Administrator on 2017/6/28.
 */

public class ApiRequest extends BaseApiRequest {
 
    public static void getHomeZiXun(Map map, MyCallBack callBack) {
        if (notNetWork(callBack.getContext())) { callBack.onFailure(null, new NoNetworkException(Config.noNetWork)); return;  }
        getGeneralClient(com.sk.xyrs.module.home.network.IRequest.class).getHomeZiXun(map).enqueue(callBack);
    }

}
