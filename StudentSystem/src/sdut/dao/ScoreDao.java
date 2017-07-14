package sdut.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import sdut.bin.ScoreBin;
import sdut.entity.Score;

public class ScoreDao extends BaseDao {
	// 添加
	public int add(Score score) {
		if(checkSearch(score)>0){
			return 1;
		}else {
			int rel = 0;
			String sql = "INSERT INTO `studentSystemDB`.`Score` (`id`, `score`, `course`, `time`, `studentid`) VALUES (NULL, '"
					+ score.getScore() + "', '" + score.getCourse() + "', '" + score.getTime() + "', '"
					+ score.getStudentid() + "')";
			rel = updateCommon(sql);
			return rel;
		}
	}

	// 查询全部
	public List<Score> search() {
		List<Score> list = new ArrayList<Score>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con = openConnection();
			st = con.createStatement();
			rs = st.executeQuery("select * from Score");
			while (rs.next()) {
				list.add(new Score(rs.getInt(1), rs.getDouble(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(con, st, rs);
		}
		return list;
	}

	// 根据学号查询
	public List<Score> search(Integer id) {
		List<Score> list = new ArrayList<Score>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con = openConnection();
			st = con.createStatement();
			rs = st.executeQuery("select * from Score where id=" + id);
			while (rs.next()) {
				list.add(new Score(rs.getInt(1), rs.getDouble(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(con, st, rs);
		}
		return list;
	}

	// 删除
	public int delete(Score score) {
		String sql = "DELETE FROM `studentSystemDB`.`Score` WHERE `score`.`id` = '" + score.getId() + "'";
		return updateCommon(sql);
	}

	public int delete(int id) {
		String sql = "DELETE FROM `studentSystemDB`.`Score` WHERE `score`.`id` = '" + id + "'";
		return updateCommon(sql);
	}

	// 修改
	public int update(Score score) {
		String sql = "UPDATE `studentSystemDB`.`Score` SET  " + "`score` = '" + score.getScore() + "', "
				+ "`course` = '" + score.getCourse() + "'," + " `time` = '" + score.getTime() + "', "
				+ "`studentid` = '" + score.getStudentid() + "' WHERE `score`.`id` = '" + score.getId() + "'";
		return updateCommon(sql);
	}

	public int checkSearch(Score score) {
		String sql = "select * from Score where studentid='" + score.getStudentid() + "' and course='"
				+ score.getCourse() + "'";
		return updateCommon(sql);
	}
}
