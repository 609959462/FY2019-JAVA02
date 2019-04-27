package Ppf.dao;

import java.util.List;

import Ppf.pojo.Student;

public interface IAdminByStudent {
  
	public List<Student> lookAll();
//	public List<Student> lookPart();
//	public boolean add();
//	
	public int delete(int id);//É¾³ıÑ§Éú
}
