package com.cafe24.jblog.comment.vo;

public class CommentVo {
	
	private int no;
	private int postNo;
	private String content;

	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getPostNo() {
		return postNo;
	}
	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}
	@Override
	public String toString() {
		return "CommentVo [no=" + no + ", content=" + content + ", postNo=" + postNo + "]";
	}
}
