package com.npu.Flower.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.npu.Flower.service.FlowerDataServer;

@Controller("FlowerData")
public class FlowerDataController extends BaseController {
	@Autowired
	private FlowerDataServer flowerDataServer;
	
	
	/**
	 * @todo 传感器上传数据查询
	 * @return
	 */
	@RequestMapping(value = "/saveFlowerData", method = RequestMethod.POST)
	@ResponseBody
	public String saveFlowerData(HttpServletRequest request, HttpServletResponse response){
		response.addHeader("Access-Control-Allow-Origin","*");
		
		JSONObject resJson = new JSONObject();
		JSONObject msg = this.getRequestJSONParam();
		int feedback = flowerDataServer.saveFlowerData(msg);
		resJson.put("feedback", feedback);
		return resJson.toString();
		
	}
	
	@RequestMapping(value = "/getFlowerData", method = RequestMethod.POST)
	@ResponseBody
	public String getFlowerData(HttpServletRequest request, HttpServletResponse response){
		// 设置AJAX的跨域访问
		response.addHeader("Access-Control-Allow-Origin","*");
		JSONObject resJson = new JSONObject();
		JSONObject msg = this.getRequestJSONParam();
		resJson = flowerDataServer.getFlowerDataList(msg);
		return resJson.toString();
	}
	
}
