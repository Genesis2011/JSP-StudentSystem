package sdut.entity;


public class Score {
	private Integer id;
	private Double score;
	private String course;
	private String time;
	private Integer studentid;

	public Score(Integer id, Double score, String course, String time, Integer studentid) {
		this.id = id;
		this.score = score;
		this.course = course;
		this.time = time;
		this.studentid = studentid;
	}

	public Score() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getStudentid() {
		return studentid;
	}

	public void setStudentid(Integer studentid) {
		this.studentid = studentid;
	}
	
}
