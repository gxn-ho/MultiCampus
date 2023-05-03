package com.boot.jdbc.dto;

public class MemberDto {

	private String memberid;
	private String memberpw;

	public MemberDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MemberDto(String memberid, String memberpw) {
		super();

		this.memberid = memberid;
		this.memberpw = memberpw;

	}


	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	public String getMemberpw() {
		return memberpw;
	}
	public void setMemberpw(String memberpw) {
		this.memberpw = memberpw;
	}

	
	
}
