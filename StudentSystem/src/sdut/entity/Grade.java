package sdut.entity;

public class Grade {
	private Integer id;
	private String name;
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
	public Grade() {
		
	}
	public Grade(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	
}
