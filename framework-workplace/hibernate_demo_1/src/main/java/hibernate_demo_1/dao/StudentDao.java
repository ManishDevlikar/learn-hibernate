package hibernate_demo_1.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import hibernate_demo_1.dto.Student;

public class StudentDao {
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
	private EntityManager manager = factory.createEntityManager();
	private EntityTransaction transaction = manager.getTransaction();

	public void saveS(Student student) {
		transaction.begin();
		manager.persist(student);
		transaction.commit();
	}

	public void findS(int id) {
		Student student = manager.find(Student.class, id);
		System.out.println(student);
	}

	public void deleteS(int id) {
		Student student = manager.find(Student.class, id);
		transaction.begin();
		manager.remove(student);
		transaction.commit();
	}

	public void findAllS() {
		Query q = manager.createQuery("from Student");
		List<Student> studentList = q.getResultList();
		studentList.stream().forEach(System.out::println);
	}

	public Student updateS(int id, String name) {
		Student student = manager.find(Student.class, id);
		student.setName(name);
		transaction.begin();
		manager.merge(student);
		transaction.commit();
		return student;
	}
}
