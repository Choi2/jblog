package com.cafe24.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.jblog.repository.BlogDao;
import com.cafe24.jblog.repository.UserDao;
import com.cafe24.jblog.vo.UserVo;


@Service	
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private BlogDao blogDao;

	public void join(UserVo vo) {
		userDao.insert(vo);
		blogDao.insert(vo.getNo());
	}

	public UserVo getUser(UserVo vo) {
		return userDao.get(vo);
	}

	public boolean modifyUser(UserVo vo) {
		return userDao.update(vo);
	}
}
