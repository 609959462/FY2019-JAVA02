package Ppf.dao;

import Ppf.pojo.Admin;

public interface ILoginDao { 
	public boolean isuseernameexists(String username);                             //�ж��û������ڷ�
	public Admin findAdminByusernameAndPasseord(String username,String password);  //�жϵ�½
} 
