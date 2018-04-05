package com.yhc.pagehelper;

import java.util.List;

public class Page {

	private int pageSize = 2;
	private int pageNum = 1;
	private int totalPage = 1;
	private int totalSize;
	
	private List<?> itemList;

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getTotalPage() {
		if (this.totalSize % this.pageSize != 0) {
			this.totalPage = (int) (this.totalSize / this.pageSize + 1);
		} else {
			this.totalPage = (int) (this.totalSize / this.pageSize);
		}
		if (totalPage == 0){
			this.totalPage = 1;
		}	
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		
		this.totalPage = totalPage;
	}

	public int getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(int totalSize) {
			
		this.totalSize = totalSize;
	}

	public List<?> getItemList() {
		return itemList;
	}

	public void setItemList(List<?> itemList) {
		this.itemList = itemList;
	}
	
	
}
