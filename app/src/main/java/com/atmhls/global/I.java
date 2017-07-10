package com.atmhls.global;

/**
 * 全局接口
 */

public class I {
    //服务器主域名
    public static final String URL = "http://hlsong.viphk.ngrok.org/jeecg";

    //获取手机验证码
    public static final String URL_PHONE_CODE = URL + "/rest/phoneController/getPhoneCode";
    //注册
    public static final String URL_REGISTER = URL + "/rest/register";
    //登陆
    public static final String URL_LOGIN = URL + "/rest/login";
}
