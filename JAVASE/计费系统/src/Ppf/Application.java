package Ppf;

import java.util.Scanner;

import Ppf.Exception.LoginException;
import Ppf.Exception.RegisterException;
import Ppf.view.UserView;
import Ppf.viewimpl.UserViewimpl;

public class Application {
//����������Ŀ
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application app=new Application();
		app.choise();
	}
	public void  choise() {
		
		System.out.println("====��ӭ���ʼƷ�ϵͳ===");
		Scanner s=new Scanner(System.in);
		System.out.println("====������ 1:��¼ 2:ע��===");
		int num=s.nextInt();
		UserView userView=new UserViewimpl();
		if(num==1) {//��¼
				   
				try {
				userView.login();                          //login�������쳣
				} catch (LoginException e) {
					String msg=e.getMessage();      //getMessage �쳣����Ϣ
					System.out.print(msg);
					
				}
			
		
				
			}else  if(num==2){
			//ע��
				
				try {
					userView.register();
				} catch (LoginException e) {
					String msg=e.getMessage();      //getMessage �쳣����Ϣ
					System.out.print(msg);
				}	
				
			
		}
		
		
	}
}
