package Ppf.UserViewimpl;  //负责交互，收集信息

import java.util.Scanner;

import Ppf.Exception.LoginException;
import Ppf.Exception.RegisterExpetion;
import Ppf.UesrView.UserView;
import Ppf.UserBiz.UserBiz;
import Ppf.UserBizimpl.UserBizimpl;
import Ppf.pojo.Student;

public class UserViewimpl implements UserView {   //登陆
	UserBiz user=new UserBizimpl();
	static Student students[]=new Student[10];{
	Student ss1=new Student(1,"赵云","男",25,"高级","常山",131545105,"609959462@qq.com");
    students[0]=ss1;}                      //不写在方法里需要加大括号，初始化数组
	
	public void login() throws LoginException {
		UserBiz userBiz=new UserBizimpl();
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		System.out.println("欢迎登陆!");
		System.out.println("请输入用户名");
		String username=s.next();
		boolean usernameexists=userBiz.isusernameexists(username);        //这儿要立刻判断是否用户名重复
		if(usernameexists) {
			System.out.print("请输入密码:");
			String password=s.next();              //负责与用户交互，获取信息
		
			userBiz.login(username, password);     //调用使用信息的Biz方法（BIZ是业务逻辑层），同时这个方法还是异常的，上抛
		}
	
		//user.login(username,password);	
	}
	public void see() {
		System.out.println("**********选择要操作的信息对应的数字**********");
		System.out.println("*1.查看学生信息   *2.添加学生信息  *3.删除学生信息  *4.修改学生信息    *5退出");
		Scanner s =new Scanner(System.in);
		int num=s.nextInt();
		if(num==1) {user.look(students);}
		if(num==2) {user.add(students);
	}
		if(num==3) {user.delect(students);}
		if(num==4) {
			System.out.println("*1.根据id修改学生全部信息  *2.根据id修改学生部分信息 *3.返回上级目录   *4系统退出");
			Scanner s1 =new Scanner(System.in);
			int num1=s.nextInt();
			if(num1==1) {
				user.correct(students);        //修改全部信息
				see();
			}
			if(num1==2) {              //修改部分信息
				user.correctPart(students);
			}
			}
		if(num==5) {
			System.exit(0);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void register() throws RegisterExpetion {
		// TODO Auto-generated method stub
			
	}

}
