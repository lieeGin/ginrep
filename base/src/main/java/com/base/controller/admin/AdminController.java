package com.base.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.base.controller.BaseController;

@Controller
@RequestMapping("/admin") 
public class AdminController extends BaseController{
	
	
	@RequestMapping(value = "/index", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView index(HttpServletRequest request) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/defaultTemplate/login");
		return mv;
	}
}
