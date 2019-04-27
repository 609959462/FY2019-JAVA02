package Ppf.Daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Ppf.common.Dbutils;
import Ppf.dao.IAdminByCourse;
import Ppf.pojo.Course;
import Ppf.pojo.Student;

public class AdminByCourse implements IAdminByCourse {
	private static AdminByCourse instance;
	private AdminByCourse() {};
	public static synchronized AdminByCourse getInstance() {
		if(instance==null) {
			instance=new AdminByCourse();
		}
		return instance;
	}
	@Override
	//添加课程
	public int addCourse(int cid,String cname) {
		// TODO Auto-generated method stub
		Connection c=null;
		PreparedStatement statement=null;
		
		try {
			c=Dbutils.getConnection();
			String sql="insert into course (cname) values (?)";
			statement=c.prepareStatement(sql);			
			statement.setString(1, cname);
			int num=statement.executeUpdate();
			if(num>0) {
				return 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	finally {
			
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

	@Override
	//查看课程
	public List<Course> lookCourse() {
		// TODO Auto-generated method stub
		List<Course> courses=new ArrayList<>();
		// TODO Auto-generated method stub
		Connection c=null;
		PreparedStatement statement=null;
		ResultSet set=null;	
		try {
			c=Dbutils.getConnection();
			String sql="select * from course";
			statement=c.prepareStatement(sql);
			set=statement.executeQuery(); 
			while(set.next()) {
				int cid=set.getInt("cid");
				String cname=set.getString("cname");				
				Course course=new Course(cid,cname);
				courses.add(course);	
				
			}
			return courses;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	finally {
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
		return courses;
	}

	@Override
	//删除课程
	public int deleteCourse(int cid) {
		// TODO Auto-generated method stub
		Connection c=null;
		PreparedStatement statement=null;
		try {
			c=Dbutils.getConnection();
			String sql="delete from course where cid=?";
			statement=c.prepareStatement(sql);
			statement.setInt(1, cid);
			int num=statement.executeUpdate();
		if(num>0) {
			return 1;
		}  
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
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

	@Override
	//修改课程
	public int correctCourse(int cid,String cname) {
		// TODO Auto-generated method stub
		Connection c=null;
		PreparedStatement statement=null;
		try {
			c=Dbutils.getConnection();
			String sql="update course set cname=? where cid=?";
			statement=c.prepareStatement(sql);
			statement.setString(1,cname);
			statement.setInt(2, cid);
			int num=statement.executeUpdate();
		if(num>0) {
			return 1;
		}  
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
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
