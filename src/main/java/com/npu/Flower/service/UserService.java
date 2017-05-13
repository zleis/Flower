package com.npu.Flower.service;

import com.npu.Flower.beans.User;
import com.npu.Flower.dao.FlowerDao;

import net.sf.json.JSONObject;

public interface UserService {
	/**
	 * @param JSONObject msg 需要修改的用户信息
	 * @todo JSON 形式传入用户需要修改的数据
	 */
	public int setMsg(JSONObject msg);
	
	/**
	 * 
	 * @param msg 用户信息
	 * @return 添加用户的状态信息
	 * @todo 添加新用户
	 */
	public int addNewUser(JSONObject msg);
	
	
	public User getUser(String wxid);
	public FlowerDao getUserDao();
}
