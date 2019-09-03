package org.spring.img.domain;

public class Criteria {
    private int page;
    //page의 크기를 조절 한다.
    private int pageSize =10;
	private String keyword;
	private String sType;
	
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		if (page <= 0) {
			page = 1;
		}
		page = ( page - 1 ) * 10;
		
		this.page = page;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getsType() {
		return sType;
	}
	public void setsType(String sType) {
		this.sType = sType;
	}
	
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	@Override
	public String toString() {
		return "Criteria [page=" + page + ", pageSize=" + pageSize + ", keyword=" + keyword + ", sType=" + sType + "]";
	}
	
	
	
	
	
}
