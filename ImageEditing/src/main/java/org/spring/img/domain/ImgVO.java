package org.spring.img.domain;

public class ImgVO {

	private int ino;
	private int bno;
	private String location = "";
	private String fileName = "";
	
	
	public int getIno() {
		return ino;
	}
	public void setIno(int ino) {
		this.ino = ino;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public ImgVO() {
		super();
		this.ino = ino;
		this.bno = bno;
		this.location = location;
		this.fileName = fileName;
	}
	@Override
	public String toString() {
		return "ImgVO [ino=" + ino + ", bno=" + bno + ", location=" + location + ", fileName=" + fileName + "]";
	}
	
	
	
	
	
}
