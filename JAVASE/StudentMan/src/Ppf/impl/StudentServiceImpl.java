package Ppf.impl;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import Ppf.Daoimpl.AdminByCourse;
import Ppf.Mybatis.imp.AdminByStudent;
import Ppf.Mybatis.imp.LoginDao;
//import Ppf.Daoimpl.LoginDao;
import Ppf.common.Const;
import Ppf.common.ServerResponse;
import Ppf.pojo.Student;
import Ppf.service.IStudentService;

public class StudentServiceImpl implements IStudentService {
	  //private static final DateFormat AdminByStudent = null;
	//List<Student> Students=new ArrayList<Student>();
	//�ĳ�map
//	Map<Student> Students=new <Student>();
	 private static StudentServiceImpl userViewimpl;	
	 public synchronized static StudentServiceImpl getInstance(){        //����ģʽ
		if(userViewimpl==null){
			userViewimpl=new StudentServiceImpl();
		}
		return userViewimpl;
	}
//	 Date date =new Date(System.currentTimeMillis());
//	 SimpleDateFormat format =new SimpleDateFormat("yy-MM-dd HH:mm:ss");
//	 String _date=format.format(date);
	 private StudentServiceImpl(){			
		 //Students.add(new Student(1,"����","��",25,"�߼�","��ɽ",131545105,"609959462@qq.com",99,_date,"admin"));				
		}		
	 //�鿴ѧ��
	 public ServerResponse look() {
			// TODO Auto-generated method stub
	
		 		//Collections.sort(Students);		
				//Date date =new Date(Students.get(i).getDate());              //��student��ʱ�����
		        //SimpleDateFormat format =new SimpleDateFormat("yy-MM-dd HH:mm:ss");     //������ʽ
		        //String _date=format.format(date);                                   //��ֵ		       
		 			
		 List<Student> students=AdminByStudent.getInstance().lookAll();
		 return ServerResponse.createServerResponseBySucess("�鿴�ɹ�",students);		
	 }

	 //�鿴����ѧ��
	 //public ServerResponse lookPart(String operation1, int num1) {
//		 	if(operation1.equals("id")) {
//			boolean isusernameexists=AdminByStudent.getInstance().isusernameexists(num1);
//			if(isusernameexists) {
//			List<Student> students=AdminByStudent.getInstance().lookPart(num1);
//			return ServerResponse.createServerResponseBySucess("�鿴�ɹ�",students);		 
//			}   
//			return ServerResponse.createServerResponseByFail(15, "�������id������");	
//		 	} return null; 
											
	//   }                 
//		//���ѧ��
	public ServerResponse<Student> add(int id, String name, int sex, int age, String _class, String address, int phone, String email,
			int scores,String password) {
		// TODO Auto-generated method stub
//		boolean isexistsusername=isusernameexists(id);
//		if(!isexistsusername) {
//		 Date date1 =new Date(System.currentTimeMillis());
//		 SimpleDateFormat format =new SimpleDateFormat("yy-MM-dd HH:mm:ss");
//		 String _date=format.format(date1);
		 //Student s=new Student(id,name,sex,age,_class,address,phone,email,scores,_date,password);
		//Students[i]=s;                //����Ϊ�վ����s ��i.
    		//Students.add(s);
//    		return ServerResponse.createServerResponseBySucess("��ӳɹ�");	 
//	}else {
//		return ServerResponse.createServerResponseByFail(15, "�������id�Ѵ���");
//	}		
		if(AdminByStudent.getInstance().add(id, name, sex, age, _class, address, phone, email, scores, password)) {
			return ServerResponse.createServerResponseBySucess("��ӳɹ�");	
		}     
		return ServerResponse.createServerResponseByFail(15, "�������id�Ѵ���");
	} 
		
//		
		   
	//�޸�ѧ��
	public ServerResponse correct(int id, String name, int sex, int age, String _class, String address,
			int phone, String email, int scores){
//
//		boolean a=false;   //�ж������id�治���ڣ���Ҫ����������ж���û�У���ô����Ӹ�boolean������ѭ�������粻����m1��a=true����
//		for(int i=0;i<Students.size();i++) {
//	
//	if(Students.get(i).getId()==id) {
//		a=false;                 //ÿ�ζ�Ҫ��֤��Ϊfalse		    
//        Students.get(i).setId(id);      
//        Students.get(i).setName(name);				
//        Students.get(i).setSex(sex);
//		
//        Students.get(i).setAge(age);
//		            
//		
//        Students.get(i).set_class(_class);
//		
//        Students.get(i).setAddress(address);
//		
//        Students.get(i).setPhone(phone);
//        Students.get(i).setEmail(email);			        			     
//       Students.get(i).setScores(scores);
	if(AdminByStudent.getInstance().correct(id, name, sex, age, _class, address, phone, email, scores)>0) {		
			return ServerResponse.createServerResponseBySucess("�޸ĳɹ�");		}
				
	else {
		 return ServerResponse.createServerResponseByFail(15, "�������ID������");
	}
}
	
  
	//ɾ��ѧ��
	public ServerResponse delect(int m) {
		
		int a=AdminByStudent.getInstance().delete(m);
		if(a>0) {
			return ServerResponse.createServerResponseBySucess("ɾ���ɹ�");
		}
//		for(int i=0;i<Students.size();i++) {
//			if(Students.get(i)==null) {
//				continue;
//			}
//			if(Students.get(i).getId()==m) {
//				Students.remove(Students.get(i));	
//				return ServerResponse.createServerResponseBySucess("ɾ���ɹ�");
//			}			
//		}
		return ServerResponse.createServerResponseByFail(20, "δ�鵽ID");
	} 
//	//ѧ����½
//	public boolean isusernameexists(int id) {                               //�ж�id�治����
//		// TODO Auto-generated method stub
//			for(int i=0;i<Students.size();i++) {
//			
//				Student user=Students.get(i);
//			if(user==null) {
//				continue;
//			}			
//			int _id=user.getId();			
//			if(_id==id) {//�û�������
//				
//			   return true;
//			}
//			 
//		}
//			 return  false;	
//	}
//	
	 //�ж�ѧ��id 
	 //ѧ����½
	/*public ServerResponse studentLogin(int id,String password) {
		Student student=LoginDao.getInstance().studentLogin(id, password);
		System.out.print(student);
		if(student!=null) {
			return ServerResponse.createServerResponseBySucess("ѧ����½�ɹ�",student);
		} else { return ServerResponse.createServerResponseByFail(20, "δ�鵽ID");
		}}*/
//		}
////		if() {
////			return ServerResponse.createServerResponseByFail(Const.USERNAME_NOT_NULL, "�û�������Ϊ��");
////		}	
//		if(pssword==null||pssword.equals("")) {
//			return ServerResponse.createServerResponseByFail(Const.PASSWORD_NOT_NULL, "���벻��Ϊ��");
//		}
//		boolean isexistsusername=isusernameexists(id);
//		if(isexistsusername) {
//		for(int i=0;i<Students.size();i++) {			
//			if(Students.get(i).getId()==id) {
//				if(Students.get(i).getPassword().equals(pssword)) {
//					return ServerResponse.createServerResponseBySucess("ѧ����½�ɹ�",Students.get(i));	
//				}else {	
//					return ServerResponse.createServerResponseByFail(Const.USERNAME_NOT_ERROR,"�������" );  
//				}
//			}
//			}					
//	}
//		return ServerResponse.createServerResponseByFail(20, "δ�鵽ID");
//	}			

}