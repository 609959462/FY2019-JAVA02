package Ppf.pojo;
public enum banji {
	high("�߼�"),
	middle("�м�"),
	least("�ͼ�")
	;
    private String banji;                //�������
	banji(String _class) {               //���췽��
		this.banji=_class;
	}
	public String getBanji() {
		return this.banji;
	} 
	
	
	
}
