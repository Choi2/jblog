package com.cafe24.jblog.blog.dao.test;

import com.cafe24.jblog.blog.dao.BlogDao;
import com.cafe24.jblog.blog.vo.BlogVo;

public class BlogDaoTest {

	public static void main(String[] args) {
		insertTest();
		getList();
		
	}
	
	public static void insertTest() {
		BlogDao dao = new BlogDao();
		BlogVo vo = new BlogVo();
		vo.setTitle("최성진의 블로그에 오신걸 환영합니다^^");
		vo.setImageName("롤.jpg");
		vo.setImagePath("c:\\cafe24");
		vo.setUserNo(1);
		dao.insert(vo);
	}
	
	public static void getList() {
		BlogDao dao = new BlogDao();
		for(BlogVo blog : dao.getList()) {
			System.out.println(blog);
		}
	}

}
