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
	//����
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
//			return ServerResponse.createServerResponseByFail(Const.COURSE_NAME_NOTNULL, "�γ���Ϊ��");
//		}
//		boolean isexists=false;
//		
//		Collection<Course> cs=courses.values();      //map�����ĵط�--��ȡ���е�values
//		Iterator<Course> iterator=cs.iterator();
//		while(iterator.hasNext()) {
//			Course c=iterator.next();
//			if(c.getCid()==cid) {
//				isexists=true;
//				break;
//			}
//		}
//		if(isexists) {
//			return ServerResponse.createServerResponseByFail(Const.COURSE_ID_EXISTS, "�γ��Ѵ���");
//		}
//		
//		Course c=new Course(cid,cname);
//		courses.put(cid,c);
		
//		int num=AdminByCourse.getInstance().addCourse(cid, cname);
//		if(num>0) {
//		return ServerResponse.createServerResponseBySucess();
//		}
//		return ServerResponse.createServerResponseByFail(Const.COURSE_ID_EXISTS, "�γ��Ѵ���"); 
		int num=AdminByCourse.getInstance().addCourse(cid, cname);
		if(num>0) {
			return ServerResponse.createServerResponseBySucess();
			}
			return ServerResponse.createServerResponseByFail(Const.COURSE_ID_EXISTS, "�γ��Ѵ���");
	}

	@Override
	public ServerResponse deleteCourse(int cid) {
		// TODO Auto-generated method stub				
//		boolean isexists=false;
//		Collection<Course> cs=courses.values();   //courses��k������v�Ǽ�������
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
//			return ServerResponse.createServerResponseBySucess("ɾ���ɹ�",courses.values());
//		}
//		
//			return ServerResponse.createServerResponseByFail(Const.COURSE_ID_NOEXISTS, "�γ�ID������");
		int num=AdminByCourse.getInstance().deleteCourse(cid);
		if(num>0) {
			return ServerResponse.createServerResponseBySucess("ɾ���ɹ�");
		}
		return ServerResponse.createServerResponseByFail(Const.COURSE_ID_NOEXISTS, "�γ�ID������");
	}

	//@Override
	public ServerResponse updateCourse(int cid, String cname) {
		// TODO Auto-generated method stub
//		boolean isexists=false;
//		Collection<Course> cs=courses.values();   //courses��k������v�Ǽ�������
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
//			return ServerResponse.createServerResponseBySucess("�޸ĳɹ�",courses.values());
//		}		
//			return ServerResponse.createServerResponseByFail(Const.COURSE_ID_NOEXISTS, "�γ�ID������");
		int num=AdminByCourse.getInstance().correctCourse(cid,cname);
		if(num>0) {
			return ServerResponse.createServerResponseBySucess("�޸ĳɹ�");
		}return ServerResponse.createServerResponseByFail(Const.COURSE_ID_NOEXISTS, "�γ�ID������");
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

		return ServerResponse.createServerResponseByFail(Const.COURSE_NOT_EXISTS, "�γ̲�����");
	}
	@Override
	public ServerResponse findCourse() {
		//Collection<Course> cs=courses.values();   //����values����
		List<Course> courses=AdminByCourse.getInstance().lookCourse();
		return ServerResponse.createServerResponseBySucess("ѧ����Ϣ",courses);
	}




}
