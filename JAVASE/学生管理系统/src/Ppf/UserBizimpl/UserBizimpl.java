package Ppf.UserBizimpl;

import java.util.Scanner;

import Ppf.Exception.LoginException;
import Ppf.Exception.RegisterExpetion;
import Ppf.UesrView.UserView;
import Ppf.UserBiz.UserBiz;
import Ppf.UserViewimpl.UserViewimpl;
import Ppf.pojo.Admin;
import Ppf.pojo.Student;

public class UserBizimpl implements UserBiz {
	Admin[] admins=new Admin[10];   
	
	public void register(String username, String password) throws RegisterExpetion{};  
	//�û�ע��
	
	
	
	public void login(String username, String password) throws LoginException{
		
		 Admin admin1= new Admin("zs","admin");
		 Admin admin2= new Admin("ls","admin");
		admins[0]=admin1;
		admins[1]=admin2;
		for(int i=0;i<admins.length;i++) {
			Admin admin=admins[i];
			if(admin==null) {          //��ֹ��ָ�����
				continue;
		}
			String _username=admin.getUsername();
			String _password=admin.getPassword();
			if(username.equals(_username)&&(password.equals(_password))) {
				System.out.println("��ӭ��"+username+"����");
				break;
				}else {
					throw new LoginException("�û��������벻ƥ��");
				
			}
			//finally {login(username,password);}
			}
		
	  }   //�û���¼
		public void add(Student students[]) {
			UserView uv=new UserViewimpl();
			
			
			Scanner s1 = new Scanner(System.in);
			System.out.println("������id");
	        int id = s1.nextInt();
			
			
			System.out.println("������ѧ������");
	        String name = s1.next();
			
			
			System.out.println("������ѧ���Ա�");
	        String sex = s1.next();
			
			System.out.println("������ѧ������");
	        int age = s1.nextInt();
			
			            
			System.out.println("������ѧ���꼶");
	        String _class = s1.next();
			
			System.out.println("������ѧ����ַ");
	        String address = s1.next();
			
			
			System.out.println("������ѧ���绰");
	        int phone = s1.nextInt();
			
			
			System.out.println("������ѧ������");
	        String email = s1.next();
	        Student s=new Student(id,name,sex,age,_class,address,phone,email);
	        
	        
	        for(int i=0;i<students.length;i++) {
	        	if(students[i]==null) {
	        		students[i]=s;
	        		break;
	        	}
	        }
	        
	        
	        System.out.println("���ݱ���ɹ���ϵͳ���Զ�����~");
	        uv.see();
		}
		public void look(Student students[]) {
			for(int i=0;i<students.length;i++) {
				if(students[i]==null) {
					continue;
				}
				if(students[i]!=null){
					System.out.println("id��"+students[i].getId()+"          |����:"+students[i].getName()+"          |�Ա�:"+students[i].getSex()+"          |�༶:"+students[i].get_class()+"          |��ַ:"
				+students[i].getAddress()+"          |�绰:"+students[i].getPhone()+"          |�ʼ�:"+students[i].getEmail());
								
				}
				
			}
			
		}
		public void delect() {
			
		}
		public void correct(Student[] students) {
			System.out.println("������Ҫ�޸ĵ�id");
			Scanner m=new Scanner(System.in);
			int m1=m.nextInt();
			boolean a=false;   //�ж�
			for(int i=0;i<students.length;i++) {
				if(students[i].getId()==m1) {
					Scanner s1 = new Scanner(System.in);
					System.out.println("������Ҫ�޸ĵ�id");
			        int id = s1.nextInt();
			        students[i].setId(id);
					
					System.out.println("������Ҫ�޸�ѧ������");
			        String name = s1.next();
			        students[i].setName(name);
					
					System.out.println("������Ҫ�޸�ѧ���Ա�");
			        String sex = s1.next();
					students[i].setSex(sex);
					System.out.println("������Ҫ�޸�ѧ������");
			        int age = s1.nextInt();
			        students[i].setAge(age);
					            
					System.out.println("������Ҫ�޸�ѧ���꼶");
			        String _class = s1.next();
			        students[i].set_class(_class);
					System.out.println("������Ҫ�޸�ѧ����ַ");
			        String address = s1.next();
			        students[i].setAddress(address);
					
					System.out.println("������Ҫ�޸�ѧ���绰");
			        int phone = s1.nextInt();
			        students[i].setPhone(phone);
					
					System.out.println("������Ҫ�޸�ѧ������");
			        String email = s1.next();
			        students[i].setEmail(email);
			        System.out.println("�޸ĳɹ�");
			        break;
				}else {
					a=true;
				}
			}
			if(a==true) {
				System.out.println("������ĵ�id����");
				correct(students);
			}
			
		}
	
	
	
	
	
	
	
	
	
	
	
}
