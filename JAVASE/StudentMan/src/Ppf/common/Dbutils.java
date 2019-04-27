package Ppf.common;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;



public class Dbutils {
	
		private static Properties properties=new Properties();   //流的一个类Properties，用它去写
	
	
	static {
		InputStream is=Thread.currentThread().getContextClassLoader().getResourceAsStream("jdbc.properties");   //线程的一个方法	
		try {
			properties.load(is);//Properties的一个方法 （流的内容加载到了Properties中）
			Class.forName(properties.getProperty("jdbc.driver"));                    //加载驱动
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static Connection getConnection() {          //获取连接
		Connection c=null;
		try {
			c=DriverManager.getConnection(properties.getProperty("jdbc.url"),
					properties.getProperty("jdbc.user"), 
					properties.getProperty("jdbc.password"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}                                       
	public static void close(Connection c,PreparedStatement p) {		    //关流（两个参数的）
			try {
				if(p!=null) {
				p.close();
				}
				if(c!=null) {
				c.close();	
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}				
	}
	public  static  void  close(Connection c,PreparedStatement p,ResultSet set) {   //关流3参数的
		
		try {
			if(set!=null) {
				set.close();
			}
			if(p!=null) {
				p.close();
			}
			if(c!=null) {
				c.close();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	
	
	
}
