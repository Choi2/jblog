package com.cafe24.jblog.category.vo;

public class CategoryVo {

	private int no;
	private String name;
	private int amount;
	private String content;
	private int blogNo;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getBlogNo() {
		return blogNo;
	}

	public void setBlogNo(int blogNo) {
		this.blogNo = blogNo;
	}

	@Override
	public String toString() {
		return "CategoryVo [no=" + no + ", name=" + name + ", amount=" + amount + ", content=" + content + ", blogNo="
				+ blogNo + "]";
	}



}
