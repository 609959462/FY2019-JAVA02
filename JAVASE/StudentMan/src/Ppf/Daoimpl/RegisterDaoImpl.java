package Ppf.Daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import Ppf.common.ServerResponse;
import Ppf.pojo.Admin;

public class RegisterDaoImpl {
	private static RegisterDaoImpl instance;
	private RegisterDaoImpl() {};
	public static RegisterDaoImpl getInstance() {
		if(instance==null) {
			instance=new RegisterDaoImpl();
		}
		return instance;
	}
	public ServerResponse register(String username,String password) {
		try {                                  //加载驱动
		    Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		    e.printStackTrace();
		}			
			Connection c=null;
			Statement statement=null;
			try {
				
				c=DriverManager.getConnection("jdbc:mysql://39.96.73.227:3306/scottt","ppf","ZUguo123@");//获取数据库的地址
				statement=c.createStatement();//Statement专门执行sql语句的对象
				String sql="insert into admin(username,password) values('"+username+"','"+password+"')";
				
				int num=statement.executeUpdate(sql); //executeUpdate可以执行增删改
				
				if(num>0) {
					return ServerResponse.createServerResponseBySucess("添加成功");
				}								
			} catch (SQLException e) {
				
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}finally {
				try {
					if(statement!=null) {  //要关掉，先关最后用的
					statement.close();
					}
					if(c!=null) {
						c.close();
						}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			return ServerResponse.createServerResponseByFail(11,"不可为空" );
					
	}
	
	
	
	
	
	
	
	
}
