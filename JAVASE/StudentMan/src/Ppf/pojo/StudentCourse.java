package Ppf.pojo;

import java.io.Serializable;

/**
 * @id是学生id（没学数据库把id乱用了）
 * @zid是主键
 * @cid课程id
 * */
public class StudentCourse implements Serializable{
	
//学生选课表----有了表了，那必然要有个与之对应的pojo类
	private int zid;
	private int cid;
 	private int id;
 	
 	public StudentCourse() {};
	public StudentCourse(int zid,int id,int cid) {
		this.zid=zid;
		this.id=id;
		this.cid=cid;
	};
 	
	public int getZid() {
		return zid;
	}
	public void setZid(int zid) {
		this.zid = zid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	} 
	
}
