package Ppf.service;

import java.util.List;

import Ppf.common.ServerResponse;
import Ppf.pojo.Course;

public interface IStudentChoiseCourseService {

	/**
	 * 学生选课
	 * 
	 * @param cid 课程id
	 * @param courses学生的购物车
	 * */
	
	public ServerResponse choiseCourse(int id,int cid);
	
	
}
