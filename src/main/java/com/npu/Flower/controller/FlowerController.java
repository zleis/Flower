package com.npu.Flower.controller;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.npu.Flower.service.FlowerService;

@Controller
public class FlowerController extends BaseController{
	
	@Autowired
	private FlowerService flowerServer;
	
	private JSONObject resJson;
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @todo 花盆插入状态数据
	 * @return
	 */
	@RequestMapping(value = "/insertFlower", method = RequestMethod.GET)
	@ResponseBody
	public String insertFlowerData(HttpServletRequest request, HttpServletResponse response){
		response.addHeader("Access-Control-Allow-Origin","*");
		resJson = new JSONObject();
		JSONObject requestJson = this.getRequestJSONParam();
		int feedback = flowerServer.insertFlower(requestJson);
		resJson.put("feedback", feedback);
		return resJson.toString();
	}
}
