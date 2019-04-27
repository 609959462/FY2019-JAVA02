package Ppf.Mybatis.imp;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import Ppf.dao.IAdminByCourse;
import Ppf.pojo.Course;

public class AdminByCourse implements IAdminByCourse {
	private static AdminByCourse instance;
	private AdminByCourse() {};
	public static AdminByCourse getInstance() {
		if(instance==null) {
			instance=new AdminByCourse();
		}
		return instance;
	}
	@Override
	public int addCourse(int cid, String cname) {
		// TODO Auto-generated method stub
		String resource = "MyBatisConfig.xml";    //
		Reader reader = null;
		SqlSession session;
		try {
			reader = Resources.getResourceAsReader(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder()
				.build(reader);
		session = sqlMapper.openSession();
		
		int num=session.insert("Ppf.pojo.Course.addCourse",cname);
		session.commit();
		return num;
	}

	@Override
	public List<Course> lookCourse() {       
		String resource = "MyBatisConfig.xml";    //
		Reader reader = null;
		SqlSession session;
		try {
			reader = Resources.getResourceAsReader(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder()
				.build(reader);
		session = sqlMapper.openSession();		
		List<Course> course=session.selectList("Ppf.pojo.Course.findCourse");	
		
		// TODO Auto-generated method stub
		return course;
	}

	@Override
	public int deleteCourse(int cid) {
		// TODO Auto-generated method stub
		String resource = "MyBatisConfig.xml";    //
		Reader reader = null;
		SqlSession session;
		try {
			reader = Resources.getResourceAsReader(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder()
				.build(reader);
		session = sqlMapper.openSession();	
		int num=session.delete("Ppf.pojo.Course.deleteCourse",cid);
		session.commit();
		return num;
	}

	@Override
	public int correctCourse(int cid, String cname) {
		// TODO Auto-generated method stub
		String resource = "MyBatisConfig.xml";    //
		Reader reader = null;
		SqlSession session;
		try {
			reader = Resources.getResourceAsReader(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder()
				.build(reader);
		session = sqlMapper.openSession();	
		Map<String,Object> maps=new HashMap<>();
		maps.put("cid", cid);
		maps.put("cname", cname);
		int num=session.delete("Ppf.pojo.Course.correctCourse",maps);
		session.commit();
		return num;
	
	}

}
