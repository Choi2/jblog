package com.cafe24.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cafe24.jblog.repository.BlogDao;
import com.cafe24.jblog.util.FileUploadService;
import com.cafe24.jblog.vo.BlogVo;
import com.cafe24.jblog.vo.CategoryVo;
import com.cafe24.jblog.vo.Pager;
import com.cafe24.jblog.vo.PostVo;

@Service
public class BlogService {
	
	@Autowired
	private BlogDao blogDao;

	public void modifyBlogAdmin(BlogVo vo, MultipartFile multipartFile) {
		String imagePath = new FileUploadService().restore(multipartFile);
		String imageName = multipartFile.getOriginalFilename();
		vo.setImageName(imageName);
		vo.setImagePath(imagePath);
		blogDao.updateBlogAdmin(vo);
	}

	public BlogVo getBlog(String id) {
		return blogDao.getBlogById(id);
	}

	public List<CategoryVo> getCategoryList(long blogNo, Pager pager) {
		
		int startPageIndex = -1;
		
		
		if(pager != null) {
			pager.setTotalCount(blogDao.getCountCategory(blogNo));
			pager.calculate(pager.getPage());
			startPageIndex = pager.getStartPageIndex();
		}
		System.out.println(pager);
		return blogDao.getAllCategoryList(blogNo, startPageIndex);
	}
	
	public int insertCategory(CategoryVo vo) {
		return blogDao.insertCategory(vo);
	}

	public int deleteCategory(String no) {
		long blogNo = Integer.parseInt(no);
		return blogDao.deleteCategory(blogNo);
	}
	
	public int insertPost(PostVo vo) {
		blogDao.updateCategoryCount(vo.getCategoryNo());
		return blogDao.insertPost(vo);
	}

	public List<PostVo> getPostList(long no, long cateNo) {
		return blogDao.getAllPostList(no, cateNo);
	}
	
	public PostVo getPost(long no) {
		return blogDao.getPost(no);
	}
}
