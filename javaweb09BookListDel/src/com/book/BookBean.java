package com.book;

public class BookBean {
	
	public static final int PAGE_SIZE = 3;

	private int bid;
	
	private String bname;
	
	private String author;
	
	private Double price;

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public BookBean() {
		super();
	}

	public BookBean(int bid, String bname, String author, Double price) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.author = author;
		this.price = price;
	}

	@Override
	public String toString() {
		return "BookBean [bid=" + bid + ", bname=" + bname + ", author="
				+ author + ", price=" + price + "]";
	}

}
