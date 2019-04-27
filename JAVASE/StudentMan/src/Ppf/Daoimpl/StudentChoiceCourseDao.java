package Ppf.Daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Ppf.common.Dbutils;
import Ppf.common.PageModel;
import Ppf.dao.IStudentChoiceCourse;
import Ppf.pojo.Course;
import Ppf.pojo.StudentCourse;

public class StudentChoiceCourseDao implements IStudentChoiceCourse {

	private static StudentChoiceCourseDao instance;
	private StudentChoiceCourseDao() {};
	public static StudentChoiceCourseDao getInstance() {
		if(instance==null) {
			instance=new StudentChoiceCourseDao(); 	
		}
		return instance;
	}
	
	@Override
	/**
	 * @PageNO--查询第几页
	 * @PageSize--查询多少条（mysql的方法）
	 * */
	public PageModel<StudentCourse> findCourseBySidLimit(int id, int PageNo, int PageSize) {
		
		// TODO Auto-generated method stub    分页
		PageModel<StudentCourse> pageModel=new PageModel<>();
		Connection c=null;		
		PreparedStatement statement=null;
		ResultSet set=null;	
		PreparedStatement p2=null;
		ResultSet rs2=null;
		try {
			c=Dbutils.getConnection();
			String sql="select count(zid) from studentcourse where sid=?";   //这个学生总共选了多少门课(count(zid)统计出来有多少行，这些行里有多少id=？的)
			statement=c.prepareStatement(sql);
			statement.setInt(1,id);
			set=statement.executeQuery();
			if(set.first()) {
				int record=set.getInt(1);//总的记录数
				int totalPage=0;        //总页数
				if(record%PageSize==0) {
					totalPage=record/PageSize;
				}else {
					totalPage=(record/PageSize)+1; //除不尽页数就+1
				};
				
				pageModel.setTotalPage(totalPage);   //以上都是为了以下几个
				pageModel.setCurrentPage(PageNo);   //当前页
				pageModel.setHasnext(PageNo<totalPage); //是否有下一页
				pageModel.setHasbefore(PageNo>1);//是否有上一页		
			}
			//查询当前页数据
			String current_data_sql="select zid,sid,cid from studentcourse where sid=? limit ?,?";
			p2=c.prepareStatement(current_data_sql);
			p2.setInt(1,id);
			p2.setInt(2,(PageNo-1)*PageSize);
			p2.setInt(3,PageSize);
			
			rs2=p2.executeQuery();
			List<StudentCourse> course=new ArrayList();
			while(rs2.next()) {
				int zid=rs2.getInt("zid");
				int id1=rs2.getInt("sid");
				int cid=rs2.getInt("cid");
				StudentCourse sc=new StudentCourse(zid,id1,cid);
				course.add(sc);			
			}
			pageModel.setDate(course);     //为当前页面赋值
		}	 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
				try {
					if(rs2!=null) {
					rs2.close();}
					if(p2!=null) {
						p2.close();}
					if(set!=null) {
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
		
		
		return pageModel;
	}

	@Override
	public int isChoiceCourse(int id,int cid) {
		// TODO Auto-generated method stub   是否选课
		Connection c=null;		
		PreparedStatement statement=null;
		ResultSet set=null;	
		try {
		c=Dbutils.getConnection();
		String sql="select count(zid) from studentcourse where sid=? and cid=?";//count--zid的那个数有几个
		statement=c.prepareStatement(sql);
		statement.setInt(1, id);
		statement.setInt(2, cid);
		set=statement.executeQuery();
		if(set.first()) {
			return set.getInt(1);		//getInt遍历的的方法：得到每个位置的值
		}	
		} catch(SQLException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int choice(int id, int cid) {
		// TODO Auto-generated method stub   选课
		Connection c=null;		
		PreparedStatement statement=null;
		try {
			c=Dbutils.getConnection();
			String sql="insert into studentcourse (sid,cid) values(?,?)";//count--zid的那个数有几个
			statement=c.prepareStatement(sql);
			statement.setInt(1, id);
			statement.setInt(2, cid);
			
			return statement.executeUpdate();
			}catch(SQLException e){	
				// TODO Auto-generated catch block
				e.printStackTrace();
		}finally {
			Dbutils.close(c, statement);
		}				
		return 0;
	}

	@Override
	public List<StudentCourse> findCourseBySid(int id) {
		// TODO Auto-generated method stub    查看选课
		Connection c=null;		
		PreparedStatement statement=null;
		ResultSet set=null;	
		List<StudentCourse> course=new ArrayList();	
		try {c=Dbutils.getConnection();
			String sql="select * from studentcourse where sid=?";
			statement=c.prepareStatement(sql);
			statement.setInt(1, id);
			set=statement.executeQuery();
			while(set.next()) {
				int zid=set.getInt("zid");
				int id1=set.getInt("sid");
				int cid=set.getInt("cid");				
				course.add(new StudentCourse(zid,id1,cid));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return course;
	}

	@Override
	public int cancleCourse(int id, int cid) {
		// TODO Auto-generated method stub   取消选课	
		Connection c=null;		
		PreparedStatement statement=null;
		try {c=Dbutils.getConnection();
		String sql="delete from studentcourse where sid=? and cid=?";
		statement=c.prepareStatement(sql);
		statement.setInt(1, id);
		statement.setInt(2, cid);
		int num=statement.executeUpdate();
		if(num>0) {
			return 1;
		}}catch(SQLException e){	
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
		return 0;
	}
	
	
	
	
}
