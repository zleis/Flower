package com.npu.Flower.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

import javax.json.JsonObject;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 
 * @author zhu
 */
@Controller
public class BaseController {
	
	/**
	 * 返回数据客户端数据
	 */
	private JSONObject resJson = new JSONObject();
	/**
	 * 得到request对象
	 */
	public HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();

		return request;
	}

	public String getData() {
		InputStream is = null;
		StringBuffer sb = null;
		HttpServletRequest request = getRequest();
		try {
			is = request.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is,
					"UTF-8"));
			// 读取HTTP请求内容
			String buffer = null;
			sb = new StringBuffer();
			while ((buffer = br.readLine()) != null) {
				sb.append(buffer);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		if (sb != null)
			return sb.toString();
		else
			return null;
	}

	public String getData(String coding) {
		InputStream is = null;
		StringBuffer sb = null;
		HttpServletRequest request = getRequest();
		try {
			is = request.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is,
					coding));
			// 读取HTTP请求内容
			String buffer = null;
			sb = new StringBuffer();
			while ((buffer = br.readLine()) != null) {
				sb.append(buffer);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		if (sb != null)
			return sb.toString();
		else
			return null;
	}
	
	/**
	 * @todo 获取MAP<String, String[]> 形式的Get传参
	 * @return
	 */
	public Map<String, String[]> getRequestMapParam(){
		HttpServletRequest request = getRequest();
		return request.getParameterMap();
	}
	
	/**
	 * @todo 获取JSON格式的Get传参
	 * @return Get传参的JSON格式
	 */
	public JSONObject getRequestJSONParam(){
		JSONObject resJson = new JSONObject();
		HttpServletRequest request = getRequest();
		Map<String, String[]> mapParam = request.getParameterMap();
		for (String key : mapParam.keySet()) {
			String[] value = mapParam.get(key);
			resJson.put(key, value[0]);
		}
		return resJson;
	}
	
	/**
	 * 
	 * @param map
	 * @return
	 */
	public String mapToString(Map<String, String[]> map){
		StringBuffer mapString = new StringBuffer();
		for (String key : map.keySet()) {
			String[] value = map.get(key);
			mapString.append(key);
			mapString.append(":[");
			for(int i = 0; i < value.length; i++ ){
				if( i != 0 ){ mapString.append(','); }
				mapString.append(value[i]);
			}
			mapString.append("],");
		}
		return mapString.toString();
	}
	
	
}
