package com.hibernate.entities;

import java.io.Serializable;

public class PostDetail implements Serializable {

	public PostDetail(){}
	private static final long serialVersionUID = 1L;
	private int PostDetailId;
	private String SubContent;
	private String PicLocation;
	private int TelNum;
	private String Contact;
	private String Screen;
	//private String Date;
	private String Docno;
	private String user;
	private String userDate;
	private Member mem;
	private PostMaster pm;
	
	
	
	public String getUserDate() {
		return userDate;
	}
	public void setUserDate(String userDate) {
		this.userDate = userDate;
	}
	public PostMaster getPm() {
		return pm;
	}
	public void setPm(PostMaster pm) {
		this.pm = pm;
	}
	public Member getMem() {
		return mem;
	}
	public void setMem(Member mem) {
		this.mem = mem;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getDocno() {
		return Docno;
	}
	public void setDocno(String docno) {
		Docno = docno;
	}
	
	public String getScreen() {
		return Screen;
	}
	public void setScreen(String Screen) {
		this.Screen = Screen;
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
