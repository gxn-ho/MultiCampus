package com.boot.mvc.model.dto;

import java.util.Date;

public class BoardDto {
	
	private int qna_no;
	private String user_id;
	private String qna_title;
	private String qna_content;
	private int qna_view;
	private Date qna_date;
	private String filename;
	private String filepath;
	
	public BoardDto() {
		super();
	}
	
	public BoardDto(int qna_no, String user_id, String qna_title, String qna_content, int qna_view, Date qna_date,
			String filename, String filepath) {
		super();
		this.qna_no = qna_no;
		this.user_id = user_id;
		this.qna_title = qna_title;
		this.qna_content = qna_content;
		this.qna_view = qna_view;
		this.qna_date = qna_date;
		this.filename = filename;
		this.filepath = filepath;
	}
	
	public int getQna_no() {
		return qna_no;
	}
	
	public void setQna_no(int qna_no) {
		this.qna_no = qna_no;
	}
	
	public String getUser_id() {
		return user_id;
	}
	
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	public String getQna_title() {
		return qna_title;
	}
	
	public void setQna_title(String qna_title) {
		this.qna_title = qna_title;
	}
	
	public String getQna_content() {
		return qna_content;
	}
	
	public void setQna_content(String qna_content) {
		this.qna_content = qna_content;
	}
	
	public int getQna_view() {
		return qna_view;
	}
	
	public void setQna_view(int qna_view) {
		this.qna_view = qna_view;
	}
	
	public Date getQna_date() {
		return qna_date;
	}
	
	public void setQna_date(Date qna_date) {
		this.qna_date = qna_date;
	}
	
	public String getFilename() {
		return filename;
	}
	
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	public String getFilepath() {
		return filepath;
	}
	
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}	
}