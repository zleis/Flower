package com.npu.Flower.serviceImp;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.npu.Flower.beans.User;
import com.npu.Flower.dao.FlowerDao;
import com.npu.Flower.global.Global;
import com.npu.Flower.service.UserService;

@Service("userService")
public class UserServiceImp implements UserService{

	@Autowired
	private FlowerDao userDao;
	
	/**
	 * @return the userDao
	 */
	public FlowerDao getUserDao() {
		return userDao;
	}

	/**
	 * @param userDao the userDao to set
	 */
	public void setUserDao(FlowerDao userDao) {
		this.userDao = userDao;
	}
	
	
	/**
	 * @param JSONObject msg 需要修改的用户信息
	 * @todo JSON 形式传入用户需要修改的数据
	 */
	@Override
	public int setMsg(JSONObject msg) {
		/* 修改信息是否规范 */
		int feedback = isInputNormal(msg);
		if( feedback != Global.REQUEST_SUCCESS ){
			return feedback;
		}
		
		User user = getNewUser(msg);
		userDao.updataUserInfo(user);
		return feedback;
	}
	
	
	
	/**
	 * 
	 * @param msg 用户信息
	 * @return 添加用户状态信息
	 * @todo 添加新用户
	 */
	@Override
	public int addNewUser(JSONObject msg) {
		int feedback = isInputNormal(msg);
		if(feedback != Global.REQUEST_SUCCESS){
			return feedback;
		}
		User user = getNewUser(msg);
		/* 判断用户是否注册过 */
		if( getUser(user.getWxid()) != null){
			return Global.USER_WXID_HAS_REGISTER;
		}
		
		userDao.insertUser(user);
		return feedback;
	}

	/**
	 * @todo 判断用户输入信息是否合法
	 * @param msg json : uid,wxid,pass,name,photo,sex,mail,phone,qq,birth,home_add
	 * @return
	 */
	private int isInputNormal(JSONObject msg){
		if(msg.get("wxid") == null){
			return Global.USER_WXID_IS_NULL;
		}
		if(msg.get("pass") != null){
			String pass = (String)msg.get("pass");
		}
		if(msg.get("name") != null){
			String name = (String)msg.get("name");
		}
		if(msg.get("sex") != null){
			String sex = (String)msg.get("sex");
		}
		if(msg.get("mail") != null){
			String mail = (String)msg.get("mail");
		}
		if(msg.get("qq") != null){
			String qq = (String)msg.get("qq");
		}
		if(msg.get("birth") != null){
			String birth = (String)msg.get("birth");
		}
		if(msg.get("home_add") != null){
			String home_add = (String)msg.get("home_add");
		}
		return Global.REQUEST_SUCCESS;
	}
	
	/**
	 * @todo 根据用户输入信息， 获取User对象
	 * @param msg json : uid, wxid, pass, name, photo, sex, mail, phone, qq, birth, home_add
	 * @return 
	 */
	private User getNewUser(JSONObject msg){
		User user = new User();
		if(msg.get("wxid") != null){
			user.setWxid((String)msg.get("wxid"));
		}
		if(msg.get("pass") != null){
			user.setPass((String)msg.get("pass"));
		}
		if(msg.get("name") != null){
			user.setName((String)msg.get("name"));
		}
		if(msg.get("sex") != null){
			user.setSex((String)msg.get("sex"));
		}
		if(msg.get("mail") != null){
			user.setMail((String)msg.get("mail"));
		}
		if(msg.get("phone") != null){
			user.setPhone((String)msg.get("phone"));
		}
		if(msg.get("qq") != null){
			user.setQq((String)msg.get("qq"));
		}
		if(msg.get("birth") != null){
			user.setBirth((String)msg.get("birth"));
		}
		if(msg.get("home_add") != null){
			user.setHome_add((String)msg.get("home_add"));
		}
		return user;
	}
	
	public User getUser(String wxid){
		User user = userDao.getUserByID(wxid);
		return user;
	}	
}
