package com.cafe24.jblog.category.dao.test;

import com.cafe24.jblog.category.dao.CategoryDao;
import com.cafe24.jblog.category.vo.CategoryVo;

public class CategoryDaoTest {

	public static void main(String[] args) {
		insertTest();
		getList();
		
	}
	
	public static void insertTest() {
		CategoryDao dao = new CategoryDao();
		CategoryVo vo = new CategoryVo();
		vo.setName("자바");
		vo.setContent("자바는 어렵습니다...");
		vo.setBlogNo(1);
		dao.insert(vo);
		
		vo.setName("스프링");
		vo.setContent("스프링은 더더욱 어렵습니다...");
		vo.setBlogNo(1);
		dao.insert(vo);
		
		vo.setName("파이썬");
		vo.setContent("파이썬은 어려울까요...");
		vo.setBlogNo(1);
		dao.insert(vo);
	}
	
	public static void getList() {
		CategoryDao dao = new CategoryDao();
		for(CategoryVo category : dao.getList()) {
			System.out.println(category);
		}
	}

}
