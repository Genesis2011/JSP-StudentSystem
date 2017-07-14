package sdut.entity;

public class Student {
	private Integer id;
	private String name;
	private Integer age;
	private String place;
	private String phone;
	private String qq;
	private Integer grade;
	private String password;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	public Student(Integer id,String name,String password,Integer age,String place,String phone,String qq,Integer grade){
		this.id=id;
		this.name=name;
		this.age=age;
		this.place=place;
		this.phone=phone;
		this.qq=qq;
		this.grade=grade;
		this.password=password;
	}
	public Student(){
		
	}
}
