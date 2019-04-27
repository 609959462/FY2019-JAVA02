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
	 * @PageNO--��ѯ�ڼ�ҳ
	 * @PageSize--��ѯ��������mysql�ķ�����
	 * */
	public PageModel<StudentCourse> findCourseBySidLimit(int id, int PageNo, int PageSize) {
		
		// TODO Auto-generated method stub    ��ҳ
		PageModel<StudentCourse> pageModel=new PageModel<>();
		Connection c=null;		
		PreparedStatement statement=null;
		ResultSet set=null;	
		PreparedStatement p2=null;
		ResultSet rs2=null;
		try {
			c=Dbutils.getConnection();
			String sql="select count(zid) from studentcourse where sid=?";   //���ѧ���ܹ�ѡ�˶����ſ�(count(zid)ͳ�Ƴ����ж����У���Щ�����ж���id=����)
			statement=c.prepareStatement(sql);
			statement.setInt(1,id);
			set=statement.executeQuery();
			if(set.first()) {
				int record=set.getInt(1);//�ܵļ�¼��
				int totalPage=0;        //��ҳ��
				if(record%PageSize==0) {
					totalPage=record/PageSize;
				}else {
					totalPage=(record/PageSize)+1; //������ҳ����+1
				};
				
				pageModel.setTotalPage(totalPage);   //���϶���Ϊ�����¼���
				pageModel.setCurrentPage(PageNo);   //��ǰҳ
				pageModel.setHasnext(PageNo<totalPage); //�Ƿ�����һҳ
				pageModel.setHasbefore(PageNo>1);//�Ƿ�����һҳ		
			}
			//��ѯ��ǰҳ����
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
			pageModel.setDate(course);     //Ϊ��ǰҳ�渳ֵ
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
		// TODO Auto-generated method stub   �Ƿ�ѡ��
		Connection c=null;		
		PreparedStatement statement=null;
		ResultSet set=null;	
		try {
		c=Dbutils.getConnection();
		String sql="select count(zid) from studentcourse where sid=? and cid=?";//count--zid���Ǹ����м���
		statement=c.prepareStatement(sql);
		statement.setInt(1, id);
		statement.setInt(2, cid);
		set=statement.executeQuery();
		if(set.first()) {
			return set.getInt(1);		//getInt�����ĵķ������õ�ÿ��λ�õ�ֵ
		}	
		} catch(SQLException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int choice(int id, int cid) {
		// TODO Auto-generated method stub   ѡ��
		Connection c=null;		
		PreparedStatement statement=null;
		try {
			c=Dbutils.getConnection();
			String sql="insert into studentcourse (sid,cid) values(?,?)";//count--zid���Ǹ����м���
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
		// TODO Auto-generated method stub    �鿴ѡ��
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
		// TODO Auto-generated method stub   ȡ��ѡ��	
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
