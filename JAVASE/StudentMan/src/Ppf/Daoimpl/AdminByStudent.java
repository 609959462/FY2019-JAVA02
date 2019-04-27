package Ppf.Daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Ppf.common.Dbutils;
import Ppf.dao.IAdminByStudent;
import Ppf.pojo.Student;

public class AdminByStudent implements IAdminByStudent {
	private static AdminByStudent instance;
	private AdminByStudent() {};
	public static AdminByStudent getInstance(){
		if(instance==null) {
			instance=new AdminByStudent();
		}
		return instance;
	}
	
	
	
	
	
	
	@Override
	public List<Student> lookAll() {
		List<Student> students=new ArrayList<>();
		// TODO Auto-generated method stub
		Connection c=null;
		PreparedStatement statement=null;
		ResultSet set=null;	
		try {
			c=Dbutils.getConnection();//创建连接
			String sql="select * from student";//准备sql语句
			statement=c.prepareStatement(sql);
			set=statement.executeQuery(); //查看
			while(set.next()) {
				int id=set.getInt("id");
				String name=set.getString("name");
				int age=set.getInt("age");
				int sex=set.getInt("sex");
				String _class=set.getString("_class");
				String address=set.getString("address");
				int phone=set.getInt("phone");
				String register_time=set.getString("register_time");
				String password=set.getString("password");
				int scores=set.getInt("scores");
				String email=set.getString("email");
				
				Student student=new Student(id,name,sex,age,_class,address,phone,email,scores,register_time,password);
				students.add(student);
				
			}
			return students;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}

	//判断学生id
	public boolean isusernameexists(int id) {
		Connection c=null;
		PreparedStatement statement=null;
		ResultSet set=null;	
		try {
		c=Dbutils.getConnection();//创建连接
		String sql="select id from student where id=?";//准备sql语句		
		statement=c.prepareStatement(sql);
		statement.setInt(1, id);
		set=statement.executeQuery(); //查看
		while(set.first()) {
			return true;
		}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {if(set!=null) {
				set.close();}
			if(statement!=null) {
				statement.close();}
			if(c!=null) {
				c.close();}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return false;
	}
	//查看部分学生
	public List<Student> lookPart(int num1){
		List<Student> students=new ArrayList<>();
		Connection c=null;
		PreparedStatement statement=null;
		ResultSet set=null;	
									//加载驱动
		
		try {c=Dbutils.getConnection();//获取连接
		String sql="select * from student where id=?";//准备sql语句		
			statement=c.prepareStatement(sql);
			statement.setInt(1, num1);
			set=statement.executeQuery(); //查看
			while(set.next()) {
				int id1=set.getInt("id");       //get方法
				String name=set.getString("name");
				int age=set.getInt("age");
				int sex=set.getInt("sex");
				String _class=set.getString("_class");
				String address=set.getString("address");
				int phone=set.getInt("phone");
				String register_time=set.getString("register_time");
				String password=set.getString("password");
				int scores=set.getInt("scores");
				String email=set.getString("email");
				
				Student student=new Student(id1,name,sex,age,_class,address,phone,email,scores,register_time,password);
				students.add(student);
			}
			return students;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {if(set!=null) {
				set.close();}
			if(statement!=null) {
				statement.close();}
			if(c!=null) {
				c.close();}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return null;
		
		
	} 
	//���ѧ��
	public boolean add(int id, String name, int sex, int age, String _class, String address, int phone, String email,
			int scores, String password){
		List<Student> students=new ArrayList<>();
		Connection c=null;
		PreparedStatement statement=null;
		//加载驱动
		
		try {
			c=Dbutils.getConnection();
			String sql="insert into student (name,sex,age,_class,address,phone,email,scores,password) values (?,?,?,?,?,?,?,?,?)";//准备sql语句		
			statement=c.prepareStatement(sql);
			//statement.setInt(1, id);
			statement.setString(1, name);   //Ԥ����ķ���
			statement.setInt(2, sex);		
			statement.setInt(3, age);
			statement.setString(4, _class);
			statement.setString(5, address);
			statement.setInt(6, phone);
			statement.setString(7, email);
			statement.setInt(8, scores);
			statement.setString(9, password);
			
			int num=statement.executeUpdate();
			if(num>0) {
				//�ɹ�
				return  true;
			}		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
				try {
					if(statement!=null) {
					statement.close();}
					if(c!=null) {
						c.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
		return false;
			
		}
	@Override
	public int delete(int m) {
		// TODO Auto-generated method stub
		
		
		Connection c=null;
		PreparedStatement statement=null;
		
		
		try {
			c=Dbutils.getConnection();
			String sql="delete from student where id=?";
			statement=c.prepareStatement(sql);
			statement.setInt(1, m);//Ԥ����
			int num=statement.executeUpdate();
			if(num>0) {
				//�ɹ�
				return  1;
			}		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
				try {
					if(statement!=null) {
					statement.close();}
					if(c!=null) {
						c.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
		return 0;
	}
	//�޸�ѧ��	
		public int correct(int id, String name, int sex, int age, String _class, String address,
				int phone, String email, int scores) {
			Connection c=null;
			PreparedStatement statement=null;						
			try {
				c=Dbutils.getConnection();
				String sql="update student set name=?,sex=?,age=?,_class=?,address=?,phone=?,email=?,scores=? where id=?";
				statement=c.prepareStatement(sql);
				statement.setString(1,name);//Ԥ����
				statement.setInt(2,sex);
				statement.setInt(3,age);
				statement.setString(4,_class);
				statement.setString(5,address);
				statement.setInt(6,phone);
				statement.setString(7,email);
				statement.setInt(8,scores);
				statement.setInt(9,id);
				int num=statement.executeUpdate();
				if(num>0) {
					//�ɹ�
					return  1;
				}					
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				
					try {
						if(statement!=null) {
						statement.close();}
						if(c!=null) {
							c.close();
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
				}
			return 0;
			
		}
		
		
		
		
		
		
		
		
		
	
	
	
	
	
	
	
	
	
	
}