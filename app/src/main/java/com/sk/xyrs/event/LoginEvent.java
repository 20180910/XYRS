package com.sk.xyrs.event;

import com.sk.xyrs.module.my.network.response.LoginObj;

public class LoginEvent {
    public LoginObj obj;

    public LoginEvent(LoginObj obj) {
        this.obj = obj;
    }
}
