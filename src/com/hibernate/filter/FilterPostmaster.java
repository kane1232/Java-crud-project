package com.hibernate.filter;

import java.io.Serializable;

public class FilterPostmaster implements Serializable{

	public FilterPostmaster (){}
	private static final long serialVersionUID = 1L;
	private long PostMasterId;
	private String topic;
	private String comcode;
	private String content;
	
	public long getPostMasterId() {
		return PostMasterId;
	}
	public void setPostMasterId(int PostMasterId) {
		this.PostMasterId = PostMasterId;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getComcode() {
		return comcode;
	}
	public void setComcode(String comcode) {
		this.comcode = comcode;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
