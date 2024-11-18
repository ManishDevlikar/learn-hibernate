package generated_value_ex.controller;

import generated_value_ex.dao.Student_Course_Dao;
import generated_value_ex.dta.Course;
import generated_value_ex.dta.Student;

public class Student_Course_Controller {
	static Student_Course_Dao dao = new Student_Course_Dao();

	public static void main(String[] args) {
		Student student = new Student();
		student.setName("max");

		Course course = new Course();
		course.setName("SQL");
		student.setCourse(course);
		course.setStudent(student);

		dao.saveStudent(student);
//		dao.removeStudent(1);
	}

}
