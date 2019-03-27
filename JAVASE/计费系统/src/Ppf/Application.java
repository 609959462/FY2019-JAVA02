package Ppf;

import java.util.Scanner;

import Ppf.Exception.LoginException;
import Ppf.Exception.RegisterException;
import Ppf.view.UserView;
import Ppf.viewimpl.UserViewimpl;

public class Application {
//负责启动项目
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application app=new Application();
		app.choise();
	}
	public void  choise() {
		
		System.out.println("====欢迎访问计费系统===");
		Scanner s=new Scanner(System.in);
		System.out.println("====请输入 1:登录 2:注册===");
		int num=s.nextInt();
		UserView userView=new UserViewimpl();
		if(num==1) {//登录
				   
				try {
				userView.login();                          //login方法的异常
				} catch (LoginException e) {
					String msg=e.getMessage();      //getMessage 异常的信息
					System.out.print(msg);
					
				}
			
		
				
			}else  if(num==2){
			//注册
				
				try {
					userView.register();
				} catch (LoginException e) {
					String msg=e.getMessage();      //getMessage 异常的信息
					System.out.print(msg);
				}	
				
			
		}
		
		
	}
}
