package com.hibernate.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Member implements Serializable {
	
	public Member(){}
	private static final long serialVersionUID = 1L;
	private long memberId;
	private String memberName;
	private String status;
	private String level;
	private Set<PostDetail> PostDetail;
	private String memDate;
	private String comcode;
	private PostMaster pm;
	private PostDetail pd;


	public Member(String memberName){
		this.memberName = memberName;
		this.PostDetail = new HashSet<PostDetail>();
	}
	
	
	public String getComcode() {
		return comcode;
	}

	public void setComcode(String comcode) {
		this.comcode = comcode;
	}

	public String getMemDate() {
		return memDate;
	}

	public void setMemDate(String memDate) {
		this.memDate = memDate;
	}

	public PostMaster getPm() {
		return pm;
	}

	public void setPm(PostMaster pm) {
		this.pm = pm;
	}

	public PostDetail getPd() {
		return pd;
	}

	public void setPd(PostDetail pd) {
		this.pd = pd;
	}

	public long getMemberId() {
		return memberId;
	}
	public void setMemberId(long memberId) {
		this.memberId = memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public Set<PostDetail> getPostDetail() {
		return PostDetail;
	}

	public void setPostDetail(Set<PostDetail> postDetail) {
		PostDetail = postDetail;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	
	
	
}
