package com.base.controller.user;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.base.common.BaseReturnModel;
import com.base.controller.BaseController;

@Controller
@RequestMapping("/user") 
public class UserController extends BaseController{
	
	
	@RequestMapping(value = "/saveOrUpdate", method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public BaseReturnModel saveOrUpdate(HttpServletRequest request) {
		
		BaseReturnModel rm = new BaseReturnModel();
		
		return rm;
	}
}
