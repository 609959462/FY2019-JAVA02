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
	//用户注册
	
	
	
	public void login(String username, String password) throws LoginException{
		
		 Admin admin1= new Admin("zs","admin");
		 Admin admin2= new Admin("ls","admin");
		admins[0]=admin1;
		admins[1]=admin2;
		for(int i=0;i<admins.length;i++) {
			Admin admin=admins[i];
			if(admin==null) {          //防止空指针出现
				continue;
		}
			String _username=admin.getUsername();
			String _password=admin.getPassword();
			if(username.equals(_username)&&(password.equals(_password))) {
				System.out.println("欢迎您"+username+"先生");
				break;
				}else {
					throw new LoginException("用户名与密码不匹配");
				
			}
			//finally {login(username,password);}
			}
		
	  }   //用户登录
		public void add(Student students[]) {
			UserView uv=new UserViewimpl();
			
			
			Scanner s1 = new Scanner(System.in);
			System.out.println("请输入id");
	        int id = s1.nextInt();
			
			
			System.out.println("请输入学生姓名");
	        String name = s1.next();
			
			
			System.out.println("请输入学生性别");
	        String sex = s1.next();
			
			System.out.println("请输入学生年龄");
	        int age = s1.nextInt();
			
			            
			System.out.println("请输入学生年级");
	        String _class = s1.next();
			
			System.out.println("请输入学生地址");
	        String address = s1.next();
			
			
			System.out.println("请输入学生电话");
	        int phone = s1.nextInt();
			
			
			System.out.println("请输入学生邮箱");
	        String email = s1.next();
	        Student s=new Student(id,name,sex,age,_class,address,phone,email);
	        
	        
	        for(int i=0;i<students.length;i++) {
	        	if(students[i]==null) {
	        		students[i]=s;
	        		break;
	        	}
	        }
	        
	        
	        System.out.println("数据保存成功，系统将自动返回~");
	        uv.see();
		}
		public void look(Student students[]) {
			for(int i=0;i<students.length;i++) {
				if(students[i]==null) {
					continue;
				}
				if(students[i]!=null){
					System.out.println("id："+students[i].getId()+"          |姓名:"+students[i].getName()+"          |性别:"+students[i].getSex()+"          |班级:"+students[i].get_class()+"          |地址:"
				+students[i].getAddress()+"          |电话:"+students[i].getPhone()+"          |邮件:"+students[i].getEmail());
								
				}
				
			}
			
		}
		public void delect() {
			
		}
		public void correct(Student[] students) {
			System.out.println("请输入要修改的id");
			Scanner m=new Scanner(System.in);
			int m1=m.nextInt();
			boolean a=false;   //判断
			for(int i=0;i<students.length;i++) {
				if(students[i].getId()==m1) {
					Scanner s1 = new Scanner(System.in);
					System.out.println("请输入要修改的id");
			        int id = s1.nextInt();
			        students[i].setId(id);
					
					System.out.println("请输入要修改学生姓名");
			        String name = s1.next();
			        students[i].setName(name);
					
					System.out.println("请输入要修改学生性别");
			        String sex = s1.next();
					students[i].setSex(sex);
					System.out.println("请输入要修改学生年龄");
			        int age = s1.nextInt();
			        students[i].setAge(age);
					            
					System.out.println("请输入要修改学生年级");
			        String _class = s1.next();
			        students[i].set_class(_class);
					System.out.println("请输入要修改学生地址");
			        String address = s1.next();
			        students[i].setAddress(address);
					
					System.out.println("请输入要修改学生电话");
			        int phone = s1.nextInt();
			        students[i].setPhone(phone);
					
					System.out.println("请输入要修改学生邮箱");
			        String email = s1.next();
			        students[i].setEmail(email);
			        System.out.println("修改成功");
			        break;
				}else {
					a=true;
				}
			}
			if(a==true) {
				System.out.println("您输入的的id有误");
				correct(students);
			}
			
		}
	
	
	
	
	
	
	
	
	
	
	
}
