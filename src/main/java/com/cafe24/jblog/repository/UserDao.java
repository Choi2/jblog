package com.cafe24.jblog.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.jblog.vo.UserVo;

@Repository
public class UserDao {
	
	@Autowired
	private SqlSession sqlSession;

	public UserVo get(Long no) {
		return sqlSession.selectOne("user.getByNo", no);
	}
	
	public UserVo get(UserVo vo) {
		return sqlSession.selectOne("user.getByIdAndPassword", vo);
	}
	
	public boolean update(UserVo vo) {
		return (sqlSession.update("user.update", vo) == 1);
	}
	
	public int insert(UserVo vo) {
		return sqlSession.insert("user.insert", vo);
	}
	
	public UserVo get(String email) {
		return sqlSession.selectOne("user.getByEmail", email);
	}
}
