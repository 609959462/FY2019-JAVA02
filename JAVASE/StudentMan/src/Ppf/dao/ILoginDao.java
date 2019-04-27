package Ppf.dao;

import Ppf.pojo.Admin;

public interface ILoginDao { 
	public boolean isuseernameexists(String username);                             //判断用户名存在否
	public Admin findAdminByusernameAndPasseord(String username,String password);  //判断登陆
} 
