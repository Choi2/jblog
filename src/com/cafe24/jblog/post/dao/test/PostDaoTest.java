package com.cafe24.jblog.post.dao.test;

import com.cafe24.jblog.post.dao.PostDao;
import com.cafe24.jblog.post.vo.PostVo;

public class PostDaoTest {

	public static void main(String[] args) {
		insertTest();
		getList();
		
	}
	
	public static void insertTest() {
		PostDao dao = new PostDao();
		PostVo vo = new PostVo();
		vo.setBlogNo(1);
		vo.setCategoryNo(3);
		vo.setTitle("스프링 배우기.jpg");
		vo.setContent("스프링은 재밌을까요??");
		dao.insert(vo);
		
		vo.setBlogNo(1);
		vo.setCategoryNo(3);
		vo.setTitle("자바 배우기.jpg");
		vo.setContent("자바는 재밌을까요??");
		dao.insert(vo);
	}
	
	public static void getList() {
		PostDao dao = new PostDao();
		for(PostVo post : dao.getList()) {
			System.out.println(post);
		}
	}

}
