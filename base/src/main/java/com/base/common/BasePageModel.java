package com.base.common;

import java.util.List;

/**
 * 分页实体
 * @author lieeGin
 *
 */
public class BasePageModel<T>  {

	
	//当前页数据
	private List<T> rows;
	
	//当前页数
	private int pageNum = 1;
	
	//每页条数
	private int pageSize = 10; 
	
	//总条数
	private int total = 0;

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
}
