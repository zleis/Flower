/**
 * @author zlei
 * TODO
 * 2017年4月6日
 * 下午8:19:50
 */
package com.npu.Flower.beans;

/**
 * @author ZLei
 *
 */
public class Flower {
	private String fid;
	private String fcode;
	private String name;
	private String des;
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
	 * @return the fcode
	 */
	public String getFcode() {
		return fcode;
	}
	/**
	 * @param fcode the fcode to set
	 */
	public void setFcode(String fcode) {
		this.fcode = fcode;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the des
	 */
	public String getDes() {
		return des;
	}
	/**
	 * @param des the des to set
	 */
	public void setDes(String des) {
		this.des = des;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Flower [fid=" + fid + ", fcode=" + fcode + ", name=" + name
				+ ", des=" + des + "]";
	}
	
	
}
