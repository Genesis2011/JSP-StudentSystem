package sdut.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sdut.entity.User;

public class UserDao extends BaseDao {
	// 登录
	public boolean checkLogin(User user) {
		boolean type = false;
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		con = openConnection();
		try {
			st = con.createStatement();
			//预编译语句集    处理SQL注入问题
			String name=user.getName();
			String password=user.getPassword();
			String sql = "select * from user where name=? and password=?";
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

	// 注册
	public int checkRegister(User user) {
		String sql = "INSERT INTO `mydb`.`User` (`id`, `name`, `password`,`age`,`phone`) VALUES ('" + user.getId()
				+ "', '" + user.getName() + "', '" + user.getPassword() + "','" + user.getAge() + "' ,'"
				+ user.getPhone() + "')";
		return updateCommon(sql);
	}

	// 添加
	public int addUser(User user) {
		int rel = 0;
		String sql = "insert into user (id,name,password,age,phone ) values('" + user.getId() + "','" + user.getName()
				+ "','" + user.getPassword() + "','" + user.getAge() + "','" + user.getPhone() + "')";
		System.out.println(sql);
		rel = updateCommon(sql);
		return rel;
	}

	// 查询
	public List<User> search() {
		String sql = "SELECT * FROM `User`";
		List<User> list = new ArrayList();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con = openConnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				User user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
				list.add(user);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(con, st, rs);
		}
		return list;
	}

	// 根据姓名模糊查询
	public List<User> search(String name) {
		List<User> list = new ArrayList<User>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "select * from user where name like '%" + name + "%'";
		try {
			// 创建连接
			con = openConnection();
			// 创建执行对象
			st = con.createStatement();
			// 执行sql语句返回rs
			rs = st.executeQuery(sql);
			// 处理结果形成对象添加到列表中
			while (rs.next()) {
				list.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭
			closeAll(con, st, rs);
		}
		return list;
	}

	// 根据编号查询
	public List<User> search(int id) {
		List<User> list = new ArrayList<User>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con = openConnection();
			st = con.createStatement();
			rs = st.executeQuery("select * from user where id='" + id + "'");
			while (rs.next()) {

				list.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(con, st, rs);
		}
		return list;
	}

	// 修改密码
	public int checkReset(User user) {
		String sql = "UPDATE `studentSystemDB`.`User` SET `password` = '" + user.getPassword()
				+ "' WHERE `user`.`name` = '" + user.getName() + "'";
		return updateCommon(sql);
	}

	/*
	 * 注册新用户名检查 数据库中已存在相同用户名,返回false 否则,不存在相同用户名,用户名可用,返回true
	 */
	public boolean checkName(String name) {
		boolean type = true;
		String sql = "select `name` from `user`";
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		con = openConnection();
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				if (name.equals(rs.getString("name"))) {
					type = false;
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(con, st, rs);
		}
		return type;
	}

	public int checkUpdate(User user) {
		String sql = "UPDATE `studentSystemDB`.`User` SET `name`='" + user.getName() + "', `password`='"
				+ user.getPassword() + "', `age`='" + user.getAge() + "', `phone`='" + user.getPhone()
				+ "' WHERE `User`.`id` = '" + user.getId() + "'";
		return updateCommon(sql);

	}

	public int checkDelete(int id) {
		String sql = "DELETE FROM `studentSystemDB`.`User` WHERE `User`.`id` = '" + id + "'";
		return updateCommon(sql);
	}
}
