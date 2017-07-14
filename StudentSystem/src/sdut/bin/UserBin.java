package sdut.bin;

import java.util.List;

import sdut.dao.UserDao;
import sdut.entity.User;

public class UserBin {
	// 登陆
	public boolean login(User user) {
		UserDao ud = new UserDao();
		return ud.checkLogin(user);
	}
	// 修改密码
	public boolean reset(User user) {
		UserDao ud = new UserDao();
		if (ud.checkReset(user) > 0)
			return true;
		else
			return false;
	}
	// 注册
	public boolean register(User user) {
		if (checkName(user.getName()))
			return false;
		else {
			UserDao ud = new UserDao();

			if (ud.checkRegister(user) > 0)
				return true;
			else
				return false;
		}
	}
	// 查询
	public List<User> search() {
		UserDao ud = new UserDao();
		return ud.search();
	}
	// 根据编号查询
	public List<User> search(Integer id) {
		UserDao ud = new UserDao();
		return ud.search(id);

	}
	// 根据姓名查询
	public List<User> search(String name) {
		UserDao ud = new UserDao();
		return ud.search(name);
	}
	// 检查用户名是否重复
	public boolean checkName(String name) {
		UserDao ud = new UserDao();
		if (ud.checkName(name))
			return true;
		else
			return false;
	}
	// 添加信息
	public boolean add(User user) {
		UserDao ud = new UserDao();
		int rel = ud.addUser(user);
		if (rel > 0) {
			return true;
		} else {
			return false;
		}
	}
	// 删除信息
	public boolean delete(int id) {
		UserDao ud = new UserDao();
		if (ud.checkDelete(id) > 0) {
			return true;
		} else {
			return false;
		}
	}
	// 更新信息
	public boolean update(User user) {
		UserDao ud = new UserDao();
		if (ud.checkUpdate(user) > 0) {
			return true;
		} else {
			return false;
		}
	}
}
