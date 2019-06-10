package com.hibernate.filter;

import java.io.Serializable;

public class FilterPostdetail implements Serializable{

	public FilterPostdetail (){}
	private static final long serialVersionUID = 1L;
	private int PostDetailId;
	private String SubContent;
	private String PicLocation;
	private int TelNum;
	private String Contact;
	private String Screen;
	//private String date;
	private String Time;
	private String Docno;
	private String userDate;
	
	
	public String getUserDate() {
		return userDate;
	}
	public void setUserDate(String userDate) {
		this.userDate = userDate;
	}
	public String getDocno() {
		return Docno;
	}
	public void setDocno(String docno) {
		Docno = docno;
	}
	public String getTime() {
		return Time;
	}
	public void setTime(String time) {
		Time = time;
	}
	public String getScreen() {
		return Screen;
	}
	public void setScreen(String screen) {
		Screen = screen;
	}
	public int getPostDetailId() {
		return PostDetailId;
	}
	public void setPostDetailId(int PostDetailId) {
		this.PostDetailId = PostDetailId;
	}
	public String getSubContent() {
		return SubContent;
	}
	public void setSubContent(String SubContent) {
		this.SubContent = SubContent;
	}
	public String getPicLocation() {
		return PicLocation;
	}
	public void setPicLocation(String picLocation) {
		PicLocation = picLocation;
	}
	public int getTelNum() {
		return TelNum;
	}
	public void setTelNum(int TelNum) {
		this.TelNum = TelNum;
	}
	public String getContact() {
		return Contact;
	}
	public void setContact(String contact) {
		Contact = contact;
	}
	
	
}