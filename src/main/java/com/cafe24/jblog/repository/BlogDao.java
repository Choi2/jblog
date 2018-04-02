package com.cafe24.jblog.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	public List<CategoryVo> getAllCategoryList(long blogNo, int startPageIndex) {
		Map<String, Object> parameter = new HashMap<>();
		parameter.put("blogNo", blogNo);
		parameter.put("startPageIndex", startPageIndex);
		return sqlSession.selectList("blog.getAllCategoryList", parameter);
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

	public List<PostVo> getAllPostList(long no, long cateNo) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("blogNo", no);
		parameters.put("categoryNo", cateNo);
		return sqlSession.selectList("blog.getAllPostList", parameters);
	}

	public PostVo getPost(long no) {
		return sqlSession.selectOne("blog.getPost", no);
	}

	public int updateCategoryCount(long categoryNo) {
		return sqlSession.update("blog.updateCategoryCount", categoryNo);
	}
	
	public int getCountCategory(long no) {
		return sqlSession.selectOne("blog.getCountCategory", no);
	}

}
