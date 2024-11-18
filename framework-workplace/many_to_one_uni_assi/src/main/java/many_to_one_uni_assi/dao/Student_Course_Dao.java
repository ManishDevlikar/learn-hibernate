package many_to_one_uni_assi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import many_to_one_uni_assi.dto.Course;
import many_to_one_uni_assi.dto.Student;

public class Student_Course_Dao {
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
	private EntityManager manager = factory.createEntityManager();
	private EntityTransaction transaction = manager.getTransaction();

//	------------------------------------------------------------save------------------------------------------------------------------------------

	public void saveStudent(Student student) {
		transaction.begin();
		manager.persist(student);
		transaction.commit();
	}

	public void saveStudentList(List<Student> student) {
		for (Student stud : student) {
			transaction.begin();
			manager.persist(stud);
			transaction.commit();
		}
	}

	public void saveCourse(Course course) {
		transaction.begin();
		manager.persist(course);
		transaction.commit();
	}

	public void saveCourseList(List<Course> course) {
		for (Course cours : course) {
			transaction.begin();
			manager.persist(cours);
			transaction.commit();
		}
	}
//	------------------------------------------------------------find------------------------------------------------------------------------------

	public void findStudent(int id) {
		Student student = manager.find(Student.class, id);
		if (student != null) {
			System.out.println(student);
		} else {
			System.out.println("student not found");
		}
	}

	public void findCourse(int id) {
		Course course = manager.find(Course.class, id);
		if (course != null) {
			System.out.println(course);
		} else {
			System.out.println("course not found");
		}
	}

	public void findAllStudent() {
		Query query = manager.createQuery("select stud from Student stud");
		List<Student> list = query.getResultList();
		if (!list.isEmpty()) {
			for (Student student : list) {
				System.out.println(student);
			}
		}
	}

	public void findAllCouse() {
		Query query = manager.createQuery("select course from Course course");
		List<Course> list = query.getResultList();
		if (!list.isEmpty()) {
			for (Course course : list) {
				System.out.println(course);
			}
		}
	}

	public void findAllRecords() {
		Query query = manager.createQuery("select record from Student record INNER JOIN FETCH record.course");
		List<Student> studList = query.getResultList();

		for (Student student : studList) {
			System.out.println(student + " is enrolled in " + student.getCourse());

		}
	}
//	------------------------------------------------------------update----------------------------------------------------------------------------

	public void updateCouresName(int courseId, String newName) {
		Course course = manager.find(Course.class, courseId);
		if (course != null) {
			course.setName(newName);
			transaction.begin();
			manager.merge(course);
			transaction.commit();
		} else {
			System.out.println("course not found");
		}
	}

	public void updateCourseFees(int courseId, String newFees) {
		Course course = manager.find(Course.class, courseId);
		if (course != null) {
			course.setName(newFees);
			transaction.begin();
			manager.merge(course);
			transaction.commit();
		} else {
			System.out.println("course not found");
		}
	}

	public void updateStudentEmail(int courseId, String email) {
		Student student = manager.find(Student.class, courseId);
		if (student != null) {
			student.setEmail(email);
			transaction.begin();
			manager.merge(student);
			transaction.commit();
		} else {
			System.out.println("Student not found");
		}
	}

	public void updateStudentPhoneNo(int id, String phoneNo) {
		Student student = manager.find(Student.class, id);
		if (student != null) {
			student.setMobileNo(phoneNo);
			transaction.begin();
			manager.merge(student);
			transaction.commit();
		} else {
			System.out.println("Student not found");
		}
	}

	public void addNewStudent(int id, Student stud) {
		Course course = manager.find(Course.class, id);

		if (stud != null) {
			if (course != null) {

				stud.setCourse(course);
				transaction.begin();
				manager.merge(stud);
				transaction.commit();
			} else {
				System.out.println("course not found");
			}
		} else {
			System.out.println("Student not added");
		}
	}

	public void changeStudCourse(int studId, int courseId) {
		Student student = manager.find(Student.class, studId);
		Course course = manager.find(Course.class, courseId);
		if (student != null && course != null) {
			student.setCourse(course);
			transaction.begin();
			manager.merge(student);
			transaction.commit();
		} else {
			System.out.println("student not present");
		}

	}

	// ---------------------------------------------------------delete------------------------------------------------------------------------------

	public void removeStudent(int id) {
		Student student = manager.find(Student.class, id);
		if (student != null) {
			student.setCourse(null);
			transaction.begin();
			manager.remove(student);
			transaction.commit();
		}
	}

	public void removeCourse(int id) {
		Course course = manager.find(Course.class, id);
		Query query = manager.createQuery("select stud from Student stud");
		List<Student> list = query.getResultList();

		for (Student student : list) {
			if (student.getCourse().equals(course)) {
				student.setCourse(null);
			}
		}
		transaction.begin();
		manager.remove(course);
		transaction.commit();
	}
}
