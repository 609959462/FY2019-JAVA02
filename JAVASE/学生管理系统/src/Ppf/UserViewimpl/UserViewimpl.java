package Ppf.UserViewimpl;  //���𽻻����ռ���Ϣ

import java.util.Scanner;

import Ppf.Exception.LoginException;
import Ppf.Exception.RegisterExpetion;
import Ppf.UesrView.UserView;
import Ppf.UserBiz.UserBiz;
import Ppf.UserBizimpl.UserBizimpl;
import Ppf.pojo.Student;

public class UserViewimpl implements UserView {   //��½
	UserBiz user=new UserBizimpl();
	static Student students[]=new Student[10];{
	Student ss1=new Student(1,"����","��",25,"�߼�","��ɽ",131545105,"609959462@qq.com");
    students[0]=ss1;}                      //��д�ڷ�������Ҫ�Ӵ����ţ���ʼ������
	
	public void login() throws LoginException {
		UserBiz userBiz=new UserBizimpl();
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		System.out.println("��ӭ��½!");
		System.out.println("�������û���");
		String username=s.next();
		boolean usernameexists=userBiz.isusernameexists(username);        //���Ҫ�����ж��Ƿ��û����ظ�
		if(usernameexists) {
			System.out.print("����������:");
			String password=s.next();              //�������û���������ȡ��Ϣ
		
			userBiz.login(username, password);     //����ʹ����Ϣ��Biz������BIZ��ҵ���߼��㣩��ͬʱ������������쳣�ģ�����
		}
	
		//user.login(username,password);	
	}
	public void see() {
		System.out.println("**********ѡ��Ҫ��������Ϣ��Ӧ������**********");
		System.out.println("*1.�鿴ѧ����Ϣ   *2.���ѧ����Ϣ  *3.ɾ��ѧ����Ϣ  *4.�޸�ѧ����Ϣ    *5�˳�");
		Scanner s =new Scanner(System.in);
		int num=s.nextInt();
		if(num==1) {user.look(students);}
		if(num==2) {user.add(students);
	}
		if(num==3) {user.delect(students);}
		if(num==4) {
			System.out.println("*1.����id�޸�ѧ��ȫ����Ϣ  *2.����id�޸�ѧ��������Ϣ *3.�����ϼ�Ŀ¼   *4ϵͳ�˳�");
			Scanner s1 =new Scanner(System.in);
			int num1=s.nextInt();
			if(num1==1) {
				user.correct(students);        //�޸�ȫ����Ϣ
				see();
			}
			if(num1==2) {              //�޸Ĳ�����Ϣ
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
