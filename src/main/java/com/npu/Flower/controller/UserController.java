/**
 * @author zlei
 * TODO
 * 2017年4月7日
 * 上午11:20:27
 */
package com.npu.Flower.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.npu.Flower.beans.User;
import com.npu.Flower.dao.FlowerDao;
import com.npu.Flower.global.Global;
import com.npu.Flower.service.UserService;

/**
 * @author ZLei
 *
 */

@Controller
public class UserController extends BaseController{
	
	@Autowired
	private UserService userService;
	private JSONObject resJson;
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@ResponseBody
	public String test(HttpServletRequest request, HttpServletResponse response){
		FlowerDao userDao = userService.getUserDao();
		User user = userDao.getUserByID("hello");
		return user.toString();
	}
	
	/**
	 * @param request
	 * @param response
	 * @todo 修改用户信息，通过Get传参数，来实现对用户信息修改
	 * @return
	 */
	@RequestMapping(value = "/setUserInfo", method = RequestMethod.GET)
	@ResponseBody
	public String setMsg(HttpServletRequest request, HttpServletResponse response){
		response.addHeader("Access-Control-Allow-Origin","*");
		resJson = new JSONObject();
		JSONObject setJson = this.getRequestJSONParam();
		int feedback = userService.setMsg(setJson);
		resJson.put("feedback", feedback);
		return resJson.toString();
	}
	
	/**
	 * @param request
	 * @param response
	 * @todo 添加用户信息
	 * @return
	 */
	@RequestMapping(value = "/addNewUser", method = RequestMethod.GET)
	@ResponseBody
	public String addNewUser(HttpServletRequest request, HttpServletResponse response){
		response.addHeader("Access-Control-Allow-Origin","*");
		resJson = new JSONObject();
		JSONObject userJson = this.getRequestJSONParam();
		int feedback = userService.addNewUser(userJson);
		resJson.put("feedback", feedback);
		return resJson.toString();
	}
	
}
