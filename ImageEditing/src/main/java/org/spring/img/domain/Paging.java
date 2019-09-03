package org.spring.img.domain;

public class Paging {
	private boolean prev;
	private boolean next;
	private int startPage;
	private int endPage;
	private int totalPage;
	private int page;
	
	
	public Paging(int page,int totalPage) {
		this.totalPage = totalPage;
		this.page = page;
		
		calcPage();
	}

	private void calcPage() {
		int tempEnd = (int)(Math.ceil(page/10.0)*10);
		
		startPage = tempEnd -9;
		
		
		
		prev = startPage == 1 ? false : true;
		
		if(tempEnd *10 >= totalPage){
			endPage = (int)(Math.ceil(totalPage/10.0));
			
			next = false;
			
		}else{
			endPage = tempEnd;
			next = true;
		}
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if(page<=0) {
			page = 1;
		}
		page = (page-1)*10;
		this.page = page;
	}

	@Override
	public String toString() {
		return "Paging [prev=" + prev + ", next=" + next + ", startPage=" + startPage + ", endPage=" + endPage
				+ ", totalPage=" + totalPage + ", page=" + page + "]";
	}

	
	
	
	
}
