package com.mvc.upgrade.model.dto;

import 

public class BoardDto {
	private int myno;
	private String myname;
	private String myage;
	private String myaddr;
	public BoardDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BoardDto(int myno, String myname, String myage, String myaddr) {
		super();
		this.myno = myno;
		this.myname = myname;
		this.myage = myage;
		this.myaddr = myaddr;
	}
	public int getMyno() {
		return myno;
	}
	public void setMyno(int myno) {
		this.myno = myno;
	}
	public String getMyname() {
		return myname;
	}
	public void setMyname(String myname) {
		this.myname = myname;
	}
	public String getMyage() {
		return myage;
	}
	public void setMyage(String myage) {
		this.myage = myage;
	}
	public String getMyaddr() {
		return myaddr;
	}
	public void setMyaddr(String myaddr) {
		this.myaddr = myaddr;
	}
	
	
	
	
	
	
	
}
