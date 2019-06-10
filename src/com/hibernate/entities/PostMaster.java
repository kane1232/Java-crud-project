package com.hibernate.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


public class PostMaster implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private long PostMasterId;
	private String topic;
	private String comcode;
	private String content;
	private Set<PostDetail> PostDetail;
	private PostDetail pd;
	private Member mem;
	
	public PostMaster (){
		
	}
	
	public PostMaster (String topic,String comcode,String content ){
		this.topic = topic;
		this.comcode = comcode;
		this.content = content;
		this.PostDetail = new HashSet<PostDetail>();
	}
	
	
	
	public Member getMem() {
		return mem;
	}

	public void setMem(Member mem) {
		this.mem = mem;
	}

	public void setPostMasterId(long postMasterId) {
		PostMasterId = postMasterId;
	}

	public PostDetail getPd() {
		return pd;
	}

	public void setPd(PostDetail pd) {
		this.pd = pd;
	}

	public Set<PostDetail> getPostDetail() {
		return PostDetail;
	}
	public void setPostDetail(Set<PostDetail> postDetail) {
		PostDetail = postDetail;
	}
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
