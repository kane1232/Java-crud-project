package com.hibernate.report;

import com.hibernate.entities.PostDetail;

public class ReportPostdetail {

	public ReportPostdetail () {
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
	
	public ReportPostdetail(PostDetail pd){
		this.docNo = pd.getDocno();
		this.user = pd.getUser();
		this.userDate = pd.getUserDate();
		
		if(pd.getPm() != null){
			this.topic = pd.getPm().getTopic();
			//this.comcode = pd.getPm().getComcode();
			//this.content = pd.getPm().getContent();
			this.memberName = pd.getMem().getMemberName();
			this.status = pd.getMem().getStatus();
			//this.level = pd.getMem().getLevel();
			this.memDate = pd.getMem().getMemDate();
		}
	}
	

	public ReportPostdetail(PostDetail pd,Integer totalrow){
		this.docNo = pd.getDocno();
		this.user = pd.getUser();
		this.user = pd.getUser();
		
		if(pd.getPm() != null){
			this.topic = pd.getPm().getTopic();
			//this.comcode = pd.getPm().getComcode();
			//this.content = pd.getPm().getContent();
			this.memberName = pd.getMem().getMemberName();
			this.status = pd.getMem().getStatus();
			//this.level = pd.getMem().getLevel();
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
