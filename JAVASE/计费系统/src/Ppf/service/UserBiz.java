package Ppf.service;

import Ppf.Exception.LoginException;
import Ppf.Exception.RegisterException;

public interface UserBiz {
	  void register(String username, String password, String password2,
			  String name, String email) throws RegisterException;           //�û�ע��
	  void register(String username) throws RegisterException;
	  void login(String username, String password) throws LoginException;   //�û���¼
	  
	  /*
		 * �ж��û����Ƿ����
		 * @param username �û���
		 * @return boolean true:�û������� false:������
		 * */
	  boolean isusernameexists(String username)throws LoginException;	
}
