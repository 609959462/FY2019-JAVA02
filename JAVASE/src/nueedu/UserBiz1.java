package nueedu;

public class UserBiz1 implements UserBiz {
	 public void login(String username, String password) throws LoginException{
		 for(int i=0;i<a.length;i++) {
			 if(username.equals(a[i].username)) {
				 throw new LoginException("�˺Ų�����");}
				 else if(username.equals(a[i].username)&&password.equals(a[i].password)) {
					 throw new LoginException("�˺����벻ƥ��");
				 }
		
			 }
		 }
		public void register(String username, String password, String password2,String name,
				String email) throws RegisterException{ 
				for(int i=0;i<a.length;i++) {
				if((username.equals(a[i].username))){
					throw new RegisterException("�˺��Ѿ�����");}
				else if(password.equals(a[i].password)&&password2.equals(a[i].password)) {
					throw new RegisterException("�������벻һ��");	
					}
				
			}
		};                    

}
