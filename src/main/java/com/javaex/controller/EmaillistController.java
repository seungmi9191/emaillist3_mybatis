package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.dao.EmaillistDao;
import com.javaex.vo.EmailVO;

@Controller
public class EmaillistController {
	
	@Autowired
	private EmaillistDao dao;
	
	@RequestMapping(value="/form", method=RequestMethod.GET)
	public String form() {
		System.out.println("form진입~");
		return "/WEB-INF/views/form.jsp";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(@ModelAttribute EmailVO emailVo) {
		System.out.println("add 실행됐다~");
		System.out.println(emailVo.toString());
		
		//EmaillistDao dao = new EmaillistDao();
		dao.insert(emailVo);
		return "redirect:/list";
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list(Model model) {
		
		//EmaillistDao dao = new EmaillistDao();
		List<EmailVO> list = dao.getList();
		model.addAttribute("list", list);
		
		return "/WEB-INF/views/list.jsp";
	}
	
}
