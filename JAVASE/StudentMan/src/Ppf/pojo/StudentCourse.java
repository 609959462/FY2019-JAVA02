package Ppf.pojo;

import java.io.Serializable;

/**
 * @id��ѧ��id��ûѧ���ݿ��id�����ˣ�
 * @zid������
 * @cid�γ�id
 * */
public class StudentCourse implements Serializable{
	
//ѧ��ѡ�α�----���˱��ˣ��Ǳ�ȻҪ�и���֮��Ӧ��pojo��
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
