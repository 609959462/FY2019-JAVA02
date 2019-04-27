package Ppf.common;

public enum OperationStudent {
	Find_ALLSTUDENT(1,"查看所有学生"),
	Find_PARTSTUDENT(2,"查看部分学生"),
	ADD_STUDENT(3,"添加学生"),
	DELECT_STUDENT(4,"删除学生"),
	//MODIFY_STUDENT(5,"修改学生信息"),
	MODIFYID_STUDENT(5,"根据ID修改学生信息")
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
