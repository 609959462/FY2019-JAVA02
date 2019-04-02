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
   //static UserView uv=new UserViewimpl();      //处理堆栈溢出
	
	 List<Admin> admins=new ArrayList<Admin>();   //定义集合
	public  UserBizimpl(){
	
		
	admins.add(new Admin("zs","admin"));         //添加元素
 	admins.add(new Admin("ls","admin"));
	}
public void login(String username, String password) throws LoginException{
			
		boolean usernameexists=false;
		for(int i=0;i<admins.size();i++) {
		
			//if(admins==null) {          //防止空指针出现
				//continue;
		//}
			usernameexists=true;
			String _username=admins.get(i).getUsername();   //系统中的(因为admin是private的，只能get得到)
			String _password=admins.get(i).getPassword(); 
			if(username.equalsIgnoreCase(_username)) {          //username是用户传入的
				                                                //equalsIgnoreCase不区分大小写
				
				
				
				usernameexists=true;
				if(password.equalsIgnoreCase(_password)) {//登录成功
					System.out.println("登录成功!!!");
					System.out.println("欢迎您"+username+"先生");
				}else {//username 和password 不匹配
					throw new LoginException("用户名与密码不匹配"); 
					
				}
				}
			}	
		}
	
	
	
	
	
	
//	 private Admin[] admins=new Admin[10];   
//	static UserView uv=new UserViewimpl();      //处理堆栈溢出
//	public void register(String username, String password) throws RegisterExpetion{};  
//	//用户注册
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
//			if(admins==null) {          //防止空指针出现
//				continue;
//		}
//			usernameexists=true;
//			String _username=admin.getUsername();   //系统中的(因为admin是private的，只能get得到)
//			String _password=admin.getPassword(); 
//			if(username.equals(_username)) {          //username是用户传入的
//				usernameexists=true;
//				if(password.equals(_password)) {//登录成功
//					System.out.println("登录成功!!!");
//					System.out.println("欢迎您"+username+"先生");
//				}else {//username 和password 不匹配
//					throw new LoginException("用户名与密码不匹配"); 
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
			if(_username.equalsIgnoreCase(username)) {        //用户名存在   不区分大小写
				
			   return true;
			}
			
		}
		
		 throw new LoginException("用户名不存在");
		
	}
			
		
	     //用户登录
		public void add(List<Student> Students) {
			
			
		
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
	        
	        System.out.println("请输入学生的成绩");
	        int scores=s1.nextInt();
	        
	       long Date=System.currentTimeMillis();	        
	        Student s=new Student(id,name,sex,age,_class,address,phone,email,scores,Date);   //加上时间
//	        Date date =new Date(System.currentTimeMillis());
//	        SimpleDateFormat format =new SimpleDateFormat(yyyy-MM-dd HH:mm:ss);
//	        String _date=format.format(date);
//	        System.out.println(_date);

	        for(int i=0;i<Students.size();i++) {
	        	
	        		//Students[i]=s;                //数组为空就添加s 给i.
	        		Students.add(s);
	        		break;
	        }
	        
	        
	        System.out.println("数据保存成功，系统将自动返回~");
	        UserViewimpl.getInstance().see();
		}
		public void look(List<Student> Students) {
			Collections.sort(Students);
			for(int i=0;i<Students.size();i++) {
				Date date =new Date(Students.get(i).getDate());              //把student的时间给了
		        SimpleDateFormat format =new SimpleDateFormat("yy-MM-dd HH:mm:ss");     //调整格式
		        String _date=format.format(date);                                   //赋值
		       
				if(Students.get(i)!=null){
				
					System.out.println("id："+Students.get(i).getId()+"          |姓名:"+Students.get(i).getName()+"          |性别:"+Students.get(i).getSex()+"          |班级:"+Students.get(i).get_class()+"          |地址:"
				+Students.get(i).getAddress()+"          |电话:"+Students.get(i).getPhone()+"          |邮件:"+Students.get(i).getEmail()+"          |成绩:"+Students.get(i).getScores()+"          |注册时间:"+_date);
								
				}
			}
			UserViewimpl.getInstance().see();
			
		}
		public void delect(List<Student> Students) {
			System.out.println("请输入要删除的学生id");
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
			System.out.println("删除成功");
			UserViewimpl.getInstance().see();
		}
		public void correct(List<Student> Students) {
			System.out.println("请输入要修改的id");
			Scanner m=new Scanner(System.in);
			int m1=m.nextInt();
			boolean a=false;   //判断输入的id存不存在（你要遍历完才能判断有没有，那么就添加个boolean，进入循环，假如不等于m1，a=true，）
			for(int i=0;i<Students.size();i++) {
				if(Students.get(i)==null) {
					continue;
				}
				if(Students.get(i).getId()==m1) {
					a=false;                 //每次都要保证它为false
					Scanner s1 = new Scanner(System.in);
					System.out.println("请输入要修改的id");
			        int id = s1.nextInt();
			        Students.get(i).setId(id);
					
					System.out.println("请输入要修改学生姓名");
			        String name = s1.next();
			        Students.get(i).setName(name);
					
					System.out.println("请输入要修改学生性别");
			        String sex = s1.next();
			        Students.get(i).setSex(sex);
					System.out.println("请输入要修改学生年龄");
			        int age = s1.nextInt();
			        Students.get(i).setAge(age);
					            
					System.out.println("请输入要修改学生年级");
			        String _class = s1.next();
			        Students.get(i).set_class(_class);
					System.out.println("请输入要修改学生地址");
			        String address = s1.next();
			        Students.get(i).setAddress(address);
					
					System.out.println("请输入要修改学生电话");
			        int phone = s1.nextInt();
			        Students.get(i).setPhone(phone);
					
					System.out.println("请输入要修改学生邮箱");
			        String email = s1.next();
			        Students.get(i).setEmail(email);			        			     
			        System.out.println("修改成功");
			        break;
				}else {
					a=true;
				}
			}
			if(a==true) {
				System.out.println("您输入的的id有误");
				correct(Students);
			}
			
		}
		public void correctPart(List<Student> Students) {    //修改部分信息
			System.out.print("请输入要修改的id");
			Scanner s=new Scanner(System.in);
			int id = s.nextInt();
			
			for(int i=0;i<Students.size();i++) {
				if(Students.get(i)==null) {               
					continue;
				}
				if(Students.get(i).getId()==id) {
					System.out.print("请输入要修改的信息");
					Scanner m=new Scanner(System.in);
					String inf = m.next();		
					System.out.print("请输入修改后的信息");
					for(int j=0;j<Students.size();j++) {
						if(inf.equals("id")) {
							Scanner n=new Scanner(System.in);
							int n1=n.nextInt();
							Students.get(j).setId(n1);
							System.out.print("修改完成~自动返回上级菜单");
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
