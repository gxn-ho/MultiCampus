package com.inherit.part02_override;

public class Book {
	private String title;
	private String writer;
	private int price;
	
	public Book() {}

	public Book(String title, String writer, int price) {
		super();
		this.title = title;
		this.writer = writer;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWritter() {
		return writer;
	}

	public void setWritter(String writer) {
		this.writer = writer;
	}
	
	@Override
	public String toString() {
		return title+", "+writer+", "+price;
	}
	

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public boolean equals(Object obj) {
		//객체의 주소가 같으면 같은 객체.
		if(this == obj) {
			return true;
		}
		//전달 받은 객체가 null인 경우 무조건 다른 객체.
		if(obj == null) {
			return false;
		}
		
		// -----------------------------------//
		// 전달 받은 객체의 필드값과 비교하여 같은지 판단.
		
		Book other = (Book)obj;
		
		if(title == null) {
			if(other.title != null) {
				return false;
			}
		}else if ( !title.equals(other.title)) {
			return false;
		}
		
		if(writer == null) {
			if(other.writer != null) {
				return false;
			}
		}else if(!writer.equals(other.writer)) {
			return false;
		}
		
		if(price != other.price) {
			return false;
		}
		
		
		
		return true;
	}
	
	@Override
	public int hashCode() {
		return (title+writer+price).hashCode();
		
	}
	
	
	
	
}
