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
		
//		static List<Admin> admins=new ArrayList<Admin>();   //���弯��
//		public  AdminService(){	
//		         //���Ԫ��
//	 	admins.add(new Admin("ls","admin"));
//	 	admins.add(new Admin("zs","admin"));
//		}
	@SuppressWarnings("unchecked")
	@Override
	public ServerResponse login(String username, String password){
		//�ж��û����ղ���
		if(username==null||username.equals("")) {
			return ServerResponse.createServerResponseByFail(Const.USERNAME_NOT_NULL, "�û�������Ϊ��");
		}
		
		if(password==null||password.equals("")) {
			return ServerResponse.createServerResponseByFail(Const.PASSWORD_NOT_NULL, "���벻��Ϊ��");
		}
		
		boolean isexist=LoginDao.getInstance().isuseernameexists(username);
		if(isexist) {
			Admin admin=LoginDao.getInstance().findAdminByusernameAndPasseord(username, password);
			if(admin!=null) {
				return ServerResponse.createServerResponseBySucess("��½�ɹ�",admin);
			}else {
				return ServerResponse.createServerResponseByFail(Const.USERNAME_NOT_EXISTS, "�������");
			}
		}	
		
//		boolean isexistsusername=isusernameexists(username);                     //�ж��û����治����
//		if(isexistsusername) {
//		for(int i=0;i<admins.size();i++) {				
//			String _username=admins.get(i).getUsername();   //ϵͳ�е�(��Ϊadmin��private�ģ�ֻ��get�õ�)
//			String _password=admins.get(i).getPassword(); 	
//			
//			if(username.equalsIgnoreCase(_username)) {          //username���û������									
//			
//				if(password.equalsIgnoreCase(_password)) {//��¼�ɹ�
//					return ServerResponse.createServerResponseBySucess("success",admins.get(i));    //������ȷ���ServerResponse
//				}                            
//				else {	
//					return ServerResponse.createServerResponseByFail(Const.USERNAME_NOT_ERROR,"�������" );  
//				}
//				}					
//		}	
//}

	return ServerResponse.createServerResponseByFail(Const.PASSWORD_NOT_NULL,"�û���������");
	}	
//			public boolean isusernameexists(String username) {                               //�ж��û����治����
//		// TODO Auto-generated method stub
//			for(int i=0;i<admins.size();i++) {
//			
//			Admin user=admins.get(i);
//			if(user==null) {
//				continue;
//			}			
//			String _username=user.getUsername();			
//			if(_username.equals(username)) {//�û�������
//				
//			   return true;
//			}
//			 
//		}
//			 return  false;	
//	}	
		public ServerResponse regist(String username, String password) {
//		//��ӹ���Ա
//			Admin s=new Admin(username,password); 
//		
//			for(int i=0;i<admins.size();i++) {
//			
//			String _username=admins.get(i).getUsername();
//			if(username.equals(_username)) {
//				return ServerResponse.createServerResponseByFail(1,"id�Ѵ���");
//			}else {
//			  admins.add(s);
//			  System.out.println(admins.get(2).getUsername());  //����Ƿ����cheng
//			  return  ServerResponse.createServerResponseBySucess("ע��ɹ�",admins);	
//			}
//      }
//			return ServerResponse.createServerResponseByFail(8,"��������Ϣ");
			return null;
		}
	
	
	
	
	
}