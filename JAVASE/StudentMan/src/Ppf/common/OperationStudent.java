package Ppf.common;

public enum OperationStudent {
	Find_ALLSTUDENT(1,"�鿴����ѧ��"),
	Find_PARTSTUDENT(2,"�鿴����ѧ��"),
	ADD_STUDENT(3,"���ѧ��"),
	DELECT_STUDENT(4,"ɾ��ѧ��"),
	//MODIFY_STUDENT(5,"�޸�ѧ����Ϣ"),
	MODIFYID_STUDENT(5,"����ID�޸�ѧ����Ϣ")
	;
	private int operation_type;  
	private String operation_desc;
	OperationStudent(int operation_type,String operation_desc){
		this.operation_type=operation_type;
		this.operation_desc=operation_desc;
	}
	public int getOperation_type() {
		return operation_type;
	}
	public void setOperation_type(int operation_type) {
		this.operation_type = operation_type;
	}
	public String getOperation_desc() {
		return operation_desc;
	}
	public void setOperation_desc(String operation_desc) {
		this.operation_desc = operation_desc;
	}

}
