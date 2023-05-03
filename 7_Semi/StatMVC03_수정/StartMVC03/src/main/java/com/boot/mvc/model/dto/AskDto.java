package com.boot.mvc.model.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class AskDto {

	@Id
	@GeneratedValue
	private int no;
	private int room_no;
	private String user_id;
	private String content;
	private String reply;

	public AskDto() {
		super();
	}

	public AskDto(int no, int room_no, String user_id, String content, String reply) {
		super();
		this.no = no;
		this.room_no = room_no;
		this.user_id = user_id;
		this.content = content;
		this.reply = reply;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getRoom_no() {
		return room_no;
	}

	public void setRoom_no(int room_no) {
		this.room_no = room_no;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

}
