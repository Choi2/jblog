package com.cafe24.jblog.vo;

import java.util.Date;

public class UserVo {
	private long no;
	private String id;
	private String name;
	private String password;
	private Date regDate;
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	@Override
	public String toString() {
		return "UserVo [no=" + no + ", id=" + id + ", name=" + name + ", password=" + password + ", regDate=" + regDate
				+ "]";
	}
	
}
