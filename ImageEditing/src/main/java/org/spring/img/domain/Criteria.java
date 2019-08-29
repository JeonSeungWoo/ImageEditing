package org.spring.img.domain;

public class Criteria {
    private int page;
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
	
	
	@Override
	public String toString() {
		return "Criteria [page=" + page + ", keyword=" + keyword + ", sType=" + sType + "]";
	}
	
	
	
	
}
