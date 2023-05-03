package com.boot.mvc.model.dto;


public class MainDto {
	private int no;
	private String title;
	private String category;
	private int people_num;
	private int favorites;
	public MainDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MainDto(int no, String title, String category, int people_num, int favorites) {
		super();
		this.no = no;
		this.title = title;
		this.category = category;
		this.people_num = people_num;
		this.favorites = favorites;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public int getFavorites() {
		return favorites;
	}
	public void setFavorites(int favorites) {
		this.favorites = favorites;
	}
	
	
}
