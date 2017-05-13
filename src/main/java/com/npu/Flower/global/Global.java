package com.npu.Flower.global;

import java.text.SimpleDateFormat;

public class Global {
	
	public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
	
	/* 请求错误信息 */
	public static final int REQUEST_SUCCESS = 10000; // 请求成功
	
	public static final int USER_WXID_IS_NULL = 10001; // uid为空
	public static final int USER_NAME_TOO_LONG = 10002; // 名称过长
	public static final int USER_NAME_IS_ILLEGAL = 10003; // 名称不合法
	public static final int USER_PIC_TOO_BIG = 100004; // 头像过大 
	public static final int USER_MAIL_IS_ILLEGAL = 10005; // 邮箱不合法
	public static final int USER_PHONE_IS_ILLEGAL = 10006; // 手机号不合法
	public static final int USER_QQ_IS_ILLEGAL = 10007; // QQ不合法
	public static final int USER_BIRTH_IS_ILLEGAL = 10008; // 生日不合法
	public static final int USER_WXID_HAS_REGISTER = 10009; // 账号已经注册
	
	public static final int FLOWER_FID_IS_NULL = 10030; // FID 为空
	public static final int FLOWER_FLOEWER_HAS_REGISTER = 100031; // 已经注册
	
}
