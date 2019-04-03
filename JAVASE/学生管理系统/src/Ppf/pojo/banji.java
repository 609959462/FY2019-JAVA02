package Ppf.pojo;
public enum banji {
	high("高级"),
	middle("中级"),
	least("低级")
	;
    private String banji;                //定义变量
	banji(String _class) {               //构造方法
		this.banji=_class;
	}
	public String getBanji() {
		return this.banji;
	} 
	
	
	
}
