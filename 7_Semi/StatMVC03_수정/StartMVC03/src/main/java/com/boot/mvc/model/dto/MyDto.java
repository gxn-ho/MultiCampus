package com.boot.mvc.model.dto;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class MyDto {
	
	@Id
	@GeneratedValue
	private int no;
	
//	@ManyToOne
//	@JoinColumn(name="user_id")
//	private String user_id;
//	private int room_id;
	private String title;
	private String description;
	private String category;
	private int people_num;

	public MyDto() {
		super();
	}

	public MyDto(String title, String description, String category,
			int people_num) {
		super();
		//this.no = no;
		//this.user_id = user_id;
//		this.room_id = room_id;
		this.title = title;
		this.description = description;
		this.category = category;
		this.people_num = people_num;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

//	public String getUser_id() {
//		return user_id;
//	}
//
//	public void setUser_id(String user_id) {
//		this.user_id = user_id;
//	}

//	public int getRoom_id() {
//		return room_id;
//	}
//
//	public void setRoom_id(int room_id) {
//		this.room_id = room_id;
//	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getPeople_num() {
		return people_num;
	}

	public void setPeople_num(int people_num) {
		this.people_num = people_num;
	}

}
