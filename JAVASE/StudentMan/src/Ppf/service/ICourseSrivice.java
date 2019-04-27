package Ppf.service;

import java.util.HashMap;
import java.util.Map;

import Ppf.common.ServerResponse;
import Ppf.pojo.Course;

public interface ICourseSrivice {
	Map<Integer,Course> courses=new HashMap<>();           //接口中定义保存课程的集合（常量，可以添加---引用类型地址不可变，但添加不影响）
	
	
	
	public ServerResponse addCourse(int cid,String cname);      //添加课程
	public ServerResponse deleteCourse(int cid);   //删除
	 public ServerResponse updateCourse(int cid,String cname);  //修改
	 public ServerResponse findCourseByid(int cid);                 //根据cid查询课程信息
	 public ServerResponse findCourse();                        //查看所有课程
	
}
