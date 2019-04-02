package Ppf.UserBiz;

import java.util.List;

import Ppf.Exception.LoginException;
import Ppf.Exception.RegisterExpetion;
import Ppf.pojo.Student;

public interface UserBiz {
		void register(String username, String password) throws RegisterExpetion;           //用户注册
	  void login(String username, String password) throws LoginException;   //用户登录
	void add(List<Student> Students);
	void look(List<Student> Students);
	
	void delect();
	void correct(List<Student> Students);
	void correctPart(List<Student> Students);
	void delect(List<Student> Students);
	boolean isusernameexists(String username) throws LoginException;
	
	}
	
