package Ppf.viewimpl;

import Ppf.Exception.LoginException;
import Ppf.service.UserBiz;
import Ppf.serviceimpl.UserBizimpl;
import Ppf.view.UserView;

import java.util.Scanner;

public class UserViewimpl implements UserView {
	
	UserBiz userBiz=new UserBizimpl();       //���ö�̬�������չ��  ����17��
	public void login() throws LoginException{                       //���׵��⣬������ҲҪ���ף�  �׵��⣬˭����˭����
		Scanner s=new Scanner(System.in);
		System.out.print("�������û���:");
		String username=s.next();                           
		boolean usernameexists=userBiz.isusernameexists(username);        //���Ҫ�����ж��Ƿ��û����ظ������Ҫ��
		if(usernameexists) {
		System.out.print("����������:");
		String password=s.next();              //�������û���������ȡ��Ϣ
	
		userBiz.login(username, password);     //����ʹ����Ϣ��Biz������BIZ��ҵ���߼��㣩��ͬʱ������������쳣�ģ�����
	}}
	
	
	
	
	 public void register() {
		 	Scanner s=new Scanner(System.in);
			System.out.println("��������Ҫע����û���:");
			String username=s.next();
			
			UserBizimpl usb=new UserBizimpl();
			System.out.println("��������������:");
			String password=s.next();
			System.out.println("���ٴ�������������:");
			String password2=s.next();
			System.out.println("��������������:");
			String email=s.next();
	 }
	
}
