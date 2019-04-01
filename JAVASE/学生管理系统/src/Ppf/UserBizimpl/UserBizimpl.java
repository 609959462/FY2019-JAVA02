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
	 private Admin[] admins=new Admin[10];   
	static UserView uv=new UserViewimpl();      //�����ջ���
	public void register(String username, String password) throws RegisterExpetion{};  
	//�û�ע��
	public  UserBizimpl() {
		 Admin admin1= new Admin("zs","admin");
		 Admin admin2= new Admin("ls","admin");
		 Admin admin3= new Admin("ww","admin");
		admins[0]=admin1;
		admins[1]=admin2;
		admins[2]=admin3;
		}
	
	
	public void login(String username, String password) throws LoginException{
		
		boolean usernameexists=false;
		for(int i=0;i<admins.length;i++) {
			Admin admin=admins[i];
			if(admin==null) {          //��ֹ��ָ�����
				continue;
		}
			usernameexists=true;
			String _username=admin.getUsername();   //ϵͳ�е�(��Ϊadmin��private�ģ�ֻ��get�õ�)
			String _password=admin.getPassword(); 
			if(username.equals(_username)) {          //username���û������
				usernameexists=true;
				if(password.equals(_password)) {//��¼�ɹ�
					System.out.println("��¼�ɹ�!!!");
					System.out.println("��ӭ��"+username+"����");
				}else {//username ��password ��ƥ��
					throw new LoginException("�û��������벻ƥ��"); 
				}
				}
			}	
		}
	public boolean isusernameexists(String username) throws LoginException {
		// TODO Auto-generated method stub	
		for(int i=0;i<admins.length;i++) {			
			Admin admin=admins[i]; 
			if(admin==null) {				
				continue;
				}			
			String _username=admins[i].getUsername();
			if(_username.equals(username)) {        //�û�������
				
			   return true;
			}
			
		}
		
		 throw new LoginException("�û���������");
		
	}
			
		
	     //�û���¼
		public void add(Student[] students) {
			
			
		
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
	        		students[i]=s;                //����Ϊ�վ����s ��i.
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
			uv.see();

		}
		public void delect(Student[] students) {
			System.out.println("������Ҫɾ����ѧ��id");
			Scanner m=new Scanner(System.in);
			int m1=m.nextInt();
			for(int i=0;i<students.length-1;i++) {
				if(students[i]==null) {
					continue;
				}
				if(students[i].getId()==m1) {
					students[i]=null;
					
				}
				
				
			}
			System.out.println("ɾ���ɹ�");
			uv.see();
		}
		public void correct(Student[] students) {
			System.out.println("������Ҫ�޸ĵ�id");
			Scanner m=new Scanner(System.in);
			int m1=m.nextInt();
			boolean a=false;   //�ж������id�治���ڣ���Ҫ����������ж���û�У���ô����Ӹ�boolean������ѭ�������粻����m1��a=true����
			for(int i=0;i<students.length;i++) {
				if(students[i]==null) {
					continue;
				}
				if(students[i].getId()==m1) {
					a=false;                 //ÿ�ζ�Ҫ��֤��Ϊfalse
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
		public void correctPart(Student[] students) {    //�޸Ĳ�����Ϣ
			System.out.print("������Ҫ�޸ĵ�id");
			Scanner s=new Scanner(System.in);
			int id = s.nextInt();
			
			for(int i=0;i<students.length;i++) {
				if(students[i]==null) {               
					continue;
				}
				if(students[i].getId()==id) {
					System.out.print("������Ҫ�޸ĵ���Ϣ");
					Scanner m=new Scanner(System.in);
					String inf = m.next();		
					System.out.print("�������޸ĺ����Ϣ");
					for(int j=0;j<students.length;j++) {
						if(inf.equals("id")) {
							Scanner n=new Scanner(System.in);
							int n1=n.nextInt();
							students[j].setId(n1);
							System.out.print("�޸����~�Զ������ϼ��˵�");
							uv.see();
						}
						
					}
				}
			}
		}
		@Override
		public void delect() {
			
		}
	
	
	
	
	
	
	
	
	
	
}
