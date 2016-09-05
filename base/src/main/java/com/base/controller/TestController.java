package com.base.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/testController") 
public class TestController {

	
	 
   @RequestMapping(value="/index",method=RequestMethod.GET)  
   public ModelAndView index(HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();  
 		modelAndView.setViewName("/index");  
       return modelAndView;  
   }  
	 
	
	
	
	
}
