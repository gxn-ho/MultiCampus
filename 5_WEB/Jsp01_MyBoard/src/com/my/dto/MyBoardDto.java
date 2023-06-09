package com.my.dto;

import java.util.Date;

public class MyBoardDto {
	
	//필드
	private int myno;
	private String myname;
	private String mytitle;
	private String mycontent;
	private Date mydate;
	
	
	//생성자(기본, 매개변수)
	public MyBoardDto() {
		super();
	}
	
	
	public MyBoardDto(int myno, String myname, String mytitle, String mycontent, Date mydate) {
		super();
		this.myno = myno;
		this.myname = myname;
		this.mytitle = mytitle;
		this.mycontent = mycontent;
		this.mydate = mydate;
	}
	
	//insert
	public MyBoardDto(String myname, String mytitle, String mycontent) {
		super();
		this.myname = myname;
		this.mytitle = mytitle;
		this.mycontent = mycontent;
	}


	//getter&setter
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
	public String getMytitle() {
		return mytitle;
	}
	public void setMytitle(String mytitle) {
		this.mytitle = mytitle;
	}
	public String getMycontent() {
		return mycontent;
	}
	public void setMycontent(String mycontent) {
		this.mycontent = mycontent;
	}
	public Date getMydate() {
		return mydate;
	}
	public void setMydate(Date mydate) {
		this.mydate = mydate;
	}
	
}
