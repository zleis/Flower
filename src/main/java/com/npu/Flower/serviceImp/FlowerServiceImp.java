/**
 * @author zlei
 * TODO
 * 2017年4月6日
 * 下午8:32:32
 */
package com.npu.Flower.serviceImp;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.npu.Flower.beans.Flower;
import com.npu.Flower.dao.FlowerDao;
import com.npu.Flower.global.Global;
import com.npu.Flower.service.FlowerService;

/**
 * @author ZLei
 *
 */
@Service("deviceService") 
public class FlowerServiceImp implements FlowerService{

	@Autowired
	private FlowerDao flowerDao;
	
	
	
	
	/**
	 * @param msg: 输入花盆信息
	 * @todo 添加花盆
	 */
	@Override
	public int insertFlower(JSONObject msg) {
		/* 判断信息是否合法*/
		int feedback = isInputFlowerNormal(msg);
		if(feedback != Global.REQUEST_SUCCESS ){
			return feedback;
		}
		
		/* 新建Flower对象，插入数据库 */
		Flower flower = getNewFlower(msg);
		if(flowerDao.getFlowerByID(flower.getFid()) != null ){
			return Global.FLOWER_FLOEWER_HAS_REGISTER;
		}
		flowerDao.insertFlower(flower);
		return feedback;
	}
	
	/**
	 * @todo 判断输入信息是否合法
	 * @param msg
	 * @return
	 */
	private int isInputFlowerNormal(JSONObject msg){
		if(msg.get("fid") == null ){
			return Global.FLOWER_FID_IS_NULL;
		}
		if(msg.get("fcode") != null){
			String fcode = (String)msg.get("fcode");
		}
		if(msg.get("name") != null){
			String name = (String)msg.get("name");
		}
		if(msg.get("des") != null){
			String des = (String)msg.get("des");
		}
		return Global.REQUEST_SUCCESS;
	}
	
	/**
	 * @todo 获取Flower对象
	 * @param msg
	 * @return
	 */
	private Flower getNewFlower(JSONObject msg){
		Flower flower = new Flower();
		/* fcode 必有 */
		flower.setFid((String)msg.get("fid"));
		
		if(msg.get("fcode") != null){
			flower.setFcode((String)msg.get("fcode"));
		}
		if(msg.get("name") != null){
			flower.setName((String)msg.get("name"));
		}
		if(msg.get("des") != null){
			flower.setDes((String)msg.get("des"));
		}
		return flower;
	}
	
	

	/**
	 * @todo 获取花盆传感器信息，插入数据库
	 * @return 返回插入数据信息的状态
	 */
	@Override
	public int insertFlowerData(JSONObject msg) {
		/* 判断输入是否合法 */
		int feedback = isInputFlowerDataNormal(msg);
		if(feedback != Global.REQUEST_SUCCESS){
			return feedback;
		}
		/* 将插入对象转换成为FlowerData对象 */
		
		return Global.REQUEST_SUCCESS;
	}
	
	
	/**
	 * 
	 * @param msg
	 * @return 花盘状态信息是否
	 */
	private int isInputFlowerDataNormal(JSONObject msg){
		
		
		return Global.REQUEST_SUCCESS;
	}
	
}
