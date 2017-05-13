package com.npu.Flower.beans;

import java.util.Date;



/**
 * 
 * @author Administrator
 * @bean  花盆数据
 */
public class FlowerData {
	
	private String fid;
	private Date create_time;
	private float ph;		// PH
	private float light;	// 光照
	private float temp;		// 温度
	private float humidity; // 湿度
	/**
	 * @return the fid
	 */
	public String getFid() {
		return fid;
	}
	/**
	 * @param fid the fid to set
	 */
	public void setFid(String fid) {
		this.fid = fid;
	}
	/**
	 * @return the create_time
	 */
	public Date getCreate_time() {
		return create_time;
	}
	/**
	 * @param create_time the create_time to set
	 */
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	/**
	 * @return the ph
	 */
	public float getPh() {
		return ph;
	}
	/**
	 * @param ph the ph to set
	 */
	public void setPh(float ph) {
		this.ph = ph;
	}
	/**
	 * @return the light
	 */
	public float getLight() {
		return light;
	}
	/**
	 * @param light the light to set
	 */
	public void setLight(float light) {
		this.light = light;
	}
	/**
	 * @return the temp
	 */
	public float getTemp() {
		return temp;
	}
	/**
	 * @param temp the temp to set
	 */
	public void setTemp(float temp) {
		this.temp = temp;
	}
	
	/**
	 * @return the humidity
	 */
	public float getHumidity() {
		return humidity;
	}
	/**
	 * @param humidity the humidity to set
	 */
	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FlowerData [fid=" + fid + ", create_time=" + create_time
				+ ", ph=" + ph + ", light=" + light + ", temp=" + temp
				+ ", humidity=" + humidity + "]";
	}
	
	
	
}
