package Ppf.UserBiz;

import java.util.List;

import Ppf.Exception.LoginException;
import Ppf.Exception.RegisterExpetion;
import Ppf.pojo.Student;

public interface UserBiz {
		void register(String username, String password) throws RegisterExpetion;           //�û�ע��
	  void login(String username, String password) throws LoginException;   //�û���¼
	void add(List<Student> Students);
	void look(List<Student> Students);
	
	void delect();
	void correct(List<Student> Students);
	void correctPart(List<Student> Students);
	void delect(List<Student> Students);
	boolean isusernameexists(String username) throws LoginException;
	void login(String username, String yanzheng, String uuid, String password) throws LoginException;
	boolean two(List<Student> students);
	int two(List<Student> students, int x);
	
	
	}
	
