package Ppf.common;
public enum OperationEnum {
	ADMIN_LOGIN(1,"登陆"),
	ADMIN_REGISTER(2,"注册"), 
	ADMIN_LAYOUT(3,"退出"), 
	ADMIN_GET_MEMBER(4,"获取在线人数"),
	COURSE_ADD(5,"添加课程"),
	COURSE_DELETE(6,"删除课程"),
	COURSE_UPDATE(7,"修改课程"),
	COURSE_FIND(8,"查看课程"),
	COURSE_FINDALL(9,"查看所有课程")
	;
	private int operation_type;     //定义两个参数
	private String operation_desc;
	OperationEnum(int operation_type,String operation_desc){
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
