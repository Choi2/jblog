package com.cafe24.jblog.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.jblog.vo.BlogVo;
import com.cafe24.jblog.vo.CategoryVo;
import com.cafe24.jblog.vo.PostVo;

@Repository
public class BlogDao {

	@Autowired
	private SqlSession sqlSession;
	
	public int updateBlogAdmin(BlogVo vo) {
		return sqlSession.update("blog.updateBlogAdmin", vo);
	}

	public BlogVo getBlogById(String id) {
		return sqlSession.selectOne("blog.getBlogById", id);
	}

	public int insert(long userNo) {
		return sqlSession.insert("blog.insert", userNo);
	}

	public List<CategoryVo> getAllCategoryList() {
		return sqlSession.selectList("blog.getAllCategoryList");
	}

	public int insertCategory(CategoryVo vo) {
		return sqlSession.insert("blog.insertCategory", vo);
	}

	public int deleteCategory(long no) {
		return sqlSession.delete("blog.deleteCategory", no);
	}
	
	public int insertPost(PostVo vo) {
		return sqlSession.insert("blog.insertPost", vo);
	}

	public List<PostVo> getAllPostList(long no) {
		return sqlSession.selectList("blog.getAllPostList", no);
	}

	public PostVo getPost(long no) {
		return sqlSession.selectOne("blog.getPost", no);
	}
}
