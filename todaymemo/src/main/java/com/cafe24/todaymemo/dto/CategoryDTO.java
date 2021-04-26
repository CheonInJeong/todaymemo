package com.cafe24.todaymemo.dto;

public class CategoryDTO {
	private int menuIdx;
	private String menuName;
	private String menuUrl;
	private String menuSort;
	private String menuYn;
	private String menuRegId;
	private String menuRegDate;
	
	public int getMenuIdx() {
		return menuIdx;
	}
	public void setMenuIdx(int menuIdx) {
		this.menuIdx = menuIdx;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	public String getMenuSort() {
		return menuSort;
	}
	public void setMenuSort(String menuSort) {
		this.menuSort = menuSort;
	}
	public String getMenuYn() {
		return menuYn;
	}
	public void setMenuYn(String menuYn) {
		this.menuYn = menuYn;
	}
	public String getMenuRegId() {
		return menuRegId;
	}
	public void setMenuRegId(String menuRegId) {
		this.menuRegId = menuRegId;
	}
	public String getMenuRegDate() {
		return menuRegDate;
	}
	public void setMenuRegDate(String menuRegDate) {
		this.menuRegDate = menuRegDate;
	}
	@Override
	public String toString() {
		return "CategoryDTO [menuIdx=" + menuIdx + ", menuName=" + menuName + ", menuUrl=" + menuUrl + ", menuSort="
				+ menuSort + ", menuYn=" + menuYn + ", menuRegId=" + menuRegId + ", menuRegDate=" + menuRegDate + "]";
	}
	
	
}
