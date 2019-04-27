package Ppf.service;


import Ppf.Exception.LoginException;
import Ppf.common.ServerResponse;
import Ppf.pojo.Admin;

public interface IAdminService {
	public  ServerResponse<Admin>  login(String username,String password) throws LoginException;


	public ServerResponse<Admin> regist(String username,String password);



	
}
