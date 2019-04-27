package Ppf.Mybatis.imp;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import Ppf.dao.ILoginDao;
import Ppf.pojo.Admin;

public class LoginDao implements ILoginDao {
	private static LoginDao instance;
	private LoginDao() {};
	public static LoginDao getInstance() {
		if(instance==null) {
			instance=new LoginDao();
		}
		return instance;
	}
	
	@Override//用户名是否存在
	public boolean isuseernameexists(String username) {
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
		int num=session.selectOne("Ppf.pojo.Admin.isuseernameexists",username);	
		System.out.println(num);
		
		if(num>0) {
		return true;
				}
		return false;	
	}

	@Override//教师登陆
	public Admin findAdminByusernameAndPasseord(String username, String password) {
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
		maps.put("username",username);//K-V方式
		maps.put("password",password);
		Admin admin=session.selectOne("Ppf.pojo.Admin.findAdminByusernameAndPasseord",maps);
		return admin;
	}

	
	
	
	
}
