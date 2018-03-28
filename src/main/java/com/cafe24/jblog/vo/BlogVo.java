package com.cafe24.jblog.vo;

public class BlogVo {
	
	private long no;
	private String title;
	private String imageName;
	private String imagePath;
	
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	@Override
	public String toString() {
		return "BlogVo [no=" + no + ", title=" + title + ", imageName=" + imageName + ", imagePath=" + imagePath + "]";
	}
}
