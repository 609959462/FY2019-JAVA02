package Ppf.pojo;
/**
*�γ���
*@para cnmae�γ���
*@para  cid�γ�ID
*/
public class Course {
	private String cname;
	private int cid;
	public Course() {		
	}
	public Course(int cid,String cname) {	
		super();
		this.cid=cid;
		this.cname=cname;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}	
}
