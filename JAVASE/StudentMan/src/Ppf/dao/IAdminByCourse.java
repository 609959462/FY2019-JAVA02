package Ppf.dao;

import java.util.List;

import Ppf.pojo.Course;

public interface IAdminByCourse {
	//��ӿγ�
	public int addCourse(int cid,String cname);
	//�鿴�γ�
	public List<Course> lookCourse();
	//ɾ���γ�
	public int deleteCourse(int cid);
	//�޸Ŀγ�
	public int correctCourse(int cid,String cname);
}
