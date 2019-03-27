package nueedu;
//UserBiz接口
public interface UserBiz {
	 void register(String username, String password, String password2,String name,
			 String email) throws  RegisterException;                     //用户注册	 
	 void login(String username, String password) throws LoginException;  //用户登录
}
