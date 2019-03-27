package Ppf.serviceimpl;

import Ppf.Exception.LoginException;
import Ppf.Exception.RegisterException;
import Ppf.pojo.User;
import Ppf.service.UserBiz;

public class UserBizimpl implements UserBiz {          //实现接口
	private User[] users=new User[10];   
	public  UserBizimpl() {                             //在构造函数里初始化，调用的时候直接就初始化了
		     
		User user1=new User("admin","admin","Administrator","admin@123.com");
	
		User user2=new User("tom","cat","tomcat","tomcat@123.com");
		users[0]=user1;
		users[1]=user2;
		
	}		
	public void login(String username, String password)throws LoginException {
			boolean usernameexists=false;       //默认用户名不存在（为了满足题干的要求，用户不存在的时候）	
			for(int i=0;i<users.length;i++) {
				User user=users[i];
				if(user==null) {          //防止空指针出现
					continue;
			}  		
					String _username=user.getUsername();
					String _password=user.getPassword();
					if(username.equals(_username)){
						 {	
							 	usernameexists=true;   //用户名存在
								if(password.equals(_password)) {//登录成功
									System.out.println("登录成功!!!");
								}else {//username 和password 不匹配
									throw new LoginException("用户名与密码不匹配"); 
								}
							}}
					}
	}
	
	public boolean isusernameexists(String username) throws LoginException {
		// TODO Auto-generated method stub	
	for(int i=0;i<users.length;i++) {
			
			User user=users[i];
			if(user==null) {
				continue;
			}
			
			String _username=user.getUsername();
			
			if(_username.equals(username)) {//用户名存在
				
			   return true;
			}
			
		}
		
		 throw new LoginException("用户名不存在");
		
	}
	
	public void register(String username, String password, String password2,
				String name, String email) throws RegisterException{
		for(int i=0;i<users.length;i++) {
			User user=users[i];
			if(user==null) {
				continue;
			}
			String _username=user.getUsername();
			if(_username.equals(username)) {
				 throw new RegisterException("用户名已经存在");
			}
		}
	 }
}
