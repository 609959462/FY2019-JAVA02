package Ppf.UserBiz;

import Ppf.Exception.LoginException;
import Ppf.Exception.RegisterExpetion;
import Ppf.pojo.Student;

public interface UserBiz {
		void register(String username, String password) throws RegisterExpetion;           //�û�ע��
	  void login(String username, String password) throws LoginException;   //�û���¼
	void add(Student students[]);
	void look(Student students[]);
	
	void delect();
	void correct(Student[] students);
	
	
	
	
	
}
