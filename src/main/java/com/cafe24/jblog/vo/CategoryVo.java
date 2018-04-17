package com.cafe24.jblog.vo;

public class CategoryVo {
	private long no;
	private String name;
	private int postCount;
	private String content;
	private long blogNo;
	private long rowNum;
	
	public long getRowNum() {
		return rowNum;
	}
	public void setRowNum(long rowNum) {
		this.rowNum = rowNum;
	}
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPostCount() {
		return postCount;
	}
	public long getBlogNo() {
		return blogNo;
	}
	public void setBlogNo(long blogNo) {
		this.blogNo = blogNo;
	}
	public void setPostCount(int postCount) {
		this.postCount = postCount;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "CategoryVo [no=" + no + ", name=" + name + ", postCount=" + postCount + ", content=" + content
				+ ", blogNo=" + blogNo + "]";
	}
}
