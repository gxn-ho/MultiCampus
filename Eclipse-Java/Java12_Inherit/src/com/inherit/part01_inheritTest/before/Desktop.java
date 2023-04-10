package com.inherit.part01_inheritTest.before;

import java.util.Date;

public class Desktop {
	private String brand;
	private String productNumber;
	private String productCode;
	private String cpu;
	private int hdd;
	private int ram;
	private String os;
	private int price;
	private Date date;
	private boolean allInOne;
	
	//생성자(기본생성자, 매개변수생성자)
	public Desktop() {}
	public Desktop(String brand, String productNumber, String productCode, String cpu, int hdd, int ram, String os, int price, Date date, boolean allInOne) {
		this.brand = brand;
		this.productNumber = productNumber;
		this.productCode = productCode;
		this.cpu = cpu;
		this.hdd = hdd;
		this.ram = ram;
		this.os = os;
		this.price = price;
		this.date = date;
		this.allInOne = allInOne;
	}
	//getter&setter
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getProductNumber() {
		return productNumber;
	}
	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getCpu() {
		return cpu;
	}
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
	public int getHdd() {
		return hdd;
	}
	public void setHdd(int hdd) {
		this.hdd = hdd;
	}
	public int getRam() {
		return ram;
	}
	public void setRam(int ram) {
		this.ram = ram;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public boolean getAllInOne() {
		return allInOne;
	}
	public void setAllInOne(boolean allInOne) {
		this.allInOne = allInOne;
	}
	//information
	public String information() {
		return brand+", "+productNumber+", "+productCode+", "+cpu+", "+hdd+", "+ram+", "+os+", "+price+", "+date+", "+allInOne;
	}
	
}
