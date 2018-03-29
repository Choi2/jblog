package com.cafe24.jblog.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.cafe24.jblog.service.BlogService;
import com.cafe24.jblog.vo.BlogVo;
import com.cafe24.jblog.vo.CategoryVo;
import com.cafe24.jblog.vo.PostVo;

@Controller
@RequestMapping("/{id:(?!admin|assets).*}")
public class BlogController {

	@Autowired
	private BlogService blogService;

	@RequestMapping({"", "/{categoryNo}", "/{categoryNo}/{postNo}"})
	public String postMain(
			@PathVariable String id, 
			@PathVariable Optional<Long> postNo,
			@PathVariable Optional<Long> categoryNo,
			Model model) throws IOException {
		
		long cateNo = 0;
		
		if(categoryNo.isPresent() == true) {
			cateNo = categoryNo.get();
		}
		
		BlogVo blog = blogService.getBlog(id);
		
		List<PostVo> postList = blogService.getPostList(blog.getNo(), cateNo);
		List<CategoryVo> categoryList = blogService.getCategoryList(blog.getNo());
		
		long no = postList.size();
		
		if(postNo.isPresent() == true) {
			no = postNo.get();
		}
		
		model.addAttribute("blog", blog);
		model.addAttribute("postList", postList);
		model.addAttribute("postNo", postList.size() - no);
		model.addAttribute("categoryList", categoryList);
		return "blog/blog-main";
	}
	

	@RequestMapping(value="/admin/basic", method=RequestMethod.GET)
	public String blogAdminBasic(
			@PathVariable String id,
			Model model) {
		BlogVo blog = blogService.getBlog(id);
		model.addAttribute("blog", blog);
		return "blog/blog-admin-basic";
	}
	
	@RequestMapping(value="/admin/basic", method=RequestMethod.POST)
	public String modifyBlogAdmin(
			@PathVariable String id,
			@ModelAttribute BlogVo vo,
			@RequestParam("logo-file") MultipartFile multipartFile) {
		blogService.modifyBlogAdmin(vo, multipartFile);
		return "redirect:/" + id;
	}
	
	
	@RequestMapping(value="/admin/category", method=RequestMethod.GET)
	public String blogAdminCategory(@PathVariable String id, Model model) {
		BlogVo blog = blogService.getBlog(id);
		List<CategoryVo> list = blogService.getCategoryList(blog.getNo());
		model.addAttribute("list", list);
		model.addAttribute("blog", blog);
		return "blog/blog-admin-category";
	}
	
	@RequestMapping(value="/admin/write", method=RequestMethod.GET)
	public String blogAdminWrite(@PathVariable String id, Model model) {
		BlogVo blog = blogService.getBlog(id);
		List<CategoryVo> list = blogService.getCategoryList(blog.getNo());
		model.addAttribute("list", list);
		model.addAttribute("blog", blog);
		return "blog/blog-admin-write";
	}
	
	@RequestMapping(value="/admin/write", method=RequestMethod.POST)
	public String modifyBlogAdmin(
			@PathVariable String id,
			@ModelAttribute PostVo vo) {
		blogService.insertPost(vo);
		return "redirect:/" + id;
	}
	
	@RequestMapping(value="/admin/category/insert", method=RequestMethod.POST)
	@ResponseBody
	public CategoryVo insertBlogAdminCategory(CategoryVo vo) {
		blogService.insertCategory(vo);
		return vo;
	}
	
	@RequestMapping(value="/admin/category/delete", method=RequestMethod.POST)
	@ResponseBody
	public String deleteBlogAdminCategory(String no) {
		blogService.deleteCategory(no);
		return "success";
	}
	
	
	

}
