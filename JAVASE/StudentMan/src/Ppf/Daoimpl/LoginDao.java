package Ppf.Daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Ppf.common.Dbutils;
import Ppf.dao.ILoginDao;
import Ppf.pojo.Admin;
import Ppf.pojo.Student;

//public class LoginDao implements ILoginDao {
//	private static LoginDao instance;    //����
//	private LoginDao() {}
//	public  static synchronized LoginDao getInstance() {
//		if(instance==null) {
//			instance=new LoginDao();
//		}
//		return instance;
//	}
//	
//	@Override
//	public boolean isuseernameexists(String username) {   //�ж��û������ڣ�
//		// TODO Auto-generated method stub
//			//������������Ҫ�ˣ���static�����д�˻�����ִ�У�	 
//		 Connection c =null;
//		 PreparedStatement statement=null;
//		 ResultSet resultSet=null;
//		 try {
//			c=Dbutils.getConnection();        //��������
//			String sql="select username from admin where username=?";//׼��sql���
//			statement=c.prepareStatement(sql);//����ר��ִ��mysql����
//			statement.setString(1, username);
//			resultSet=statement.executeQuery();     //ִ��sql���
//			if(resultSet.first()) {    //������
//				return true;
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		 finally {
//		                                                      //�ر�����		
//						Dbutils.close(c, statement,resultSet);
//						
//					 }				 		 
//		return false;		
//	}
//
//	/**@Override
//	public Admin findAdminByusernameAndPasseord(String username, String password) {
//		// TODO Auto-generated method stub
//		//������������Ҫ�ˣ���static�����д�˻�����ִ�У�				 
//		 Connection c =null;
//		 PreparedStatement statement=null;
//		 ResultSet resultSet=null;
//		 try {
//			c=Dbutils.getConnection();//��������
//			String sql="select username from admin where username=? and password=?";//׼��sql���
//			statement=c.prepareStatement(sql);//����ר��ִ��mysql����
//			statement.setString(1, username);
//			statement.setString(2, password);
//			resultSet=statement.executeQuery();     //ִ��sql���
//			
//			if(resultSet.first()) {    //������
//				return  new Admin(username,password);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		 finally {
//		                                                      //�ر�����		
//			 Dbutils.close(c, statement,resultSet);
//					 }				 		 				
//		return null;
//	}*/
//	
//	
//	
//	//ѧ����½
//	public Student studentLogin(int id,String password) {	
//		Connection c =null;
//		 PreparedStatement statement=null;
//		 ResultSet resultSet=null; 
//		 try {
//				c=Dbutils.getConnection();//��������
//				String sql="select id from student where id=? and password=?";//׼��sql���
//				statement=c.prepareStatement(sql);//����ר��ִ��mysql����
//				statement.setInt(1, id);
//				statement.setString(2, password);
//				resultSet=statement.executeQuery();     //ִ��sql���				
//				if(resultSet.first()) {    //������
//					return  new Student(id,password);
//				}
//				
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			 finally {
//			                                                      //�ر�����		
//				 Dbutils.close(c, statement,resultSet);
//						 }				 		 				
//			return null;		
//	}

	
	


//}