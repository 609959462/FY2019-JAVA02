package Ppf.UserBizimpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import Ppf.Exception.LoginException;
import Ppf.Exception.RegisterExpetion;
import Ppf.UesrView.UserView;
import Ppf.UserBiz.UserBiz;
import Ppf.UserViewimpl.UserViewimpl;
import Ppf.pojo.Admin;
import Ppf.pojo.Student;


public class UserBizimpl implements UserBiz {
	//UserViewimpl u1=UserViewimpl.getInstance();
   //static UserView uv=new UserViewimpl();      //�����ջ���
	
	 List<Admin> admins=new ArrayList<Admin>();   //���弯��
	public  UserBizimpl(){
	
		
	admins.add(new Admin("zs","admin"));         //���Ԫ��
 	admins.add(new Admin("ls","admin"));
	}
public void login(String username, String password) throws LoginException{
			
		boolean usernameexists=false;
		for(int i=0;i<admins.size();i++) {
		
			//if(admins==null) {          //��ֹ��ָ�����
				//continue;
		//}
			usernameexists=true;
			String _username=admins.get(i).getUsername();   //ϵͳ�е�(��Ϊadmin��private�ģ�ֻ��get�õ�)
			String _password=admins.get(i).getPassword(); 
			if(username.equalsIgnoreCase(_username)) {          //username���û������
				                                                //equalsIgnoreCase�����ִ�Сд
				
				
				
				usernameexists=true;
				if(password.equalsIgnoreCase(_password)) {//��¼�ɹ�
					System.out.println("��¼�ɹ�!!!");
					System.out.println("��ӭ��"+username+"����");
				}else {//username ��password ��ƥ��
					throw new LoginException("�û��������벻ƥ��"); 
					
				}
				}
			}	
		}
	
	
	
	
	
	
//	 private Admin[] admins=new Admin[10];   
//	static UserView uv=new UserViewimpl();      //�����ջ���
//	public void register(String username, String password) throws RegisterExpetion{};  
//	//�û�ע��
//	public  UserBizimpl() {
//		 Admin admin1= new Admin("zs","admin");
//		 Admin admin2= new Admin("ls","admin");
//		 Admin admin3= new Admin("ww","admin");
//		admins[0]=admin1;
//		admins[1]=admin2;
//		admins[2]=admin3;
//		}
	
	
//	public void login(String username, String password) throws LoginException{
//		
//		boolean usernameexists=false;
//		for(int i=0;i<admins.size();i++) {
//		
//			if(admins==null) {          //��ֹ��ָ�����
//				continue;
//		}
//			usernameexists=true;
//			String _username=admin.getUsername();   //ϵͳ�е�(��Ϊadmin��private�ģ�ֻ��get�õ�)
//			String _password=admin.getPassword(); 
//			if(username.equals(_username)) {          //username���û������
//				usernameexists=true;
//				if(password.equals(_password)) {//��¼�ɹ�
//					System.out.println("��¼�ɹ�!!!");
//					System.out.println("��ӭ��"+username+"����");
//				}else {//username ��password ��ƥ��
//					throw new LoginException("�û��������벻ƥ��"); 
//					
//				}
//				}
//			}	
//		}
	public boolean isusernameexists(String username) throws LoginException {
		// TODO Auto-generated method stub	
		for(int i=0;i<admins.size();i++) {			
			Admin admin=admins.get(i); 
//			if(admin==null) {				
//				continue;
//				}			
			String _username=admins.get(i).getUsername();
			if(_username.equalsIgnoreCase(username)) {        //�û�������   �����ִ�Сд
				
			   return true;
			}
			
		}
		
		 throw new LoginException("�û���������");
		
	}
			
		
	     //�û���¼
		public void add(List<Student> Students) {
			
			
		
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
	        
	        System.out.println("������ѧ���ĳɼ�");
	        int scores=s1.nextInt();
	        
	       long Date=System.currentTimeMillis();	        
	        Student s=new Student(id,name,sex,age,_class,address,phone,email,scores,Date);   //����ʱ��
//	        Date date =new Date(System.currentTimeMillis());
//	        SimpleDateFormat format =new SimpleDateFormat(yyyy-MM-dd HH:mm:ss);
//	        String _date=format.format(date);
//	        System.out.println(_date);

	        for(int i=0;i<Students.size();i++) {
	        	
	        		//Students[i]=s;                //����Ϊ�վ����s ��i.
	        		Students.add(s);
	        		break;
	        }
	        
	        
	        System.out.println("���ݱ���ɹ���ϵͳ���Զ�����~");
	        UserViewimpl.getInstance().see();
		}
		public void look(List<Student> Students) {
			Collections.sort(Students);
			for(int i=0;i<Students.size();i++) {
				Date date =new Date(Students.get(i).getDate());              //��student��ʱ�����
		        SimpleDateFormat format =new SimpleDateFormat("yy-MM-dd HH:mm:ss");     //������ʽ
		        String _date=format.format(date);                                   //��ֵ
		       
				if(Students.get(i)!=null){
				
					System.out.println("id��"+Students.get(i).getId()+"          |����:"+Students.get(i).getName()+"          |�Ա�:"+Students.get(i).getSex()+"          |�༶:"+Students.get(i).get_class()+"          |��ַ:"
				+Students.get(i).getAddress()+"          |�绰:"+Students.get(i).getPhone()+"          |�ʼ�:"+Students.get(i).getEmail()+"          |�ɼ�:"+Students.get(i).getScores()+"          |ע��ʱ��:"+_date);
								
				}
			}
			UserViewimpl.getInstance().see();
			
		}
		public void delect(List<Student> Students) {
			System.out.println("������Ҫɾ����ѧ��id");
			Scanner m=new Scanner(System.in);
			int m1=m.nextInt();
			for(int i=0;i<Students.size();i++) {
				if(Students.get(i)==null) {
					continue;
				}
				if(Students.get(i).getId()==m1) {
					Students.remove(Students.get(i));
					
				}
				
				
			}
			System.out.println("ɾ���ɹ�");
			UserViewimpl.getInstance().see();
		}
		public void correct(List<Student> Students) {
			System.out.println("������Ҫ�޸ĵ�id");
			Scanner m=new Scanner(System.in);
			int m1=m.nextInt();
			boolean a=false;   //�ж������id�治���ڣ���Ҫ����������ж���û�У���ô����Ӹ�boolean������ѭ�������粻����m1��a=true����
			for(int i=0;i<Students.size();i++) {
				if(Students.get(i)==null) {
					continue;
				}
				if(Students.get(i).getId()==m1) {
					a=false;                 //ÿ�ζ�Ҫ��֤��Ϊfalse
					Scanner s1 = new Scanner(System.in);
					System.out.println("������Ҫ�޸ĵ�id");
			        int id = s1.nextInt();
			        Students.get(i).setId(id);
					
					System.out.println("������Ҫ�޸�ѧ������");
			        String name = s1.next();
			        Students.get(i).setName(name);
					
					System.out.println("������Ҫ�޸�ѧ���Ա�");
			        String sex = s1.next();
			        Students.get(i).setSex(sex);
					System.out.println("������Ҫ�޸�ѧ������");
			        int age = s1.nextInt();
			        Students.get(i).setAge(age);
					            
					System.out.println("������Ҫ�޸�ѧ���꼶");
			        String _class = s1.next();
			        Students.get(i).set_class(_class);
					System.out.println("������Ҫ�޸�ѧ����ַ");
			        String address = s1.next();
			        Students.get(i).setAddress(address);
					
					System.out.println("������Ҫ�޸�ѧ���绰");
			        int phone = s1.nextInt();
			        Students.get(i).setPhone(phone);
					
					System.out.println("������Ҫ�޸�ѧ������");
			        String email = s1.next();
			        Students.get(i).setEmail(email);			        			     
			        System.out.println("�޸ĳɹ�");
			        break;
				}else {
					a=true;
				}
			}
			if(a==true) {
				System.out.println("������ĵ�id����");
				correct(Students);
			}
			
		}
		public void correctPart(List<Student> Students) {    //�޸Ĳ�����Ϣ
			System.out.print("������Ҫ�޸ĵ�id");
			Scanner s=new Scanner(System.in);
			int id = s.nextInt();
			
			for(int i=0;i<Students.size();i++) {
				if(Students.get(i)==null) {               
					continue;
				}
				if(Students.get(i).getId()==id) {
					System.out.print("������Ҫ�޸ĵ���Ϣ");
					Scanner m=new Scanner(System.in);
					String inf = m.next();		
					System.out.print("�������޸ĺ����Ϣ");
					for(int j=0;j<Students.size();j++) {
						if(inf.equals("id")) {
							Scanner n=new Scanner(System.in);
							int n1=n.nextInt();
							Students.get(j).setId(n1);
							System.out.print("�޸����~�Զ������ϼ��˵�");
							UserViewimpl.getInstance().see();
						}
						
					}
				}
			}
		}
		@Override
		public void delect() {
			
		}
		@Override
		public void register(String username, String password) throws RegisterExpetion {
			// TODO Auto-generated method stub
			
		}
		
		
	
	
	
	
	
	
	
	
	
	
}
