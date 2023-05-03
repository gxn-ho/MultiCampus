package com.boot.mvc.model.dto;

import javax.persistence.Id;

public class BoardMemberDto {

	private int no;
	private String user_id;
	private String user_nm;

	public BoardMemberDto() {
		super();
	}

	public BoardMemberDto(int no, String user_id, String user_nm) {
		super();
		this.no = no;
		this.user_id = user_id;
		this.user_nm = user_nm;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_nm() {
		return user_nm;
	}

	public void setUser_nm(String user_nm) {
		this.user_nm = user_nm;
	}

}
