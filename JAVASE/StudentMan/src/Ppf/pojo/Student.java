package Ppf.pojo;
	public class Student implements Comparable<Student> {
		public String name;                    
		public int id;
		public int sex;
		public int age;
		public String _class;
		public String address;
		public int phone;
		public String email;
		public int scores;
		public String date;
		private String password;
	public Student(int id,String name,int sex,int age,String _class,String address,int phone,String email,int scores,String date,String password) {
		this.id=id;
		this.name=name;
		this.sex=sex;
		this.age=age;
		this._class=_class;
		this.address=address;
		this.phone=phone;
		this.email=email;
		this.scores=scores;
		this.date=date;
		this.password=password;
	}
	public Student(int id,String password) {
		super();
		this.id=id;
		this.password=password;
	}
//	public Student(int id,String name) {
//			super();
//			this.id = id;
//			this.name = name;		
//	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String get_class() {
		return _class;
	}
	public void set_class(String _class) {
		this._class = _class;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getScores() {
		return scores;
	}
	public void setScores(int scores) {
		this.scores = scores;
	}
	public String getDate() {
		return date;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return password;
	}
	@Override
	public int compareTo(Student o) {                                //�Ƚ���ʵ�ֽӿ���ʵ��compareTo����
		// TODO Auto-generated method stub
		if(o==null) {
			return 1;                                               //����ǿյķ���1����ʾ��ǰ�����Ǵ��
		}
		
		return this.scores-o.getScores();
	}


	}


