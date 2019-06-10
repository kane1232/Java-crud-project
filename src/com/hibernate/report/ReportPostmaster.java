package com.hibernate.report;

//import java.text.DateFormat;


import com.hibernate.entities.PostMaster;

public class ReportPostmaster {

	public ReportPostmaster (){
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
	private String memDate;
	private String userDate;
	
	public ReportPostmaster (PostMaster pm){
		this.topic = pm.getTopic();
		//this.comcode = pm.getComcode();
		
	
	if(pm.getPd() != null){
		this.docNo = pm.getPd().getDocno();
		this.user = pm.getPd().getUser();
		this.memberName = pm.getMem().getMemberName();
		this.status = pm.getMem().getStatus();
		//this.level = pm.getMem().getLevel();
		this.memDate = pm.getMem().getMemDate();
		this.userDate = pm.getPd().getUserDate();
	}
	
	}
	
	public ReportPostmaster (PostMaster pm,Integer totalrow){
		this.topic = pm.getTopic();
		//this.comcode = pm.getComcode();
		
	
	if(pm.getPd() != null){
		this.docNo = pm.getPd().getDocno();
		this.user = pm.getPd().getUser();
		this.memberName = pm.getMem().getMemberName();
		this.status = pm.getMem().getStatus();
		//this.level = pm.getMem().getLevel();
		this.memDate = pm.getMem().getMemDate();
		this.userDate = pm.getPd().getUserDate();
	}
	
	
	
	}
	
	public String getMemDate() {
		return memDate;
	}

	public void setMemDate(String memDate) {
		this.memDate = memDate;
	}

	public String getUserDate() {
		return userDate;
	}

	public void setUserDate(String userDate) {
		this.userDate = userDate;
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
	
	
}

