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


    /**
     * WebView URL
     */

    //首页
    public static final String TAB_HOME = "http://192.168.1.122:8080/hlsong/weixin/index.jsp?phone=18511211125&token=ff824778-9658-4292-97af-e392f97e5b8d";
    //附近店铺
    public static final String TAB_CATEGORY = "http://192.168.1.122:8080/hlsong/weixin/index_busses.jsp?phone=18511211125&token=ff824778-9658-4292-97af-e392f97e5b8d";
    //邀请入贮
    public static final String TAB_ENTER = "http://192.168.1.122:8080/hlsong/weixin/invite.jsp?phone=18511211125&token=ff824778-9658-4292-97af-e392f97e5b8d";
    //个人中心
    public static final String TAB_MINE = "http://192.168.1.122:8080/hlsong/weixin/userinfo.jsp?phone=18511211125&token=ff824778-9658-4292-97af-e392f97e5b8d";
}
