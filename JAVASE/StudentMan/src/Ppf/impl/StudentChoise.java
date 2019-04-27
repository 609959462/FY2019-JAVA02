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
	private  static StudentChoise instance;   //����
	private  StudentChoise() {};
	public synchronized static StudentChoise getInstance() {
		if(instance==null) {
			instance= new StudentChoise();
		}
		return instance;
	}
	@Override
	//public ServerResponse choiseCourse(int cid, List<Course> courses) {//����id��ӿγ�
		//����cid��ѯ�γ�   List<Course> courses���ǹ��ﳵ
//				ServerResponse<Course> serverResponse=CourseServiceimp.getInstance().findCourseByid(cid);
//				
//				if(serverResponse.isSucess()) {
//					//��ȡ��ѯ�Ŀγ�
//					Course c=serverResponse.getData();
//					//���γ���ӵ����ﳵ
//					courses.add(c);
//					return ServerResponse.createServerResponseBySucess("��ӳɹ�",courses);
//				}
//				
//				return ServerResponse.createServerResponseByFail(Const.COURSE_NOT_EXISTS, "ѡ��Ŀγ̲����ڻ����Ѿ��¼�");
		public ServerResponse choiseCourse(int id,int cid) {
				if(StudentChoiceCourseDao.getInstance().isChoiceCourse(id,cid)==0) {
				if(StudentChoiceCourseDao.getInstance().choice(id, cid)>0) {
					return ServerResponse.createServerResponseBySucess("ѡ��ɹ�");
				}
				return ServerResponse.createServerResponseByFail(Const.COURSE_NOT_EXISTS, "ѡ��Ŀγ̲����ڻ����Ѿ��¼�");
	}return ServerResponse.createServerResponseByFail(25, "���Ѿ�ѡ���˸ÿγ�");}

	public ServerResponse see(int id){//�鿴��ѡ�γ�
		List<StudentCourse> course=StudentChoiceCourseDao.getInstance().findCourseBySid(id);
		
		if(course!=null) {
			return ServerResponse.createServerResponseBySucess("�鿴�ɹ�",course);
		}
		return  null;				
	}
	public ServerResponse delete(int id,int cid) {   //ɾ���γ�
//		for(int i=0;i<courses.size();i++) {
//			if(courses.get(i).getCid()==cid) {
//				courses.remove(i);
//				return ServerResponse.createServerResponseBySucess("ɾ���ɹ�");
//			}	
//		}		
		int num =StudentChoiceCourseDao.getInstance().cancleCourse(id,cid);
		if(num>0) {return ServerResponse.createServerResponseBySucess("ɾ���ɹ�");}
		return ServerResponse.createServerResponseByFail(Const.COURSE_NOT_EXISTS, "δѡ��ÿγ�");
	}
	
	
}
