package nueedu;
import java.util.Scanner; 

public class UserView1 implements UserView {
	
		public // TODO Auto-generated method stub
		  void login(){   
				  Scanner s=new Scanner(System.in);
				  System.out.println("�������˺�");
				  String username=s.next();
				  System.out.println("����������");
				  String password=s.next();
				  UserBiz1 u=new UserBiz1();
				  try {
					u.login(username,password);
				} catch (LoginException e) {
					 for(int i=0;i<a.length;i++) {
						 if(username.equals(a[i].username)) {
							 throw new LoginException("�˺Ų�����");}
							 else if(username.equals(a[i].username)&&password.equals(a[i].password)) {
								 throw new LoginException("�˺����벻ƥ��");
							 }
					
						 }
					
				}
		  }
		  public void register(){
			  Scanner s=new Scanner(System.in);
			  System.out.println("�������û���");
			  String username=s.next();
			  System.out.println("����������");
			  String password=s.next();
			  System.out.println("��ȷ������");
			  String password2=s.next();
			  System.out.println("��������ʵ����");
			  String name=s.next();
			  System.out.println("�������������ַ");
			  String email=s.next();
			  User u=new User();
			  try {
				u.register(username,password,password2,name,email);
			} catch (RegisterException e) {
				for(int i=0;i<a.length;i++) {
					if((username.equals(a[i].username))){
						throw new RegisterException("�˺��Ѿ�����");}
					else if(password.equals(a[i].password)&&password2.equals(a[i].password)) {
						throw new RegisterException("�������벻һ��");	
						}
					
				}
			}  
			  } 
	
		  }

