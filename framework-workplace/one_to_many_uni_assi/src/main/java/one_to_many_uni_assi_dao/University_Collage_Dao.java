package one_to_many_uni_assi_dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import one_to_many_uni_assi_dto.College;
import one_to_many_uni_assi_dto.University;

public class University_Collage_Dao {
	Scanner sc = new Scanner(System.in);
	private EntityManagerFactory entityManagerFactory = null;
	private EntityManager entityManager = null;
	private EntityTransaction entityTransaction = null;

	public EntityManager getManager() {
		entityManagerFactory = Persistence.createEntityManagerFactory("dev");
		entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}

	public void saveUniversity(University university) {
		entityManager = getManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(university);
		entityTransaction.commit();
	}

	public void deleteUniversityWithColleges(int id) {
		entityManager = getManager();
		entityTransaction = entityManager.getTransaction();
		University university = entityManager.find(University.class, id);
		if (university != null) {
			entityTransaction.begin();
			entityManager.remove(university);
			entityTransaction.commit();
		}
	}

	public void findUniversity(int id) {
		entityManager = getManager();
		University university = entityManager.find(University.class, id);
		if (university != null) {
			System.out.println(university.getId() + " " + university.getName());
			if (university != null) {
				for (College college : university.getCollege()) {
					System.out.println(college);
				}
			}
		} else {
			System.out.println("wrong input");
		}
	}

	public void updateUniversity(University university) {
		entityManager = getManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(university);
		entityTransaction.commit();
	}

	public void findAllUniversitiesAndColleges() {
		entityManager = getManager();
		Query query = entityManager.createQuery(
				"select DISTINCT university from University university INNER JOIN FETCH university.college");

		List<University> list = query.getResultList();
		for (University university : list) {
			if (university != null) {
				System.out.println(university.getId() + " " + university.getName());
				if (university != null) {
					for (College college : university.getCollege()) {
						System.out.println(college);
					}
				}
			} else {
				System.out.println("it's Empty");
			}
		}

	}

	public void findAllUniversities() {
		entityManager = getManager();
		Query query = entityManager.createQuery("select uni from University uni");
		List<University> list = query.getResultList();

		for (University university : list) {
			System.out.println(university);
		}
	}

	public void findAllColleges() {
		entityManager = getManager();
		Query query = entityManager.createQuery("select col from College col");
		List<College> list = query.getResultList();
		for (College college : list) {
			System.out.println(college);
		}
	}

	public int getCollageId() {
		entityManager = getManager();
		Query query = entityManager.createQuery("select college from College college");
		List<College> list = query.getResultList();
		int id = 100;
		for (College collage : list) {
			id = collage.getId();
		}
		return ++id;
	}

	public int getUniversityId() {
		entityManager = getManager();
		Query query = entityManager.createQuery("select university from University university ");
		List<University> list = query.getResultList();
		int id = 100;
		for (University university : list) {
			id = university.getId();
		}
		return ++id;
	}

	public void insertNewUniversity() {
		EntityManager manager = getManager();
		entityTransaction = manager.getTransaction();
		University university = new University();
		int universityId = getUniversityId();
		System.out.println("university Id: " + universityId);
		university.setId(universityId);
		System.out.println("Enter university Name");
		String universityName = sc.next();
		university.setName(universityName);
		System.out.println("Enter university location");
		String universityLocation = sc.next();
		university.setLocation(universityLocation);
		System.out.println("Enter university President Name");
		String UniversityPresName = sc.next();
		university.setPresident(UniversityPresName);
		List<College> colleges = new ArrayList<College>();

		System.out.println("do you want to add Collages (Yes or No)");
		String decision = sc.next();

		if (decision.equalsIgnoreCase("yes")) {
			System.out.println("how many collages do you want to approved");
			int input = sc.nextInt();

			for (int i = 1; i <= input; i++) {
				College college = new College();
				int collegeId = getCollageId();
				college.setId(collegeId);
				System.out.println("Collage id :" + collegeId);
				System.out.println("enter collage name");
				String collageName = sc.next();
				college.setName(collageName);
				System.out.println("enter college location");
				String collegeLoc = sc.next();
				college.setLocation(collegeLoc);
				System.out.println("enter College rating");
				int collegeRating = sc.nextInt();
				college.setRating(collegeRating);
				System.out.println("enter field Of Study");
				String fieldOfStudy = sc.next();
				college.setFieldOfStudy(fieldOfStudy);
				colleges.add(college);
				entityTransaction.begin();
				manager.merge(college);
				entityTransaction.commit();
			}
		} else {
			entityTransaction.begin();
			manager.persist(university);
			entityTransaction.commit();
		}
		entityTransaction.begin();
		university.setCollege(colleges);
		manager.merge(university);
		entityTransaction.commit();

	}

	public void addColleges(int id) {
		entityManager = getManager();
		entityTransaction = entityManager.getTransaction();
		University university = entityManager.find(University.class, id);
		List<College> colleges = university.getCollege();

		if (university != null) {
			System.out.println("how many collages do you want to approved");
			int input = sc.nextInt();

			for (int i = 1; i <= input; i++) {
				College college = new College();
				int collegeId = getCollageId();
				college.setId(collegeId);
				System.out.println("Collage id :" + collegeId);
				System.out.println("enter collage name");
				String collageName = sc.next();
				college.setName(collageName);
				System.out.println("enter college location");
				String collegeLoc = sc.next();
				college.setLocation(collegeLoc);
				System.out.println("enter College rating");
				int collegeRating = sc.nextInt();
				college.setRating(collegeRating);
				System.out.println("enter field Of Study");
				String fieldOfStudy = sc.next();
				college.setFieldOfStudy(fieldOfStudy);
				colleges.add(college);
				entityTransaction.begin();
				university.setCollege(colleges);
				entityManager.merge(university);
				entityTransaction.commit();
			}
		}
	}

	public void updateUniversityById(int id) {
		entityManager = getManager();
		entityTransaction = entityManager.getTransaction();
		University university = entityManager.find(University.class, id);
		if (university != null) {
			List<College> collages = university.getCollege();
			System.out.println("University Id : " + university.getId());
			System.out.println("Enter university Name");
			String universityName = sc.next();
			university.setName(universityName);
			System.out.println("Enter university location");
			String universityLocation = sc.next();
			university.setLocation(universityLocation);
			System.out.println("Enter university President Name");
			String UniversityPresName = sc.next();
			university.setPresident(UniversityPresName);
			entityTransaction.begin();
			university.setCollege(collages);
			entityManager.merge(university);
			entityTransaction.commit();

		} else {
			System.out.println("university not found");
		}

	}

	public void deleteUniversity(int universityId, int assignNew) {
		entityManager = getManager();
		entityTransaction = entityManager.getTransaction();
		University university = entityManager.find(University.class, universityId);
		University universityNew = entityManager.find(University.class, assignNew);
		List<College> list = universityNew.getCollege();
//		List<College> newList = new ArrayList<College>();
		if (university != null) {
			List<College> colleges = university.getCollege();
			entityTransaction.begin();
			entityManager.remove(university);
			entityTransaction.commit();

			if (!colleges.isEmpty()) {

				for (College college : colleges) {
					if (universityNew != null) {
						entityTransaction.begin();
						list.add(college);
						universityNew.setCollege(list);
						entityManager.merge(universityNew);
						entityTransaction.commit();
					} else {

						entityTransaction.begin();
						entityManager.merge(college);
						entityTransaction.commit();
					}
				}
			} else {
				System.out.println("no colleges found");
			}
		} else {
			System.out.println("univesity is empty");
		}
	}

	public void updateCollegeUniversity(int uniId, int colId, int newUniId) {
		entityManager = getManager();
		entityTransaction = entityManager.getTransaction();
		University university = entityManager.find(University.class, uniId);
		University newUniversity = entityManager.find(University.class, newUniId);
		College college = entityManager.find(College.class, colId);
		List<College> list = newUniversity.getCollege();

		if (university != null && newUniversity != null && college != null) {
			entityTransaction.begin();
			university.getCollege().remove(college);
			list.add(college);
			entityManager.merge(newUniversity);
			entityTransaction.commit();

		} else {
			System.out.println("check your inputs");
		}

	}

	public void updateCollageById(int collageId) {
		entityManager = getManager();
		entityTransaction = entityManager.getTransaction();
		College college = entityManager.find(College.class, collageId);

		if (college != null) {
			System.out.println("college Id" + college.getId());
			System.out.println("insert new college Name");
			String newName = sc.next();
			college.setName(newName);
			System.out.println("update rating");
			int newRating = sc.nextInt();
			college.setRating(newRating);
			System.out.println("change Field Of Study");
			String newFieldOfStudy = sc.next();
			college.setFieldOfStudy(newFieldOfStudy);
			entityTransaction.begin();
			entityManager.merge(college);
			entityTransaction.commit();

		}
	}

	public void removeCollegesById(int universityId, int collegeId) {
		entityManager = getManager();
		entityTransaction = entityManager.getTransaction();
		University university = entityManager.find(University.class, universityId);
		if (university != null) {
			College college = entityManager.find(College.class, collegeId);
			if (college != null) {
				entityTransaction.begin();
				university.getCollege().remove(college);
				entityManager.remove(college);
				entityTransaction.commit();
			} else {
				System.out.println("college not found");
			}

		} else {
			System.out.println("university not found");
		}
	}

}
