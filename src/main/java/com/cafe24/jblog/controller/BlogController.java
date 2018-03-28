package com.cafe24.jblog.controller;

import java.io.IOException;
import java.util.List;

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
public class BlogController {

	@Autowired
	private BlogService blogService;
	
	@RequestMapping("/{id}")
	public String blogMain(@PathVariable String id, Model model) throws IOException {
		BlogVo blog = blogService.getBlog(id);
		List<PostVo> postList = blogService.getPostList(blog.getNo());
		List<CategoryVo> categoryList = blogService.getCategoryList();
		if(postList.size() > 0) {
			PostVo post = postList.get(0);
			model.addAttribute("post", post);
		} else {
			model.addAttribute("post", new PostVo());
		}
		
		model.addAttribute("blog", blog);
		model.addAttribute("postList", postList);
		model.addAttribute("categoryList", categoryList);
		return "blog/blog-main";
	}
	
	@RequestMapping("/{id}/{no}")
	public String postMain(
			@PathVariable String id, 
			@PathVariable long no,
			Model model) throws IOException {
		BlogVo blog = blogService.getBlog(id);
		PostVo post = blogService.getPost(no);
		List<PostVo> postList = blogService.getPostList(blog.getNo());
		List<CategoryVo> categoryList = blogService.getCategoryList();
		model.addAttribute("blog", blog);
		model.addAttribute("post", post);
		model.addAttribute("postList", postList);
		model.addAttribute("categoryList", categoryList);
		return "blog/blog-main";
	}
	

	@RequestMapping(value="/{id}/admin/basic", method=RequestMethod.GET)
	public String blogAdminBasic(
			@PathVariable String id,
			Model model) {
		BlogVo blog = blogService.getBlog(id);
		model.addAttribute("blog", blog);
		return "blog/blog-admin-basic";
	}
	
	@RequestMapping(value="/{id}/admin/basic", method=RequestMethod.POST)
	public String modifyBlogAdmin(
			@PathVariable String id,
			@ModelAttribute BlogVo vo,
			@RequestParam("logo-file") MultipartFile multipartFile) {
		blogService.modifyBlogAdmin(vo, multipartFile);
		return "redirect:/" + id;
	}
	
	
	@RequestMapping(value="/{id}/admin/category", method=RequestMethod.GET)
	public String blogAdminCategory(@PathVariable String id, Model model) {
		List<CategoryVo> list = blogService.getCategoryList();
		BlogVo blog = blogService.getBlog(id);
		model.addAttribute("list", list);
		model.addAttribute("blog", blog);
		return "blog/blog-admin-category";
	}
	
	@RequestMapping(value="/{id}/admin/write", method=RequestMethod.GET)
	public String blogAdminWrite(@PathVariable String id, Model model) {
		List<CategoryVo> list = blogService.getCategoryList();
		BlogVo blog = blogService.getBlog(id);
		model.addAttribute("list", list);
		model.addAttribute("blog", blog);
		return "blog/blog-admin-write";
	}
	
	@RequestMapping(value="/{id}/admin/write", method=RequestMethod.POST)
	public String modifyBlogAdmin(
			@PathVariable String id,
			@ModelAttribute PostVo vo) {
		blogService.insertPost(vo);
		return "redirect:/" + id;
	}
	
	@RequestMapping(value="/{id}/admin/category/insert", method=RequestMethod.POST)
	@ResponseBody
	public CategoryVo insertBlogAdminCategory(CategoryVo vo) {
		blogService.insertCategory(vo);
		return vo;
	}
	
	@RequestMapping(value="/{id}/admin/category/delete", method=RequestMethod.POST)
	@ResponseBody
	public String deleteBlogAdminCategory(String no) {
		blogService.deleteCategory(no);
		return "success";
	}
	
	
	

}
