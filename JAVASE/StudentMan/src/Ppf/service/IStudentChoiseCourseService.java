package Ppf.service;

import java.util.List;

import Ppf.common.ServerResponse;
import Ppf.pojo.Course;

public interface IStudentChoiseCourseService {

	/**
	 * ѧ��ѡ��
	 * 
	 * @param cid �γ�id
	 * @param coursesѧ���Ĺ��ﳵ
	 * */
	
	public ServerResponse choiseCourse(int id,int cid);
	
	
}
