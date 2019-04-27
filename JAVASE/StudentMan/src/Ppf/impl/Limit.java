package Ppf.impl;

import Ppf.Daoimpl.StudentChoiceCourseDao;
import Ppf.common.PageModel;
import Ppf.common.ServerResponse;
import Ppf.pojo.StudentCourse;

//分页查询
public class Limit {
	private static Limit instance;
	private Limit() {}
	public static Limit getInstance() {
		if(instance==null) {
			return instance=new Limit();
		}
		return instance;
	} 
	//根据学生id
	public ServerResponse limitBySid(int id,int PageNo,int PageSize) {
		
		PageModel<StudentCourse> sc=StudentChoiceCourseDao.getInstance().findCourseBySidLimit(id, PageNo, PageSize);
		if(sc!=null) {
		return ServerResponse.createServerResponseBySucess("查看成功", sc);
	}
	return ServerResponse.createServerResponseByFail(30,"查看失败");	
}
}