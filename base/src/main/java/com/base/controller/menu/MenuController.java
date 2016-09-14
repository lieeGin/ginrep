package com.base.controller.menu;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.base.common.BaseReturnModel;
import com.base.controller.BaseController;
import com.base.service.menu.MenuService;

@Controller
@RequestMapping("/user") 
public class MenuController extends BaseController{
	
	@Autowired
	private MenuService menuService;
	
	@RequestMapping(value = "/saveOrUpdate", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public BaseReturnModel saveOrUpdate(HttpServletRequest request) {
		BaseReturnModel rm = new BaseReturnModel();
		
		
		
		return rm;
	}
}
