package generated_value_ex.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import generated_value_ex.dta.Student;

public class Student_Course_Dao {
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
	private EntityManager manager = factory.createEntityManager();
	private EntityTransaction transaction = manager.getTransaction();

	public void saveStudent(Student student) {
		transaction.begin();
		manager.persist(student);
		transaction.commit();
	}

	public void removeStudent(int id) {
		Student student = manager.find(Student.class, id);

		if (student != null) {
			student.setCourse(null);

		}
		transaction.begin();
		manager.remove(student);
		transaction.commit();
	}
}
