package Ppf.Mybatis.imp;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import Ppf.dao.IAdminByStudent;
import Ppf.pojo.Student;

public class AdminByStudent implements IAdminByStudent {
	private static AdminByStudent instance;
	private AdminByStudent() {};
	public static AdminByStudent getInstance() {
		if(instance==null) {
			instance=new AdminByStudent();
		}
		return instance;
	}

	@Override
	public List<Student> lookAll() {
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
		
		List<Student> students=session.selectList("Ppf.pojo.Student.lookAll");
		return students;
	}

	@Override
	public int delete(int id) {
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
		int num=session.delete("Ppf.pojo.Student.delete",id);	
		session.commit();
		return num;
	}
	public int correct(int id, String name, int sex, int age, String _class, String address,
			int phone, String email, int scores) {
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
		maps.put("name",name);
		maps.put("sex",sex);
		maps.put("age",age);
		maps.put("_class",_class);
		maps.put("address",address);
		maps.put("phone",phone);
		maps.put("email",email);
		maps.put("scores",scores);
		maps.put("id",id);
		int num=session.update("Ppf.pojo.Student.correct", maps);
		session.commit();
		return num;
	}
	
	public boolean add(int id, String name, int sex, int age, String _class, String address, int phone, String email,
			int scores, String password) {
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
	maps.put("name",name);
	maps.put("sex",sex);
	maps.put("age",age);
	maps.put("_class",_class);
	maps.put("address",address);
	maps.put("phone",phone);
	maps.put("email",email);
	maps.put("scores",scores);
	maps.put("id",id);
	maps.put("password", password);
	int num=session.insert("Ppf.pojo.Student.add",maps);
	session.commit();
	if(num>0) {
		return true;
	}
	return false;
	}
	
}
