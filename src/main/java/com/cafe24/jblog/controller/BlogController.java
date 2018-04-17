package com.cafe24.jblog.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import com.cafe24.jblog.vo.Pager;
import com.cafe24.jblog.vo.PostVo;

@Controller
@RequestMapping("/{id:(?!admin|assets).*}")
public class BlogController {

	@Autowired
	private BlogService blogService;

	@RequestMapping({"", "/{categoryNo}", "/{categoryNo}/{postNo}"})
	public String postMain(
			@PathVariable ("id") String id, 
			@PathVariable Optional<Long> postNo,
			@PathVariable Optional<Long> categoryNo,
			/*@RequestParam (value="page", required=false, defaultValue="1") int page,*/
			Model model) throws IOException {
		
		long cateNo = 0;
		
		
		if(categoryNo.isPresent() == true) {
			cateNo = categoryNo.get();
		}
		
		BlogVo blog = blogService.getBlog(id);

		List<PostVo> postList = blogService.getPostList(blog.getNo(), cateNo);
		List<CategoryVo> categoryList = blogService.getCategoryList(blog.getNo(), null);
		
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
	public String blogAdminCategory(
			@PathVariable String id,
			@ModelAttribute Pager pager,
			Model model) {
		BlogVo blog = blogService.getBlog(id);
		List<CategoryVo> list = blogService.getCategoryList(blog.getNo(), pager);
		model.addAttribute("list", list);
		model.addAttribute("blog", blog);
		return "blog/blog-admin-category";
	}
	
	@RequestMapping(value="/admin/write", method=RequestMethod.GET)
	public String blogAdminWrite(
			@PathVariable String id, 
			Model model) {
		BlogVo blog = blogService.getBlog(id);
		List<CategoryVo> list = blogService.getCategoryList(blog.getNo(), null);
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
	public Map<String, Object> insertBlogAdminCategory(
			@ModelAttribute CategoryVo vo,
			@ModelAttribute Pager pager) {
		Map<String, Object> data = new HashMap<>();
		pager.calculate(pager.getPage());
		data.put("vo", vo);
		data.put("pager", pager);
		blogService.insertCategory(vo);
		return data;
	} //카테고리 추가(ajax)
	
	@RequestMapping(value="/admin/category/delete", method=RequestMethod.POST)
	@ResponseBody
	public String deleteBlogAdminCategory(@RequestParam long no) {
		blogService.deleteCategory(no);
		return "success";
	} //카테고리 삭제(ajax)
	
	
	

}
