package hibernate_demo_1.controller;

import hibernate_demo_1.dao.StudentDao;
import hibernate_demo_1.dto.Student;

public class StudentController {
	static StudentDao dao = new StudentDao();

	public static void main(String[] args) {
		Student student = new Student();
//		student.setId(103);
//		student.setName("batman");
//		dao.saveS(student);

//		dao.findS(100);
//		dao.deleteS(103);
		dao.findAllS();

//		dao.updateS(100, "manish");
	}
}
