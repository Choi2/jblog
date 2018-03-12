package com.cafe24.jblog.post.vo;

public class PostVo {

	private int no;
	private int blogNo;
	private int categoryNo;
	private String title;
	private String content;
	private String date;

	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getBlogNo() {
		return blogNo;
	}

	public void setBlogNo(int blogNo) {
		this.blogNo = blogNo;
	}

	public String getTitle() {
		return title;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}

	@Override
	public String toString() {
		return "PostVo [no=" + no + ", blogNo=" + blogNo + ", categoryNo=" + categoryNo + ", title=" + title
				+ ", content=" + content + ", date=" + date + "]";
	}


}
