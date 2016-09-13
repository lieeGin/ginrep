package com.base.security;

import com.base.common.BaseReturnModel;
import com.base.dao.SysUser;


public abstract class AbstractAuthFilter {

	
	/**
	 * 验证 
	 * @return
	 */
	public abstract BaseReturnModel  validateAuth(SysUser user);
	
}
