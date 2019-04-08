package Ppf.UserViewimpl;  //负责交互，收集信息
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import Ppf.Exception.LoginException;
import Ppf.Exception.RegisterExpetion;
import Ppf.UesrView.UserView;
import Ppf.UserBiz.UserBiz;
import Ppf.UserBizimpl.UserBizimpl;
import Ppf.pojo.Admin;
import Ppf.pojo.Student;

public class UserViewimpl implements UserView {   //登陆
	private static UserViewimpl userViewimpl;
	private UserViewimpl(){
		Students.add(new Student(1,"赵云","男",25,"高级","常山",131545105,"609959462@qq.com",99,System.currentTimeMillis()));				
	}
	public synchronized static UserViewimpl getInstance(){        //单例模式
		if(userViewimpl==null){
			userViewimpl=new UserViewimpl();
		}
		return userViewimpl;
	}
	
	
	
	
	UserBiz user=new UserBizimpl();
	//static Student students[]=new Student[10];
	
//	{Student ss1=new Student(1,"赵云","男",25,"高级","常山",131545105,"609959462@qq.com",99);
//    students[0]=ss1;}                      //不写在方法里需要加大括号，初始化数组
	 List<Student> Students=new ArrayList<Student>();

//	public UserViewimpl() {
//		Students.add(new Student(1,"赵云","男",25,"高级","常山",131545105,"609959462@qq.com",99,System.currentTimeMillis()));		
//	}
//	
	public void login() throws LoginException {
		UserBiz userBiz=new UserBizimpl();
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		System.out.println("欢迎登陆!");
		System.out.println("请输入用户名");
		String username=s.next();
		boolean usernameexists=userBiz.isusernameexists(username);        //这儿要立刻判断是否用户名重复
		if(usernameexists) {                          			
			String str="ABCDEFGHIJKLMNOPQRSTUVWXYZqwertyuiopadsfghjklzxcvbnm0123456789";    //验证码
			String yanzheng=new String();     //判断验证码
	        for(int i1=0;i1<4;i1++)                                        
	        {
	            char ch=str.charAt(new Random().nextInt(str.length()));
	            yanzheng+=ch;                   //验证码拼接
	        }
	          
	        System.out.println(yanzheng);
	        System.out.print("请输入验证码:");                 //获取验证码
	        String uuid=s.next(); 
	        
	        System.out.println("请输入密码:");
			String password=s.next();              //负责与用户交互，获取信息
			userBiz.login(username,yanzheng,uuid,password);     //调用使用信息的Biz方法（BIZ是业务逻辑层），同时这个方法还是异常的，上抛
		}
	
		//user.login(username,password);	
	}
	public void see() {
		System.out.println("**********选择要操作的信息对应的数字**********");
		System.out.println("*1.查看学生信息   *2.添加学生信息  *3.删除学生信息  *4.修改学生信息    *5退出      *6.二分法查找");
		Scanner s =new Scanner(System.in);
		int num=s.nextInt();
		if(num==1) {user.look(Students);}
		if(num==2) {user.add(Students);
	}
		if(num==3) {user.delect(Students);}
		if(num==4) {
			System.out.println("*1.根据id修改学生全部信息  *2.根据id修改学生部分信息 *3.返回上级目录   *4系统退出");
			Scanner s1 =new Scanner(System.in);
			int num1=s1.nextInt();
			if(num1==1) {
				user.correct(Students);        //修改全部信息
				see();
			}
			if(num1==2) {              //修改部分信息
				user.correctPart(Students);
			}
			}
		if(num==5) {
			System.exit(0);
		}
		if(num==6) {
			//二分法查找学生成绩
			//user.two(Students);
			System.out.println("请输入要查找的学生成绩");
			Scanner s2=new Scanner(System.in);
			int num2=s2.nextInt();
			int x=user.two(Students,num2);
			//for(int i=0;i<Students.size();i++) {
			if(x!=-1) {
				System.out.println("查到:"+Students.get(x).getName());
			}else {
				System.out.println("没查到");
			}
		}
		}
	//}
	
	
//	public String toString(){
//		
//		return "id："+Students.this.getId()+"          |姓名:"+Students.get(i).getName()+"          |性别:"+Students.get(i).getSex()+"          |班级:"+Students.get(i).get_class()+"          |地址:"
//				+Students.get(i).getAddress()+"          |电话:"+Students.get(i).getPhone()+"          |邮件:"+Students.get(i).getEmail()+"          |成绩:"+Students.get(i).getScores()+"          |注册时间:"+_date 				
//	}
//	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private boolean two(List<Student> students2, int num2) {
		// TODO Auto-generated method stub
		return false;
	}
	public void register() throws RegisterExpetion {
		// TODO Auto-generated method stub
			
	}

}
