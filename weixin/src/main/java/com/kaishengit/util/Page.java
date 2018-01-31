package com.kaishengit.util;

import java.util.List;

public class Page<T> {

	// ��ҳ��
	private int pageTotal;
	// ��ǰҳ��
	private int pageNo;
	// ��ǰҳ������
	private List<T> items;

	// ÿҳ������
	private int pageSize = 5;
	// ��ʼ����
	private int start;
	// ������
	private int total;

	public Page(int pageNo, int total) {

		this.total = total;

		// ������ҳ��
		pageTotal = total / pageSize;
		if (total % pageSize != 0) {
			pageTotal++;
		}
		
		if(pageNo < 1) {
			pageNo = 1;
		}
		
		if(pageNo > pageTotal) {
			pageNo = pageTotal;
		}
		
		this.pageNo = pageNo;
		
		// start ��ʼ�кż���
		start = (pageNo - 1) * pageSize;

	}

	public int getPageTotal() {
		return pageTotal;
	}

	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public List<T> getItems() {
		return items;
	}

	public void setItems(List<T> items) {
		this.items = items;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

}
