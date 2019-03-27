package Ppf.service;

import Ppf.Exception.LoginException;
import Ppf.Exception.RegisterException;

public interface UserBiz {
	  void register(String username, String password, String password2,
			  String name, String email) throws RegisterException;           //用户注册
	  void register(String username) throws RegisterException;
	  void login(String username, String password) throws LoginException;   //用户登录
	  
	  /*
		 * 判断用户名是否存在
		 * @param username 用户名
		 * @return boolean true:用户名存在 false:不存在
		 * */
	  boolean isusernameexists(String username)throws LoginException;	
}
