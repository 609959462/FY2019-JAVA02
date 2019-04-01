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
	static UserView uv=new UserViewimpl();      //处理堆栈溢出
	public void register(String username, String password) throws RegisterExpetion{};  
	//用户注册
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
			if(admin==null) {          //防止空指针出现
				continue;
		}
			usernameexists=true;
			String _username=admin.getUsername();   //系统中的(因为admin是private的，只能get得到)
			String _password=admin.getPassword(); 
			if(username.equals(_username)) {          //username是用户传入的
				usernameexists=true;
				if(password.equals(_password)) {//登录成功
					System.out.println("登录成功!!!");
					System.out.println("欢迎您"+username+"先生");
				}else {//username 和password 不匹配
					throw new LoginException("用户名与密码不匹配"); 
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
			if(_username.equals(username)) {        //用户名存在
				
			   return true;
			}
			
		}
		
		 throw new LoginException("用户名不存在");
		
	}
			
		
	     //用户登录
		public void add(Student[] students) {
			
			
		
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
	        		students[i]=s;                //数组为空就添加s 给i.
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
			uv.see();

		}
		public void delect(Student[] students) {
			System.out.println("请输入要删除的学生id");
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
			System.out.println("删除成功");
			uv.see();
		}
		public void correct(Student[] students) {
			System.out.println("请输入要修改的id");
			Scanner m=new Scanner(System.in);
			int m1=m.nextInt();
			boolean a=false;   //判断输入的id存不存在（你要遍历完才能判断有没有，那么就添加个boolean，进入循环，假如不等于m1，a=true，）
			for(int i=0;i<students.length;i++) {
				if(students[i]==null) {
					continue;
				}
				if(students[i].getId()==m1) {
					a=false;                 //每次都要保证它为false
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
		public void correctPart(Student[] students) {    //修改部分信息
			System.out.print("请输入要修改的id");
			Scanner s=new Scanner(System.in);
			int id = s.nextInt();
			
			for(int i=0;i<students.length;i++) {
				if(students[i]==null) {               
					continue;
				}
				if(students[i].getId()==id) {
					System.out.print("请输入要修改的信息");
					Scanner m=new Scanner(System.in);
					String inf = m.next();		
					System.out.print("请输入修改后的信息");
					for(int j=0;j<students.length;j++) {
						if(inf.equals("id")) {
							Scanner n=new Scanner(System.in);
							int n1=n.nextInt();
							students[j].setId(n1);
							System.out.print("修改完成~自动返回上级菜单");
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
