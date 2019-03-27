package nueedu;
import java.util.Scanner; 

public class UserView1 implements UserView {
	
		public // TODO Auto-generated method stub
		  void login(){   
				  Scanner s=new Scanner(System.in);
				  System.out.println("请输入账号");
				  String username=s.next();
				  System.out.println("请输入密码");
				  String password=s.next();
				  UserBiz1 u=new UserBiz1();
				  try {
					u.login(username,password);
				} catch (LoginException e) {
					 for(int i=0;i<a.length;i++) {
						 if(username.equals(a[i].username)) {
							 throw new LoginException("账号不存在");}
							 else if(username.equals(a[i].username)&&password.equals(a[i].password)) {
								 throw new LoginException("账号密码不匹配");
							 }
					
						 }
					
				}
		  }
		  public void register(){
			  Scanner s=new Scanner(System.in);
			  System.out.println("请输入用户名");
			  String username=s.next();
			  System.out.println("请输入密码");
			  String password=s.next();
			  System.out.println("请确认密码");
			  String password2=s.next();
			  System.out.println("请输入真实姓名");
			  String name=s.next();
			  System.out.println("请读入电子邮箱地址");
			  String email=s.next();
			  User u=new User();
			  try {
				u.register(username,password,password2,name,email);
			} catch (RegisterException e) {
				for(int i=0;i<a.length;i++) {
					if((username.equals(a[i].username))){
						throw new RegisterException("账号已经存在");}
					else if(password.equals(a[i].password)&&password2.equals(a[i].password)) {
						throw new RegisterException("两次密码不一致");	
						}
					
				}
			}  
			  } 
	
		  }

