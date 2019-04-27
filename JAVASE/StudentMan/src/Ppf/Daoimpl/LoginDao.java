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
//	private static LoginDao instance;    //单例
//	private LoginDao() {}
//	public  static synchronized LoginDao getInstance() {
//		if(instance==null) {
//			instance=new LoginDao();
//		}
//		return instance;
//	}
//	
//	@Override
//	public boolean isuseernameexists(String username) {   //判断用户名存在？
//		// TODO Auto-generated method stub
//			//加载驱动不需要了（在static代码块写了会首先执行）	 
//		 Connection c =null;
//		 PreparedStatement statement=null;
//		 ResultSet resultSet=null;
//		 try {
//			c=Dbutils.getConnection();        //创建连接
//			String sql="select username from admin where username=?";//准备sql语句
//			statement=c.prepareStatement(sql);//创建专门执行mysql语句的
//			statement.setString(1, username);
//			resultSet=statement.executeQuery();     //执行sql语句
//			if(resultSet.first()) {    //处理结果
//				return true;
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		 finally {
//		                                                      //关闭连接		
//						Dbutils.close(c, statement,resultSet);
//						
//					 }				 		 
//		return false;		
//	}
//
//	/**@Override
//	public Admin findAdminByusernameAndPasseord(String username, String password) {
//		// TODO Auto-generated method stub
//		//加载驱动不需要了（在static代码块写了会首先执行）				 
//		 Connection c =null;
//		 PreparedStatement statement=null;
//		 ResultSet resultSet=null;
//		 try {
//			c=Dbutils.getConnection();//创建连接
//			String sql="select username from admin where username=? and password=?";//准备sql语句
//			statement=c.prepareStatement(sql);//创建专门执行mysql语句的
//			statement.setString(1, username);
//			statement.setString(2, password);
//			resultSet=statement.executeQuery();     //执行sql语句
//			
//			if(resultSet.first()) {    //处理结果
//				return  new Admin(username,password);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		 finally {
//		                                                      //关闭连接		
//			 Dbutils.close(c, statement,resultSet);
//					 }				 		 				
//		return null;
//	}*/
//	
//	
//	
//	//学生登陆
//	public Student studentLogin(int id,String password) {	
//		Connection c =null;
//		 PreparedStatement statement=null;
//		 ResultSet resultSet=null; 
//		 try {
//				c=Dbutils.getConnection();//创建连接
//				String sql="select id from student where id=? and password=?";//准备sql语句
//				statement=c.prepareStatement(sql);//创建专门执行mysql语句的
//				statement.setInt(1, id);
//				statement.setString(2, password);
//				resultSet=statement.executeQuery();     //执行sql语句				
//				if(resultSet.first()) {    //处理结果
//					return  new Student(id,password);
//				}
//				
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			 finally {
//			                                                      //关闭连接		
//				 Dbutils.close(c, statement,resultSet);
//						 }				 		 				
//			return null;		
//	}

	
	


//}