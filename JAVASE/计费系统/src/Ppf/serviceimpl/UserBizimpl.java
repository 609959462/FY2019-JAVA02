package Ppf.serviceimpl;

import Ppf.Exception.LoginException;
import Ppf.Exception.RegisterException;
import Ppf.pojo.User;
import Ppf.service.UserBiz;

public class UserBizimpl implements UserBiz {          //ʵ�ֽӿ�
	private User[] users=new User[10];   
	public  UserBizimpl() {                             //�ڹ��캯�����ʼ�������õ�ʱ��ֱ�Ӿͳ�ʼ����
		     
		User user1=new User("admin","admin","Administrator","admin@123.com");
	
		User user2=new User("tom","cat","tomcat","tomcat@123.com");
		users[0]=user1;
		users[1]=user2;
		
	}		
	public void login(String username, String password)throws LoginException {
			boolean usernameexists=false;       //Ĭ���û��������ڣ�Ϊ��������ɵ�Ҫ���û������ڵ�ʱ��	
			for(int i=0;i<users.length;i++) {
				User user=users[i];
				if(user==null) {          //��ֹ��ָ�����
					continue;
			}  		
					String _username=user.getUsername();
					String _password=user.getPassword();
					if(username.equals(_username)){
						 {	
							 	usernameexists=true;   //�û�������
								if(password.equals(_password)) {//��¼�ɹ�
									System.out.println("��¼�ɹ�!!!");
								}else {//username ��password ��ƥ��
									throw new LoginException("�û��������벻ƥ��"); 
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
			
			if(_username.equals(username)) {//�û�������
				
			   return true;
			}
			
		}
		
		 throw new LoginException("�û���������");
		
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
				 throw new RegisterException("�û����Ѿ�����");
			}
		}
	 }
}
