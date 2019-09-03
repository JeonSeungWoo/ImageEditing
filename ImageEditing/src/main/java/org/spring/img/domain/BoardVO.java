package org.spring.img.domain;

public class BoardVO {
	private int bno; 
	private String title;
	private String content;
	private String userid;
	/* private String insert_date; */
	
	
	public String getTitle() {
		return title;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	@Override
	public String toString() {
		return "BoardVO [bno=" + bno + ", title=" + title + ", content=" + content + ", userid=" + userid + "]";
	}

	
	
	
	
}
