package Ppf.service;

import java.util.HashMap;
import java.util.Map;

import Ppf.common.ServerResponse;
import Ppf.pojo.Course;

public interface ICourseSrivice {
	Map<Integer,Course> courses=new HashMap<>();           //�ӿ��ж��屣��γ̵ļ��ϣ��������������---�������͵�ַ���ɱ䣬����Ӳ�Ӱ�죩
	
	
	
	public ServerResponse addCourse(int cid,String cname);      //��ӿγ�
	public ServerResponse deleteCourse(int cid);   //ɾ��
	 public ServerResponse updateCourse(int cid,String cname);  //�޸�
	 public ServerResponse findCourseByid(int cid);                 //����cid��ѯ�γ���Ϣ
	 public ServerResponse findCourse();                        //�鿴���пγ�
	
}
