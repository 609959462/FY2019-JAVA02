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
	System.out.println("=======��ӭ��½ѧ��ϵͳ=======");
	System.out.println("===��ѡ��===");
	System.out.println("1.��½    2.�˳�");
	
	Scanner s=new Scanner(System.in);
	int num=s.nextInt();
	if(num==1) {
		//��½
		UserView user=new UserViewimpl();
			try {
				user.login();
			} catch (LoginException e) {
				// TODO Auto-generated catch block
				String msg=e.getMessage();      //getMessage �쳣����Ϣ
				System.out.print(msg);
				
				
				
			}
		
		
	}
	if(num==2) {
		System.out.println("===�ڴ��´��ټ�===");
		System.exit(0);
	}
}
}