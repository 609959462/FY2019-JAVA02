package Ppf.dao;

import java.util.List;

import Ppf.common.PageModel;
import Ppf.pojo.Student;
import Ppf.pojo.StudentCourse;

public interface IStudentChoiceCourse {
	
	//上下页
	public PageModel<StudentCourse> findCourseBySidLimit(int sid,int PageNo,int PageSize);
	
	
	
	
	//判断学生是否选课(返回int是用了count这个方法,count()统计括号里的行数)	
	/**
	 * @param id 学生id
	 * @param cid 课程id
	 * @return>0 已经选择了
	 * */
	public int isChoiceCourse(int id,int cid);
	
	//选课
	/**
	 * @return>0选成功
	 * @return 学生选择的课程集合
	 * */
	public int choice(int id,int cid);
	//查看课程
	public List<StudentCourse> findCourseBySid(int id);
	//取消选择（返回值--对应的就是对数据库的操作，受影响的行数）
	public int cancleCourse(int id,int cid);




	
}
