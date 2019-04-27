package Ppf.dao;

import java.util.List;

import Ppf.pojo.Course;

public interface IAdminByCourse {
	//添加课程
	public int addCourse(int cid,String cname);
	//查看课程
	public List<Course> lookCourse();
	//删除课程
	public int deleteCourse(int cid);
	//修改课程
	public int correctCourse(int cid,String cname);
}
