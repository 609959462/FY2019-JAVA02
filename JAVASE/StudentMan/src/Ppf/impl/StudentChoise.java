package Ppf.impl;

import java.util.List;

import Ppf.Daoimpl.StudentChoiceCourseDao;
import Ppf.common.Const;
import Ppf.common.ServerResponse;
import Ppf.pojo.Course;
import Ppf.pojo.StudentCourse;
import Ppf.service.ICourseSrivice;
import Ppf.service.IStudentChoiseCourseService;

public class StudentChoise implements IStudentChoiseCourseService {
	private  static StudentChoise instance;   //单例
	private  StudentChoise() {};
	public synchronized static StudentChoise getInstance() {
		if(instance==null) {
			instance= new StudentChoise();
		}
		return instance;
	}
	@Override
	//public ServerResponse choiseCourse(int cid, List<Course> courses) {//根据id添加课程
		//根据cid查询课程   List<Course> courses就是购物车
//				ServerResponse<Course> serverResponse=CourseServiceimp.getInstance().findCourseByid(cid);
//				
//				if(serverResponse.isSucess()) {
//					//获取查询的课程
//					Course c=serverResponse.getData();
//					//将课程添加到购物车
//					courses.add(c);
//					return ServerResponse.createServerResponseBySucess("添加成功",courses);
//				}
//				
//				return ServerResponse.createServerResponseByFail(Const.COURSE_NOT_EXISTS, "选择的课程不存在或者已经下架");
		public ServerResponse choiseCourse(int id,int cid) {
				if(StudentChoiceCourseDao.getInstance().isChoiceCourse(id,cid)==0) {
				if(StudentChoiceCourseDao.getInstance().choice(id, cid)>0) {
					return ServerResponse.createServerResponseBySucess("选择成功");
				}
				return ServerResponse.createServerResponseByFail(Const.COURSE_NOT_EXISTS, "选择的课程不存在或者已经下架");
	}return ServerResponse.createServerResponseByFail(25, "您已经选择了该课程");}

	public ServerResponse see(int id){//查看所选课程
		List<StudentCourse> course=StudentChoiceCourseDao.getInstance().findCourseBySid(id);
		
		if(course!=null) {
			return ServerResponse.createServerResponseBySucess("查看成功",course);
		}
		return  null;				
	}
	public ServerResponse delete(int id,int cid) {   //删除课程
//		for(int i=0;i<courses.size();i++) {
//			if(courses.get(i).getCid()==cid) {
//				courses.remove(i);
//				return ServerResponse.createServerResponseBySucess("删除成功");
//			}	
//		}		
		int num =StudentChoiceCourseDao.getInstance().cancleCourse(id,cid);
		if(num>0) {return ServerResponse.createServerResponseBySucess("删除成功");}
		return ServerResponse.createServerResponseByFail(Const.COURSE_NOT_EXISTS, "未选择该课程");
	}
	
	
}
