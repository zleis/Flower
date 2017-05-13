package com.npu.Flower.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.npu.Flower.beans.Flower;
import com.npu.Flower.beans.FlowerData;
import com.npu.Flower.beans.User;

public interface FlowerDao {
	/* User 数据库操作 */
	/**
	 * @todo 获取用户
	 */
	User getUserByID(String wxid);
	
	/**
	 * @todo 更新用户信息
	 */
	int updataUserInfo(User user);
	
	/**
	 * @todo 插入新用户
	 */
	int insertUser(User user);
	
	/* Flower 数据库*/
	/**
	 * @TODO 获取花盘信息
	 */
	Flower getFlowerByID(String fid);
	
	/**
	 * @todo 插入花盘信息
	 */
	int insertFlower(Flower flower);
	
	/* FlowerData 数据 */
	/**
	 * @todo 插入数据
	 */
	int insertFlowerData(FlowerData flowerData);
	
	/**
	 * @todo 获取数据
	 */
	List<FlowerData> getFlowerDataList(@Param("fid")String fid, @Param("start")Date start, @Param("end")Date endData, @Param("limits")int limit);
}
