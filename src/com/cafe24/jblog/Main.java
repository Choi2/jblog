package com.cafe24.jblog;

import com.cafe24.jblog.blog.dao.test.BlogDaoTest;
import com.cafe24.jblog.category.dao.test.CategoryDaoTest;
import com.cafe24.jblog.comment.dao.test.CommentDaoTest;
import com.cafe24.jblog.post.dao.test.PostDaoTest;
import com.cafe24.jblog.user.dao.test.UserDaoTest;

public class Main {

	public static void main(String[] args) {
		System.out.println("----------------------------------------회원 리스트----------------------------------------");
		UserDaoTest.insertTest();
		UserDaoTest.getList();
		
		System.out.println("----------------------------------------블로그 리스트----------------------------------------");
		BlogDaoTest.insertTest();
		BlogDaoTest.getList();
		
		System.out.println("----------------------------------------카테고리 리스트----------------------------------------");
		CategoryDaoTest.insertTest();
		CategoryDaoTest.getList();
		
		System.out.println("----------------------------------------포스트 리스트----------------------------------------");
		PostDaoTest.insertTest();
		PostDaoTest.getList();
		
		System.out.println("----------------------------------------코멘트 리스트----------------------------------------");
		CommentDaoTest.insertTest();
		CommentDaoTest.getList();
	}

}
