package com.atmhls.global;

/**
 * 全局接口
 */

public class I {
    //服务器主域名
//    public static final String BASE_URL = "http://hlsong.viphk.ngrok.org/jeecg";
    //测试主域名
    public static final String BASE_URL = "http://192.168.1.122:8080/hlsong";

    //获取手机验证码
    public static final String URL_PHONE_CODE = BASE_URL + "/rest/phoneController/getPhoneCode";
    //注册
    public static final String URL_REGISTER = BASE_URL + "/rest/register";
    //登陆
    public static final String URL_LOGIN = BASE_URL + "/rest/login";
    //用户信息
    public static final String URL_USER_INFO = BASE_URL + "/rest/userController/user";
    //获取钱包信息
    public static final String URL_GET_MONEY_INFO = BASE_URL + "/rest/userController/wallet";
    //保存银行卡信息
    public static final String URL_SAVE_BANK_INFO = BASE_URL + "/rest/userController/wallet";
    //保存用户信息
    public static final String URL_SAVE_USER_INFO = BASE_URL + "/rest/userController/user";
    //会员消费记录
    public static final String URL_MEMBER_CONSUME_RECORD = BASE_URL + "/rest/userController/user";
    //会员邀请记录
    public static final String URL_MEMBER_INVITE_RECORD = BASE_URL + "/rest/inviteController/list";
    //获取邀请码
    public static final String URL_GET_INVITE_CODE = BASE_URL + "/rest/inviteController/getInviteCode";
    //会员消息类型显示
    public static final String URL_MEMBER_MSG_TYPE_SHOW = BASE_URL + "/rest/messageController/getNum";
    //会员消息类型列表
    public static final String URL_MEMBER_MSG_TYPE_LIST = BASE_URL + "/rest/messageController/list";
    //会员消息详细信息
    public static final String URL_MEMBER_MSG_DETAIL_INFO = BASE_URL + "/rest/messageController/detail";
    //会员充值列表
    public static final String URL_MEMBER_RECHARGE_LIST = BASE_URL + "/rest/rechargeController/list";
    //会员充值提交
    public static final String URL_MEMBER_RECHARGE_SUBMIT = BASE_URL + "/rest/rechargeController/save";
    //会员提现列表
    public static final String URL_MEMBER_CASH_LIST = BASE_URL + "/rest/withdrawController/list";
    //会员提现申请提交
    public static final String URL_MEMBER_CASH_SUBMIT = BASE_URL + "/rest/withdrawController/save";
    //首页信息展示
    public static final String URL_HOME_INFO_SHOW = BASE_URL + "/rest/honeController";
    //店铺列表展示
    public static final String URL_SHOP_LIST_SHOW = BASE_URL + "/rest/shopController/list";
    //店铺详细信息
    public static final String URL_SHOP_DETAIL_INFO = BASE_URL + "/rest/shopController/shop/{id}";


    /**
     * WebView BASE_URL
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
