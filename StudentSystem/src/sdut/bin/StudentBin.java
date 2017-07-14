package sdut.bin;

import java.util.List;

import sdut.dao.StudentDao;
import sdut.entity.Student;

public class StudentBin {
	
	public List<Student> search(){
		return new StudentDao().search();
	}
	public List<Student> search(String name){
		return new StudentDao().search(name);
	}
	public List<Student> search(Integer id){
		return new StudentDao().search(id);
	}
	public boolean register(Student std) {
		 StudentDao sd =new StudentDao();
		 if(sd.register(std)>0)
			 return true;
		 else
			 return false;
	}
	public boolean add(Student std) {
		 StudentDao sd =new StudentDao();
		 if(sd.add(std)>0)
			 return true;
		 else
			 return false;
	}
	public boolean delete(int id) {
		 StudentDao sd =new StudentDao();
		 if(sd.delete(id)>0)
			 return true;
		 else
			 return false;
	}
	public boolean update(Student std) {
		 StudentDao sd =new StudentDao();
		 if(sd.update(std)>0)
			 return true;
		 else
			 return false;
	}
	public boolean login(Student s) {
		StudentDao sd =new StudentDao();
		return sd.checkLogin(s);
	}
}
