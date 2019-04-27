package Ppf.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import Ppf.Mybatis.imp.AdminByCourse;
import Ppf.common.Const;
import Ppf.common.ServerResponse;
import Ppf.pojo.Course;
import Ppf.service.ICourseSrivice;

public class CourseServiceimp implements ICourseSrivice {
	//单例
	private static  CourseServiceimp instance;
	private CourseServiceimp(){		
	}; 
	public static synchronized CourseServiceimp getInstance() {
		if(instance==null) {
			instance=new CourseServiceimp();
		}
		return instance;
	}
	
	@Override
	public ServerResponse addCourse(int cid, String cname) {
		// TODO Auto-generated method stub
//		if(cname==null||cname=="") {
//			return ServerResponse.createServerResponseByFail(Const.COURSE_NAME_NOTNULL, "课程名为空");
//		}
//		boolean isexists=false;
//		
//		Collection<Course> cs=courses.values();      //map厉害的地方--获取所有的values
//		Iterator<Course> iterator=cs.iterator();
//		while(iterator.hasNext()) {
//			Course c=iterator.next();
//			if(c.getCid()==cid) {
//				isexists=true;
//				break;
//			}
//		}
//		if(isexists) {
//			return ServerResponse.createServerResponseByFail(Const.COURSE_ID_EXISTS, "课程已存在");
//		}
//		
//		Course c=new Course(cid,cname);
//		courses.put(cid,c);
		
//		int num=AdminByCourse.getInstance().addCourse(cid, cname);
//		if(num>0) {
//		return ServerResponse.createServerResponseBySucess();
//		}
//		return ServerResponse.createServerResponseByFail(Const.COURSE_ID_EXISTS, "课程已存在"); 
		int num=AdminByCourse.getInstance().addCourse(cid, cname);
		if(num>0) {
			return ServerResponse.createServerResponseBySucess();
			}
			return ServerResponse.createServerResponseByFail(Const.COURSE_ID_EXISTS, "课程已存在");
	}

	@Override
	public ServerResponse deleteCourse(int cid) {
		// TODO Auto-generated method stub				
//		boolean isexists=false;
//		Collection<Course> cs=courses.values();   //courses是k是名字v是集合内容
//		Iterator<Course> iterator=cs.iterator();
//		while(iterator.hasNext()) {
//			Course c=iterator.next();
//			if(c.getCid()==cid) {
//				isexists=true;
//				break;
//			}
//		}
//		if(isexists) {
//			courses.remove(cid);   //
//			return ServerResponse.createServerResponseBySucess("删除成功",courses.values());
//		}
//		
//			return ServerResponse.createServerResponseByFail(Const.COURSE_ID_NOEXISTS, "课程ID不存在");
		int num=AdminByCourse.getInstance().deleteCourse(cid);
		if(num>0) {
			return ServerResponse.createServerResponseBySucess("删除成功");
		}
		return ServerResponse.createServerResponseByFail(Const.COURSE_ID_NOEXISTS, "课程ID不存在");
	}

	//@Override
	public ServerResponse updateCourse(int cid, String cname) {
		// TODO Auto-generated method stub
//		boolean isexists=false;
//		Collection<Course> cs=courses.values();   //courses是k是名字v是集合内容
//		Iterator<Course> iterator=cs.iterator();
//		while(iterator.hasNext()) {
//			Course c=iterator.next();
//			if(c.getCid()==cid) {
//				isexists=true;
//				break;
//			}
//		}
//		if(isexists) {
//			courses.get(cid).setCname(cname);
//			return ServerResponse.createServerResponseBySucess("修改成功",courses.values());
//		}		
//			return ServerResponse.createServerResponseByFail(Const.COURSE_ID_NOEXISTS, "课程ID不存在");
		int num=AdminByCourse.getInstance().correctCourse(cid,cname);
		if(num>0) {
			return ServerResponse.createServerResponseBySucess("修改成功");
		}return ServerResponse.createServerResponseByFail(Const.COURSE_ID_NOEXISTS, "课程ID不存在");
	}
	@Override
	public ServerResponse findCourseByid(int cid) {
		// TODO Auto-generated method stub
		Collection<Course> cs=courses.values();
		Iterator<Course> iterator=cs.iterator();
		while(iterator.hasNext()) {
			Course c=iterator.next();
			if(c.getCid()==cid) {
				return ServerResponse.createServerResponseBySucess("succ", c);
			}
		}

		return ServerResponse.createServerResponseByFail(Const.COURSE_NOT_EXISTS, "课程不存在");
	}
	@Override
	public ServerResponse findCourse() {
		//Collection<Course> cs=courses.values();   //返回values就行
		List<Course> courses=AdminByCourse.getInstance().lookCourse();
		return ServerResponse.createServerResponseBySucess("学生信息",courses);
	}




}
