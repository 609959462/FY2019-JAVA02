package Ppf.pojo;

public class Student {
	public String name;                    
	public int id;
	public String sex;
	public int age;
	public String _class;
	public String address;
	public int phone;
	public String email;
public Student(int id,String name,String sex,int age,String _class,String address,int phone,String email) {
	this.id=id;
	this.name=name;
	this.sex=sex;
	this.age=age;
	this._class=_class;
	this.address=address;
	this.phone=phone;
	this.email=email;
	
}
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
public String getSex() {
	return sex;
}
public void setSex(String sex) {
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

}
