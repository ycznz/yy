package com.pro.util;

import java.util.List;

public class PageModel<T> {

	private int currentPage;
	
	private int pageSize;
	
	private int totalRecord;
	
	private List<T> list;

	/**
	 * 总页数
	 * @return
	 */
	public int getTotalPage(){
		return (this.getTotalRecord()+this.getPageSize()-1)/this.getPageSize();
	}
	
	/**
	 * 首页
	 * @return
	 */
	public int getPageFirst(){
		return 1;
	}
	/**
	 * 上一页
	 * @return
	 */
	public int getPageUp(){
		if(this.getCurrentPage()<=1){
			return 1;
		}
		return this.getCurrentPage()-1;
	}
	/**
	 * 下一页
	 * @return
	 */
	public int getPageDown(){
		if(this.getCurrentPage()>=this.getTotalPage()){
			return this.getTotalPage();
		}
		return this.getCurrentPage()+1;
	}
	/**
	 * 尾页
	 * @return
	 */
	public int getPageEnd(){
		return this.getTotalPage();
	}
	
	
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
	
	
}
