package com.cafe24.jblog.blog.vo;

public class BlogVo {
	private int no;
	private int userNo;
	private String title;
	private String imageName;
	private String imagePath;


	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
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

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "BlogVo [no=" + no + ", imageName=" + imageName + ", imagePath=" + imagePath + ", userNo=" + userNo
				+ "]";
	}
}
