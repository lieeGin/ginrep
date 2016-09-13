package com.base.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.base.common.BaseReturnModel;
import com.base.controller.BaseController;
import com.base.dao.SysUser;
import com.base.security.AbstractAuthFilter;
import com.base.security.AuthenticationManager;
import com.base.utils.StringUtil;

@Controller
@RequestMapping("/admin") 
public class AdminController extends BaseController{
	
	@Autowired
	private AuthenticationManager manager;
	
	
	@RequestMapping(value = "/login", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView loginPage(HttpServletRequest request) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/defaultTemplate/login");
		return mv;
	}
	

	@RequestMapping(value = "/index", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView index(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/defaultTemplate/index");
		return mv;
	}
	
	/**
	 * 登录
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/userLogin", method={RequestMethod.GET, RequestMethod.POST})   
	public BaseReturnModel login(HttpServletRequest request){
		BaseReturnModel result = new BaseReturnModel();
		
		String userName =  StringUtil.nullToString(request.getParameter("userName"));
		String password =  StringUtil.nullToString(request.getParameter("password"));
		
		SysUser user = new SysUser();
		user.setUserName(userName);
		user.setPassword(password); 
		
		List<AbstractAuthFilter> filterList = manager.getFilterList();
		for (AbstractAuthFilter filter : filterList) {
			result = filter.validateAuth(user);
			if(!result.getSuccess()){
				break;
			}
		}
		
		if(result.getSuccess()){
			user.where(SysUser.USERNAME.EQ(userName));
			try{
				List<SysUser> uList = user.query();
				if(uList!=null && uList.size()>0){
					SysUser dbUser = uList.get(0);
					request.getSession().setAttribute("userId", dbUser.getId());
					request.getSession().setAttribute("userName", dbUser.getUserName());
					request.getSession().setAttribute("displayName", dbUser.getDisplayName());
				}
			}catch(Exception e){
				logger.error("查询用户错误", e);
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	/**
	 * 退出
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/logout",method={RequestMethod.GET, RequestMethod.POST})  
    public BaseReturnModel logout(HttpServletRequest request){
		request.getSession().setAttribute("displayName",null);
		request.getSession().setAttribute("userName",null);
		request.getSession().setAttribute("userId",null);
		BaseReturnModel result = new BaseReturnModel();
		result.setSuccess(true);
        return result;  
    }  
	
}
