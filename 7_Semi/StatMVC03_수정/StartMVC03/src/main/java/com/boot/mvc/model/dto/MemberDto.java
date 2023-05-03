package com.boot.mvc.model.dto;

public class MemberDto {

	private String user_id;
	private String user_nm;
	private String password;
	private String addr;
	private String email;
	private String telno;
	private String del_yn;

	public MemberDto(String user_id, String user_nm, String password, String addr, String email, String telno,
			String del_yn) {
		super();
		this.user_id = user_id;
		this.user_nm = user_nm;
		this.password = password;
		this.addr = addr;
		this.email = email;
		this.telno = telno;
		this.del_yn = del_yn;
	}

	public MemberDto() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelno() {
		return telno;
	}

	public void setTelno(String telno) {
		this.telno = telno;
	}

	public String getDel_yn() {
		return del_yn;
	}

	public void setDel_yn(String del_yn) {
		this.del_yn = del_yn;
	}

}
