package Ppf.viewimpl;

import Ppf.Exception.LoginException;
import Ppf.service.UserBiz;
import Ppf.serviceimpl.UserBizimpl;
import Ppf.view.UserView;

import java.util.Scanner;

public class UserViewimpl implements UserView {
	
	UserBiz userBiz=new UserBizimpl();       //利用多态，提高扩展性  调用17行
	public void login() throws LoginException{                       //上抛到这，（父类也要上抛）  抛到这，谁调用谁处理
		Scanner s=new Scanner(System.in);
		System.out.print("请输入用户名:");
		String username=s.next();                           
		boolean usernameexists=userBiz.isusernameexists(username);        //这儿要立刻判断是否用户名重复（题干要求）
		if(usernameexists) {
		System.out.print("请输入密码:");
		String password=s.next();              //负责与用户交互，获取信息
	
		userBiz.login(username, password);     //调用使用信息的Biz方法（BIZ是业务逻辑层），同时这个方法还是异常的，上抛
	}}
	
	
	
	
	 public void register() {
		 	Scanner s=new Scanner(System.in);
			System.out.println("请输入您要注册的用户名:");
			String username=s.next();
			
			UserBizimpl usb=new UserBizimpl();
			System.out.println("请输入您的密码:");
			String password=s.next();
			System.out.println("请再次输入您的密码:");
			String password2=s.next();
			System.out.println("请输入您的邮箱:");
			String email=s.next();
	 }
	
}
