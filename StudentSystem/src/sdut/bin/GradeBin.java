package sdut.bin;

import java.util.List;

import sdut.dao.GradeDao;
import sdut.entity.Grade;

public class GradeBin {

	public List<Grade> search(Integer id) {
		return new GradeDao().search(id);
	}

	public List<Grade> search() {
		return new GradeDao().search();
	}

	public boolean add(Grade g) {
		if ((new GradeDao().add(g)) > 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean update(Grade g) {
		GradeDao gd = new GradeDao();
		if (gd.update(g) > 0)
			return true;
		else
			return false;
	}

	public boolean delete(Grade g) {
		GradeDao gd = new GradeDao();
		if (gd.delete(g) > 0)
			return true;
		else
			return false;
	}
}
