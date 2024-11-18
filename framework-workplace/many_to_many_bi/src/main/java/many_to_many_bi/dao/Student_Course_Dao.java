package many_to_many_bi.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import many_to_many_bi.dto.Courses;
import many_to_many_bi.dto.Student;

public class Student_Course_Dao {
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
	private EntityManager manager = factory.createEntityManager();
	private EntityTransaction transaction = manager.getTransaction();

//	---------------------------------------------------save-------------------------------------------------------------------------------------

	public void saveStudent(List<Student> students) {
		for (Student student : students) {
			transaction.begin();
			manager.persist(student);
			transaction.commit();
		}
	}

	public void saveStudents(List<Student> students) {
		for (Student student : students) {
			List<Courses> courseList = student.getCourses();
			for (Courses course : courseList) {
				course.setStudents(students);
			}
			transaction.begin();
			manager.persist(student);
			transaction.commit();
		}

	}

	public void saveCourse(List<Courses> courses) {
		for (Courses courses2 : courses) {
			transaction.begin();
			manager.persist(courses2);
			transaction.commit();
		}
	}

	public void saveCourses(List<Courses> courses) {
		for (Courses course : courses) {
			List<Student> studentList = course.getStudents();
			for (Student student : studentList) {
				student.setCourses(courses);
			}
			transaction.begin();
			manager.persist(course);
			transaction.commit();
		}
	}

//	-----------------------------------------------------------find-----------------------------------------------------------------------------

	public void findStudent(int studId) {
		Student student = manager.find(Student.class, studId);
		if (student != null) {
			System.out.println(student);
		} else {
			System.out.println("student not found");
		}
	}

	public Student viewStudent(int studId) {
		Student student = manager.find(Student.class, studId);
		if (student != null) {
			return student;
		} else {
			return null;
		}
	}

	public void findStudentWithCourses(int studId) {
		Student student = manager.find(Student.class, studId);
		if (student != null) {
			System.out.println(student);
			List<Courses> courseList = student.getCourses();
			if (!courseList.isEmpty()) {
				for (Courses courses : courseList) {
					System.out.println(courses);
				}
			} else {
				System.out.println("Student does not enrolled in any course");
			}
		} else {
			System.out.println("invalid student id");
		}
	}

	public void findCourse(int id) {
		Courses courses = manager.find(Courses.class, id);
		if (courses != null) {
			System.out.println(courses);
		} else {
			System.out.println("Course not found");
		}
	}

	public void findCourseWithStudents(int courseId) {
		Courses courses = manager.find(Courses.class, courseId);

		if (courses != null) {
			System.out.println(courses);
			for (Student student : courses.getStudents()) {
				if (student != null) {
					System.out.println(student);
				}
			}
		}
	}

	public void findAllRecords() {
		Query query = manager.createQuery("select distinct record from Student record INNER JOIN FETCH record.courses");
		List<Student> list = query.getResultList();
		for (Student student : list) {
			System.out.println("Student: " + student);
			for (Courses course : student.getCourses()) {
				System.out.println(course);
			}
			System.out.println();
		}
	}

	public void ViewAll() {
		Query query = manager.createQuery("select student from Student student");
		List<Student> list = query.getResultList();
		for (Student student : list) {
			System.out.println("Student: " + student);
			for (Courses course : student.getCourses()) {
				System.out.println(course);
			}
			System.out.println();
		}
	}

//	-------------------------------------------------update-------------------------------------------------------------------------------------

	public void addNewStudentToCourse(int courseId, Student student) {
		Courses courses = manager.find(Courses.class, courseId);
		List<Courses> list = new ArrayList();
		if (courses != null) {
			courses.getStudents().add(student);
			list.add(courses);
			student.setCourses(list);
			transaction.begin();
			manager.merge(student);
			manager.merge(courses);
			transaction.commit();
		} else {
			System.out.println("course not found");
		}
	}

	public void addNewStudentToCourse(int courseId, List<Student> students) {
		Courses courses = manager.find(Courses.class, courseId);
		List<Courses> courseList = new ArrayList();
		if (courses != null) {
			courseList.add(courses);
			for (Student student : students) {
				courses.getStudents().add(student);
				student.setCourses(courseList);
				transaction.begin();
				manager.merge(student);
				transaction.commit();
			}
		} else {
			System.out.println("course not found");
		}
	}

	public void addNewCourseToStudent(int studId, List<Courses> courses) {
		Student student = manager.find(Student.class, studId);
		List<Student> studList = new ArrayList();
		if (student != null) {
			studList.add(student);
			for (Courses course : courses) {
				course.setStudents(studList);
				student.getCourses().add(course);
				transaction.begin();
				manager.merge(course);
				transaction.commit();
			}
		}
	}

	public void addNewCourseToStudent(int studId, Courses course) {
		Student student = manager.find(Student.class, studId);
		List<Student> list = new ArrayList();
		if (student != null) {
			student.getCourses().add(course);
			list.add(student);
			course.setStudents(list);
			transaction.begin();
			manager.merge(course);
			manager.merge(student);
			transaction.commit();
		} else {
			System.out.println("student not found");
		}
	}

	public void updateStudentCourses(int studId, int courseId) {
		Student student = manager.find(Student.class, studId);
		Courses courses = manager.find(Courses.class, courseId);

		if (student != null && courses != null) {
			student.getCourses().add(courses);
			courses.getStudents().add(student);
			transaction.begin();
			manager.merge(student);
			transaction.commit();
		} else {
			System.out.println("record not found");
		}
	}

	public void updateCourseStudents(int courseId, int studId) {
		Student student = manager.find(Student.class, studId);
		Courses courses = manager.find(Courses.class, courseId);

		if (student != null && courses != null) {
			student.getCourses().add(courses);
			courses.getStudents().add(student);
			transaction.begin();
			manager.merge(courses);
			transaction.commit();
		}
	}

	public void updateCourseCode(int couresId, String code) {
		Courses courses = manager.find(Courses.class, couresId);
		if (courses != null) {
			courses.setCode(code);
			transaction.begin();
			manager.merge(courses);
			transaction.commit();
		} else {
			System.out.println("course not found");
		}
	}

	public void updateStudentEmail(int studId, String email) {
		Student student = manager.find(Student.class, studId);
		if (student != null) {
			student.setEmail(email);
			transaction.begin();
			manager.merge(student);
			transaction.commit();
		}
	}

//	------------------------------------------------------remove---------------------------------------------------------------------------------
	public void removeStudent(int studId) {
		Student student = manager.find(Student.class, studId);
		if (student != null) {
			List<Courses> couresList = student.getCourses();
			for (Courses courses : couresList) {
				courses.getStudents().remove(student);
			}
			student.setCourses(null);
			transaction.begin();
			manager.remove(student);
			transaction.commit();
		} else {
			System.out.println("student not found");
		}
	}

	public void removeCourse(int couresId) {
		Courses course = manager.find(Courses.class, couresId);
		if (course != null) {
			List<Student> studList = course.getStudents();
			for (Student student : studList) {
				student.getCourses().remove(course);
			}
			course.setStudents(null);
			transaction.begin();
			manager.remove(course);
			transaction.commit();
		} else {
			System.out.println("course not found");
		}
	}
}
