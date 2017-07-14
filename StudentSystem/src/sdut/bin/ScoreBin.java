package sdut.bin;

import java.util.List;

import sdut.dao.ScoreDao;
import sdut.entity.Score;

public class ScoreBin {

	public List<Score> search() {
		return new ScoreDao().search();
	}

	public List<Score> search(Integer id) {
		return new ScoreDao().search(id);
	}

	public boolean add(Score score) {
		if (!checkUpdate(score))
			return false;
		else {
			ScoreDao sd = new ScoreDao();
			int rel = sd.add(score);
			if (rel > 0) {
				return true;
			} else {
				return false;
			}
		}
	}

	public boolean delete(Score score) {
		ScoreDao sd = new ScoreDao();
		if (sd.delete(score) > 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean delete(int id) {
		ScoreDao sd = new ScoreDao();
		if (sd.delete(id) > 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean update(Score score) {
		if (!checkUpdate(score))
			return false;
		else {
			ScoreDao sd = new ScoreDao();
			if (sd.update(score) > 0) {
				return true;
			} else {
				return false;
			}
		}
	}

	public boolean checkUpdate(Score score) {
		ScoreDao sd = new ScoreDao();
		if (sd.checkSearch(score) > 0)
			return false;
		else
			return true;
	}

}
