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
		try {                                  //��������
		    Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		    e.printStackTrace();
		}			
			Connection c=null;
			Statement statement=null;
			try {
				
				c=DriverManager.getConnection("jdbc:mysql://39.96.73.227:3306/scottt","ppf","ZUguo123@");//��ȡ���ݿ�ĵ�ַ
				statement=c.createStatement();//Statementר��ִ��sql���Ķ���
				String sql="insert into admin(username,password) values('"+username+"','"+password+"')";
				
				int num=statement.executeUpdate(sql); //executeUpdate����ִ����ɾ��
				
				if(num>0) {
					return ServerResponse.createServerResponseBySucess("��ӳɹ�");
				}								
			} catch (SQLException e) {
				
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}finally {
				try {
					if(statement!=null) {  //Ҫ�ص����ȹ�����õ�
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
			
			return ServerResponse.createServerResponseByFail(11,"����Ϊ��" );
					
	}
	
	
	
	
	
	
	
	
}
