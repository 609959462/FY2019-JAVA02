package Ppf.common;
public enum OperationEnum {
	ADMIN_LOGIN(1,"��½"),
	ADMIN_REGISTER(2,"ע��"), 
	ADMIN_LAYOUT(3,"�˳�"), 
	ADMIN_GET_MEMBER(4,"��ȡ��������"),
	COURSE_ADD(5,"��ӿγ�"),
	COURSE_DELETE(6,"ɾ���γ�"),
	COURSE_UPDATE(7,"�޸Ŀγ�"),
	COURSE_FIND(8,"�鿴�γ�"),
	COURSE_FINDALL(9,"�鿴���пγ�")
	;
	private int operation_type;     //������������
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
