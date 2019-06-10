package com.hibernate.report;

import com.hibernate.entities.Member;

public class ReportMember {

	public ReportMember (){
		super();
	}
	private String topic;
	//private String comcode;
	//private String content;
	private String memberName;
	private String docNo;
	//private DateFormat date = new DateFormat();
	private String user;
	private String status;
	//private String level;
	private String userDate;
	private String memDate;
	
	public ReportMember(Member mem){
		this.memberName = mem.getMemberName();
		this.status = mem.getStatus();
		//this.level = mem.getLevel();
		this.memDate = mem.getMemDate();
		
		if(mem.getPm() != null){
			this.topic = mem.getPm().getTopic();
			//this.comcode = mem.getPm().getComcode();
			
		}
		if(mem.getPd() != null){
			this.docNo = mem.getPd().getDocno();
			this.user = mem.getPd().getUser();
			this.userDate = mem.getPd().getUserDate();
		}
	
	}
	public ReportMember(Member mem,Integer totalrow){
		this.memberName = mem.getMemberName();
		this.status = mem.getStatus();
		//this.level = mem.getLevel();
		this.memDate = mem.getMemDate();
		
		if(mem.getPm() != null){
			this.topic = mem.getPm().getTopic();
			//this.comcode = mem.getPm().getComcode();
			
		}
		if(mem.getPd() != null){
			this.docNo = mem.getPd().getDocno();
			this.user = mem.getPd().getUser();
			this.userDate = mem.getPd().getUserDate();
		}
	}
	
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getDocNo() {
		return docNo;
	}
	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getUserDate() {
		return userDate;
	}
	public void setUserDate(String userDate) {
		this.userDate = userDate;
	}
	public String getMemDate() {
		return memDate;
	}
	public void setMemDate(String memDate) {
		this.memDate = memDate;
	}
	
	
}
