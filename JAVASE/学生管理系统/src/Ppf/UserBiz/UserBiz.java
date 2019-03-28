package Ppf.UserBiz;

import Ppf.Exception.LoginException;
import Ppf.Exception.RegisterExpetion;
import Ppf.pojo.Student;

public interface UserBiz {
		void register(String username, String password) throws RegisterExpetion;           //用户注册
	  void login(String username, String password) throws LoginException;   //用户登录
	void add(Student students[]);
	void look(Student students[]);
	
	void delect();
	void correct(Student[] students);
	
	
	
	
	
}
