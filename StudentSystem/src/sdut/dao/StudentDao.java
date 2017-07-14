package sdut.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sdut.entity.Student;

public class StudentDao extends BaseDao {

	public List<Student> search() {
		String sql = "SELECT * FROM `student`";
		return searchCommon(sql);
	}

	// 根据姓名查询
	public List<Student> search(String name) {
		String sql = "select * from student where name like '%" + name + "%'";
		return searchCommon(sql);
	}

	private List<Student> searchCommon(String sql) {
		List<Student> list = new ArrayList();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con = openConnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Student student = new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8));
				list.add(student);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(con, st, rs);
		}
		return list;
	}

	// 根据编号查询
	public List<Student> search(Integer id) {
		String sql = "select * from student where id=" + id;
		return searchCommon(sql);
	}

	public int add(Student student) {
		int rel = 0;
		String sql = "INSERT INTO `studentSystemDB`.`Student` (`id`, `name`,`password`, `age`, `place`, `phone`, `qq`, `grade`) VALUES ('"
				+ student.getId() + "', '" + student.getName() + "','" + student.getPassword() + "','"
				+ student.getAge() + "', '" + student.getPlace() + "', '" + student.getPhone() + "', '"
				+ student.getQq() + "', '" + student.getGrade() + "')";
		rel = updateCommon(sql);
		return rel;
	}

	public int update(Student student) {
		int rel = 0;
		String sql = "UPDATE `studentSystemDB`.`Student` SET `name` = '" + student.getName() + "',`password` = '"
				+ student.getPassword() + "', `age` = '" + student.getAge() + "', `place` = '" + student.getPlace()
				+ "',`phone` = '" + student.getPhone() + "', `qq` = '" + student.getQq() + "', `grade` = '"
				+ student.getGrade() + "' WHERE `student`.`id` ='" + student.getId() + "'";
		rel = updateCommon(sql);
		return rel;
	}

	public int delete(int id) {
		int rel = 0;
		String sql = "DELETE FROM `studentSystemDB`.`Student` WHERE `student`.`id` = '" + id + "'";
		rel = updateCommon(sql);
		return rel;
	}

	public int register(Student student) {
		int rel = 0;
		String sql = "INSERT INTO `studentSystemDB`.`Student` (`id`, `name`,`password`, `age`, `place`, `phone`, `qq`, `grade`) VALUES ('"
				+ student.getId() + "', '" + student.getName() + "','" + student.getPassword() + "','"
				+ student.getAge() + "', '" + student.getPlace() + "', '" + student.getPhone() + "', '"
				+ student.getQq() + "', '" + student.getGrade() + "')";
		rel = updateCommon(sql);
		return rel;
	}

	public boolean checkLogin(Student s) {
		boolean type = false;
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		con = openConnection();
		try {
			st = con.createStatement();
			//预编译语句集    处理SQL注入问题
			String name=s.getName();
			String password=s.getPassword();
			String sql = "select * from student where name=? and password=?";
			PreparedStatement preState=con.prepareStatement(sql);
			preState.setString(1, name);
			preState.setString(2, password);
			rs = preState.executeQuery();
			if (rs.next()) {
				type = true;
			} else {
				type = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(con, st, rs);
		}
		return type;
	}
}
