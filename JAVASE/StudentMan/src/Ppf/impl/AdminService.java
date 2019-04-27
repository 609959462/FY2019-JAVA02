package Ppf.impl;

import java.util.ArrayList;
import java.util.List;

import Ppf.Mybatis.imp.LoginDao;
//import Ppf.Daoimpl.LoginDao;
import Ppf.common.Const;
import Ppf.common.ServerResponse;
import Ppf.dao.ILoginDao;
import Ppf.pojo.Admin;
import Ppf.service.IAdminService;

public class AdminService implements IAdminService {
		
//		static List<Admin> admins=new ArrayList<Admin>();   //定义集合
//		public  AdminService(){	
//		         //添加元素
//	 	admins.add(new Admin("ls","admin"));
//	 	admins.add(new Admin("zs","admin"));
//		}
	@SuppressWarnings("unchecked")
	@Override
	public ServerResponse login(String username, String password){
		//判断用户名空不空
		if(username==null||username.equals("")) {
			return ServerResponse.createServerResponseByFail(Const.USERNAME_NOT_NULL, "用户名不能为空");
		}
		
		if(password==null||password.equals("")) {
			return ServerResponse.createServerResponseByFail(Const.PASSWORD_NOT_NULL, "密码不能为空");
		}
		
		boolean isexist=LoginDao.getInstance().isuseernameexists(username);
		if(isexist) {
			Admin admin=LoginDao.getInstance().findAdminByusernameAndPasseord(username, password);
			if(admin!=null) {
				return ServerResponse.createServerResponseBySucess("登陆成功",admin);
			}else {
				return ServerResponse.createServerResponseByFail(Const.USERNAME_NOT_EXISTS, "密码错误");
			}
		}	
		
//		boolean isexistsusername=isusernameexists(username);                     //判断用户名存不存在
//		if(isexistsusername) {
//		for(int i=0;i<admins.size();i++) {				
//			String _username=admins.get(i).getUsername();   //系统中的(因为admin是private的，只能get得到)
//			String _password=admins.get(i).getPassword(); 	
//			
//			if(username.equalsIgnoreCase(_username)) {          //username是用户传入的									
//			
//				if(password.equalsIgnoreCase(_password)) {//登录成功
//					return ServerResponse.createServerResponseBySucess("success",admins.get(i));    //密码相等返回ServerResponse
//				}                            
//				else {	
//					return ServerResponse.createServerResponseByFail(Const.USERNAME_NOT_ERROR,"密码错误" );  
//				}
//				}					
//		}	
//}

	return ServerResponse.createServerResponseByFail(Const.PASSWORD_NOT_NULL,"用户名不存在");
	}	
//			public boolean isusernameexists(String username) {                               //判断用户名存不存在
//		// TODO Auto-generated method stub
//			for(int i=0;i<admins.size();i++) {
//			
//			Admin user=admins.get(i);
//			if(user==null) {
//				continue;
//			}			
//			String _username=user.getUsername();			
//			if(_username.equals(username)) {//用户名存在
//				
//			   return true;
//			}
//			 
//		}
//			 return  false;	
//	}	
		public ServerResponse regist(String username, String password) {
//		//添加管理员
//			Admin s=new Admin(username,password); 
//		
//			for(int i=0;i<admins.size();i++) {
//			
//			String _username=admins.get(i).getUsername();
//			if(username.equals(_username)) {
//				return ServerResponse.createServerResponseByFail(1,"id已存在");
//			}else {
//			  admins.add(s);
//			  System.out.println(admins.get(2).getUsername());  //检测是否添加cheng
//			  return  ServerResponse.createServerResponseBySucess("注册成功",admins);	
//			}
//      }
//			return ServerResponse.createServerResponseByFail(8,"请输入信息");
			return null;
		}
	
	
	
	
	
}