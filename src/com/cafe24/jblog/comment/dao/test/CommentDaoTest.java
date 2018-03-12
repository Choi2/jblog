package com.cafe24.jblog.comment.dao.test;

import com.cafe24.jblog.comment.dao.CommentDao;
import com.cafe24.jblog.comment.vo.CommentVo;

public class CommentDaoTest {

	public static void main(String[] args) {
	//	insertTest();
		getList();
		
	}
	
	public static void insertTest() {
		CommentDao dao = new CommentDao();
		CommentVo vo = new CommentVo();
		vo.setContent("좋은 블로그입니다.!!!");
		vo.setPostNo(1);
		dao.insert(vo);
		
		vo.setContent("나쁜 블로그입니다.!!!");
		vo.setPostNo(1);
		dao.insert(vo);
		
		vo.setContent("좋은 블로그입니다.!!!");
		vo.setPostNo(2);
		dao.insert(vo);
		
		vo.setContent("나쁜 블로그입니다.!!!");
		vo.setPostNo(2);
		dao.insert(vo);
	}
	
	public static void getList() {
		CommentDao dao = new CommentDao();
		for(CommentVo comment : dao.getList()) {
			System.out.println(comment);
		}
	}

}
