package Ppf.UserViewimpl;  //���𽻻����ռ���Ϣ
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

public class UserViewimpl implements UserView {   //��½
	private static UserViewimpl userViewimpl;
	private UserViewimpl(){
		Students.add(new Student(1,"����","��",25,"�߼�","��ɽ",131545105,"609959462@qq.com",99,System.currentTimeMillis()));				
	}
	public synchronized static UserViewimpl getInstance(){        //����ģʽ
		if(userViewimpl==null){
			userViewimpl=new UserViewimpl();
		}
		return userViewimpl;
	}
	
	
	
	
	UserBiz user=new UserBizimpl();
	//static Student students[]=new Student[10];
	
//	{Student ss1=new Student(1,"����","��",25,"�߼�","��ɽ",131545105,"609959462@qq.com",99);
//    students[0]=ss1;}                      //��д�ڷ�������Ҫ�Ӵ����ţ���ʼ������
	 List<Student> Students=new ArrayList<Student>();

//	public UserViewimpl() {
//		Students.add(new Student(1,"����","��",25,"�߼�","��ɽ",131545105,"609959462@qq.com",99,System.currentTimeMillis()));		
//	}
//	
	public void login() throws LoginException {
		UserBiz userBiz=new UserBizimpl();
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		System.out.println("��ӭ��½!");
		System.out.println("�������û���");
		String username=s.next();
		boolean usernameexists=userBiz.isusernameexists(username);        //���Ҫ�����ж��Ƿ��û����ظ�
		if(usernameexists) {                          			
			String str="ABCDEFGHIJKLMNOPQRSTUVWXYZqwertyuiopadsfghjklzxcvbnm0123456789";    //��֤��
			String yanzheng=new String();     //�ж���֤��
	        for(int i1=0;i1<4;i1++)                                        
	        {
	            char ch=str.charAt(new Random().nextInt(str.length()));
	            yanzheng+=ch;                   //��֤��ƴ��
	        }
	          
	        System.out.println(yanzheng);
	        System.out.print("��������֤��:");                 //��ȡ��֤��
	        String uuid=s.next(); 
	        
	        System.out.println("����������:");
			String password=s.next();              //�������û���������ȡ��Ϣ
			userBiz.login(username,yanzheng,uuid,password);     //����ʹ����Ϣ��Biz������BIZ��ҵ���߼��㣩��ͬʱ������������쳣�ģ�����
		}
	
		//user.login(username,password);	
	}
	public void see() {
		System.out.println("**********ѡ��Ҫ��������Ϣ��Ӧ������**********");
		System.out.println("*1.�鿴ѧ����Ϣ   *2.���ѧ����Ϣ  *3.ɾ��ѧ����Ϣ  *4.�޸�ѧ����Ϣ    *5�˳�      *6.���ַ�����");
		Scanner s =new Scanner(System.in);
		int num=s.nextInt();
		if(num==1) {user.look(Students);}
		if(num==2) {user.add(Students);
	}
		if(num==3) {user.delect(Students);}
		if(num==4) {
			System.out.println("*1.����id�޸�ѧ��ȫ����Ϣ  *2.����id�޸�ѧ��������Ϣ *3.�����ϼ�Ŀ¼   *4ϵͳ�˳�");
			Scanner s1 =new Scanner(System.in);
			int num1=s1.nextInt();
			if(num1==1) {
				user.correct(Students);        //�޸�ȫ����Ϣ
				see();
			}
			if(num1==2) {              //�޸Ĳ�����Ϣ
				user.correctPart(Students);
			}
			}
		if(num==5) {
			System.exit(0);
		}
		if(num==6) {
			//���ַ�����ѧ���ɼ�
			//user.two(Students);
			System.out.println("������Ҫ���ҵ�ѧ���ɼ�");
			Scanner s2=new Scanner(System.in);
			int num2=s2.nextInt();
			int x=user.two(Students,num2);
			//for(int i=0;i<Students.size();i++) {
			if(x!=-1) {
				System.out.println("�鵽:"+Students.get(x).getName());
			}else {
				System.out.println("û�鵽");
			}
		}
		}
	//}
	
	
//	public String toString(){
//		
//		return "id��"+Students.this.getId()+"          |����:"+Students.get(i).getName()+"          |�Ա�:"+Students.get(i).getSex()+"          |�༶:"+Students.get(i).get_class()+"          |��ַ:"
//				+Students.get(i).getAddress()+"          |�绰:"+Students.get(i).getPhone()+"          |�ʼ�:"+Students.get(i).getEmail()+"          |�ɼ�:"+Students.get(i).getScores()+"          |ע��ʱ��:"+_date 				
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
