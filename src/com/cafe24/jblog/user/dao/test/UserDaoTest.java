package com.cafe24.jblog.user.dao.test;

import com.cafe24.jblog.user.dao.UserDao;
import com.cafe24.jblog.user.vo.UserVo;

public class UserDaoTest {

	public static void main(String[] args) {
		insertTest();
		getList();
		
	}
	
	public static void insertTest() {
		UserDao dao = new UserDao();
		UserVo vo = new UserVo();
		vo.setName("최성진");
		vo.setId("csj21300");
		vo.setPassword("123456");
		dao.insert(vo);
	}
	
	public static void getList() {
		UserDao dao = new UserDao();
		for(UserVo user : dao.getList()) {
			System.out.println(user);
		}
	}

}
