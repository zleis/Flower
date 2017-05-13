package com.npu.Flower.service;

import java.util.List;

import net.sf.json.JSONObject;

import com.npu.Flower.beans.FlowerData;

public interface FlowerDataServer {
	
	/* 存储收集到的数据 */
	public int saveFlowerData(JSONObject msg);
	
	public JSONObject getFlowerDataList(JSONObject msg);
}
