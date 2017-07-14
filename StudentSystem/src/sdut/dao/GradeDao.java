package sdut.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sdut.entity.Grade;

public class GradeDao extends BaseDao {

	// 查询全部
	public List<Grade> search() {
		List<Grade> list = new ArrayList<Grade>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con = openConnection();
			st = con.createStatement();
			rs = st.executeQuery("select * from `studentSystemDB`.`Grade`");
			while (rs.next()) {
				list.add(new Grade(rs.getInt(1), rs.getString(2)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(con, st, rs);
		}
		return list;
	}

	// 根据编号查询
	public List<Grade> search(int id) {
		List<Grade> list = new ArrayList<Grade>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con = openConnection();
			st = con.createStatement();
			rs = st.executeQuery("select * from `studentSystemDB`.`Grade` where id='" + id + "'");
			while (rs.next()) {
				list.add(new Grade(rs.getInt(1), rs.getString(2)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(con, st, rs);
		}
		return list;
	}

	// 添加信息
	public int add(Grade grade) {
		int rel = 0;
		String sql = "INSERT INTO `studentSystemDB`.`Grade` (`id`, `name`) VALUES ('" + grade.getId() + "', '"
				+ grade.getName() + "')";
		rel = updateCommon(sql);
		return rel;
	}

	// 更新信息
	public int update(Grade grade) {
		String sql = "UPDATE `studentSystemDB`.`Grade` SET `name` = '" + grade.getName() + "' WHERE `grade`.`id` = '"
				+ grade.getId() + "'";
		return updateCommon(sql);
	}

	// 删除信息
	public int delete(Grade grade) {
		int rel = 0;
		String sql = "DELETE FROM `studentSystemDB`.`Grade` where `grade`.`id`='" + grade.getId() + "'";
		rel = updateCommon(sql);
		return rel;
	}
}
