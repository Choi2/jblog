package com.cafe24.jblog.vo;

import java.util.Date;

public class PostVo {
	
	private long no;
	private long categoryNo;
	private String title;
	private String content;
	private Date regDate;
	private long blogNo;
	
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public long getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(long categoryNo) {
		this.categoryNo = categoryNo;
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
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public long getBlogNo() {
		return blogNo;
	}
	public void setBlogNo(long blogNo) {
		this.blogNo = blogNo;
	}
	@Override
	public String toString() {
		return "PostVo [no=" + no + ", categoryNo=" + categoryNo + ", title=" + title + ", content=" + content
				+ ", regDate=" + regDate + ", blogNo=" + blogNo + "]";
	}
}
