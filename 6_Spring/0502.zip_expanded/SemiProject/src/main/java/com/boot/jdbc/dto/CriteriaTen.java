package com.boot.jdbc.dto;

public class CriteriaTen {
	private int pageNum;
	   private int amount;
	   
	   private String type;
	   private String keyword;
	   
	   public CriteriaTen() {
	      this(1,10);
	   }

	   public CriteriaTen(int pageNum, int amount) {
	      this.pageNum = pageNum;
	      this.amount = amount;
	   }

	   public String[] getTypeArr() {
	      
	      return type == null? new String[] {}: type.split("");
	   }

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
}
