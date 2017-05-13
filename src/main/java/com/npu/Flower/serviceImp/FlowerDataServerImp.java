package com.npu.Flower.serviceImp;


import java.util.Date;
import java.util.List;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.npu.Flower.beans.FlowerData;
import com.npu.Flower.dao.FlowerDao;
import com.npu.Flower.global.Global;
import com.npu.Flower.service.FlowerDataServer;

@Service("flowerDataServer")
public class FlowerDataServerImp implements FlowerDataServer{
	@Autowired
	private FlowerDao flowerDao;
	
	/**
	 * @todo 存储来自于传感器的数据
	 * @param msg 以JSON形式传送数据
	 */
	@Override
	public int saveFlowerData(JSONObject msg) {
		/* 判断输入是否合法 */
		int feedback = isInputNormal(msg);
		if(feedback != Global.REQUEST_SUCCESS){
			return feedback;
		}
		
		/* 将合法数据存入数据库 */
		FlowerData flowerData = getFlowerData(msg);
		System.out.println(flowerData.toString());
		flowerDao.insertFlowerData(flowerData);
		return feedback;
	}
	
	
	
	/**
	 * @todo 通过输入时间确定
	 */
	@Override
	public JSONObject getFlowerDataList(JSONObject msg) {
		JSONObject resJson = new JSONObject();
		int feedback = isSearchInputNormal(msg);
		Date start, end;
		try{
			start = Global.sdf.parse(msg.getString("start"));
			end = Global.sdf.parse(msg.getString("end"));
			List<FlowerData> listData = flowerDao.getFlowerDataList
					(msg.getString("fid"), start, end, msg.getInt("limits"));
			resJson.put("FlowerDataList", listData);
		}catch(Exception e){
			System.out.println("getFlowerDataList error : " + e);
		}
		
		resJson.put("feedback", feedback);
		return resJson;
	}

	/**
	 * @todo 判断信息是否合法
	 * @param msg 输入的信息
	 * JSON格式： 
	 * fid, create_time, ph, light, temp, humidity
	 */
	private int isInputNormal(JSONObject msg){
		if(msg.get("fid") == null){
			return Global.FLOWER_FID_IS_NULL;
		}
		if(msg.get("ph") != null){
			
		}
		if(msg.get("light") != null){
			
		}
		if(msg.get("temp") != null){
			
		}
		if(msg.get("humidity") != null){
			
		}
		return Global.REQUEST_SUCCESS;
	}
	
	/**
	 * @todo 更具输入数据获取对象
	 * @param msg
	 * @return
	 */
	private FlowerData getFlowerData(JSONObject msg){
		java.util.Date date = new java.util.Date();
		FlowerData flowerData = new FlowerData();
		flowerData.setFid((String)msg.get("fid"));
		flowerData.setCreate_time(date);
		if(msg.get("ph") != null){
			flowerData.setPh(Float.parseFloat( (String)msg.get("ph")));
		}
		if(msg.get("light") != null){
			flowerData.setLight(Float.parseFloat((String)msg.get("light")));
		}
		if(msg.get("temp") != null){
			flowerData.setTemp(Float.parseFloat((String)msg.get("temp")));
		}
		if(msg.get("humidity") != null){
			flowerData.setHumidity(Float.parseFloat((String)msg.get("humidity")));
		}
		return flowerData;
	}
	
	private int isSearchInputNormal(JSONObject msg){
		
		
		return Global.REQUEST_SUCCESS;
	}
}
