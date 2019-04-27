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
	//改成map
//	Map<Student> Students=new <Student>();
	 private static StudentServiceImpl userViewimpl;	
	 public synchronized static StudentServiceImpl getInstance(){        //单例模式
		if(userViewimpl==null){
			userViewimpl=new StudentServiceImpl();
		}
		return userViewimpl;
	}
//	 Date date =new Date(System.currentTimeMillis());
//	 SimpleDateFormat format =new SimpleDateFormat("yy-MM-dd HH:mm:ss");
//	 String _date=format.format(date);
	 private StudentServiceImpl(){			
		 //Students.add(new Student(1,"赵云","男",25,"高级","常山",131545105,"609959462@qq.com",99,_date,"admin"));				
		}		
	 //查看学生
	 public ServerResponse look() {
			// TODO Auto-generated method stub
	
		 		//Collections.sort(Students);		
				//Date date =new Date(Students.get(i).getDate());              //把student的时间给了
		        //SimpleDateFormat format =new SimpleDateFormat("yy-MM-dd HH:mm:ss");     //调整格式
		        //String _date=format.format(date);                                   //赋值		       
		 			
		 List<Student> students=AdminByStudent.getInstance().lookAll();
		 return ServerResponse.createServerResponseBySucess("查看成功",students);		
	 }

	 //查看部分学生
	 //public ServerResponse lookPart(String operation1, int num1) {
//		 	if(operation1.equals("id")) {
//			boolean isusernameexists=AdminByStudent.getInstance().isusernameexists(num1);
//			if(isusernameexists) {
//			List<Student> students=AdminByStudent.getInstance().lookPart(num1);
//			return ServerResponse.createServerResponseBySucess("查看成功",students);		 
//			}   
//			return ServerResponse.createServerResponseByFail(15, "您输入的id不存在");	
//		 	} return null; 
											
	//   }                 
//		//添加学生
	public ServerResponse<Student> add(int id, String name, int sex, int age, String _class, String address, int phone, String email,
			int scores,String password) {
		// TODO Auto-generated method stub
//		boolean isexistsusername=isusernameexists(id);
//		if(!isexistsusername) {
//		 Date date1 =new Date(System.currentTimeMillis());
//		 SimpleDateFormat format =new SimpleDateFormat("yy-MM-dd HH:mm:ss");
//		 String _date=format.format(date1);
		 //Student s=new Student(id,name,sex,age,_class,address,phone,email,scores,_date,password);
		//Students[i]=s;                //数组为空就添加s 给i.
    		//Students.add(s);
//    		return ServerResponse.createServerResponseBySucess("添加成功");	 
//	}else {
//		return ServerResponse.createServerResponseByFail(15, "您输入的id已存在");
//	}		
		if(AdminByStudent.getInstance().add(id, name, sex, age, _class, address, phone, email, scores, password)) {
			return ServerResponse.createServerResponseBySucess("添加成功");	
		}     
		return ServerResponse.createServerResponseByFail(15, "您输入的id已存在");
	} 
		
//		
		   
	//修改学生
	public ServerResponse correct(int id, String name, int sex, int age, String _class, String address,
			int phone, String email, int scores){
//
//		boolean a=false;   //判断输入的id存不存在（你要遍历完才能判断有没有，那么就添加个boolean，进入循环，假如不等于m1，a=true，）
//		for(int i=0;i<Students.size();i++) {
//	
//	if(Students.get(i).getId()==id) {
//		a=false;                 //每次都要保证它为false		    
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
			return ServerResponse.createServerResponseBySucess("修改成功");		}
				
	else {
		 return ServerResponse.createServerResponseByFail(15, "您输入的ID不存在");
	}
}
	
  
	//删除学生
	public ServerResponse delect(int m) {
		
		int a=AdminByStudent.getInstance().delete(m);
		if(a>0) {
			return ServerResponse.createServerResponseBySucess("删除成功");
		}
//		for(int i=0;i<Students.size();i++) {
//			if(Students.get(i)==null) {
//				continue;
//			}
//			if(Students.get(i).getId()==m) {
//				Students.remove(Students.get(i));	
//				return ServerResponse.createServerResponseBySucess("删除成功");
//			}			
//		}
		return ServerResponse.createServerResponseByFail(20, "未查到ID");
	} 
//	//学生登陆
//	public boolean isusernameexists(int id) {                               //判断id存不存在
//		// TODO Auto-generated method stub
//			for(int i=0;i<Students.size();i++) {
//			
//				Student user=Students.get(i);
//			if(user==null) {
//				continue;
//			}			
//			int _id=user.getId();			
//			if(_id==id) {//用户名存在
//				
//			   return true;
//			}
//			 
//		}
//			 return  false;	
//	}
//	
	 //判断学生id 
	 //学生登陆
	/*public ServerResponse studentLogin(int id,String password) {
		Student student=LoginDao.getInstance().studentLogin(id, password);
		System.out.print(student);
		if(student!=null) {
			return ServerResponse.createServerResponseBySucess("学生登陆成功",student);
		} else { return ServerResponse.createServerResponseByFail(20, "未查到ID");
		}}*/
//		}
////		if() {
////			return ServerResponse.createServerResponseByFail(Const.USERNAME_NOT_NULL, "用户名不能为空");
////		}	
//		if(pssword==null||pssword.equals("")) {
//			return ServerResponse.createServerResponseByFail(Const.PASSWORD_NOT_NULL, "密码不能为空");
//		}
//		boolean isexistsusername=isusernameexists(id);
//		if(isexistsusername) {
//		for(int i=0;i<Students.size();i++) {			
//			if(Students.get(i).getId()==id) {
//				if(Students.get(i).getPassword().equals(pssword)) {
//					return ServerResponse.createServerResponseBySucess("学生登陆成功",Students.get(i));	
//				}else {	
//					return ServerResponse.createServerResponseByFail(Const.USERNAME_NOT_ERROR,"密码错误" );  
//				}
//			}
//			}					
//	}
//		return ServerResponse.createServerResponseByFail(20, "未查到ID");
//	}			

}