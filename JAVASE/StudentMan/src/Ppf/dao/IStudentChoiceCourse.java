package Ppf.dao;

import java.util.List;

import Ppf.common.PageModel;
import Ppf.pojo.Student;
import Ppf.pojo.StudentCourse;

public interface IStudentChoiceCourse {
	
	//����ҳ
	public PageModel<StudentCourse> findCourseBySidLimit(int sid,int PageNo,int PageSize);
	
	
	
	
	//�ж�ѧ���Ƿ�ѡ��(����int������count�������,count()ͳ�������������)	
	/**
	 * @param id ѧ��id
	 * @param cid �γ�id
	 * @return>0 �Ѿ�ѡ����
	 * */
	public int isChoiceCourse(int id,int cid);
	
	//ѡ��
	/**
	 * @return>0ѡ�ɹ�
	 * @return ѧ��ѡ��Ŀγ̼���
	 * */
	public int choice(int id,int cid);
	//�鿴�γ�
	public List<StudentCourse> findCourseBySid(int id);
	//ȡ��ѡ�񣨷���ֵ--��Ӧ�ľ��Ƕ����ݿ�Ĳ�������Ӱ���������
	public int cancleCourse(int id,int cid);




	
}
