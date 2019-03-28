package Ppf;

import java.util.Scanner;

import Ppf.Exception.LoginException;
import Ppf.Exception.RegisterExpetion;
import Ppf.UesrView.UserView;
import Ppf.UserViewimpl.UserViewimpl;

public class Application {
	
	public static void main(String[] args) {
		Application app=new Application();
		// TODO Auto-generated method stub
		app.choise();
		UserView user=new UserViewimpl();
		user.see();
}
	
	
	
	
	
	
	
	
	
	public void  choise() {
	System.out.println("=======欢迎登陆学生系统=======");
	System.out.println("===请选择===");
	System.out.println("1.登陆    2.退出");
	
	Scanner s=new Scanner(System.in);
	int num=s.nextInt();
	if(num==1) {
		//登陆
		UserView user=new UserViewimpl();
			try {
				user.login();
			} catch (LoginException e) {
				// TODO Auto-generated catch block
				String msg=e.getMessage();      //getMessage 异常的信息
				System.out.print(msg);
				
				
				
			}
		
		
	}
	if(num==2) {
		System.out.println("===期待下次再见===");
		System.exit(0);
	}
}
}