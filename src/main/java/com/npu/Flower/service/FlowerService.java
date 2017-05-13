/**
 * @author zlei
 * TODO
 * 2017年4月6日
 * 下午8:31:23
 */
package com.npu.Flower.service;

import net.sf.json.JSONObject;

/**
 * @author ZLei
 *
 */
public interface FlowerService {
	
	/**
	 * @todo 插入花盘信息
	 */
	public int insertFlower(JSONObject msg);
	
	public int insertFlowerData(JSONObject msg);
}
