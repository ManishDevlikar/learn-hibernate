package many_to_many_uni_assi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import many_to_many_uni_assi.dto.Employee;
import many_to_many_uni_assi.dto.Project;

public class Project_Employee_Dao {
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
	private EntityManager manager = factory.createEntityManager();
	private EntityTransaction transaction = manager.getTransaction();
//	--------------------------------------------save----------------------------------------------------------------------

	public void saveProject(Project project) {
		transaction.begin();
		manager.persist(project);
		transaction.commit();
	}

	public void saveEmployee(Employee employee) {
		transaction.begin();
		manager.persist(employee);
		transaction.commit();
	}

	public void saveProject(List<Project> project) {
		for (Project pro : project) {
			transaction.begin();
			manager.persist(pro);
			transaction.commit();
		}
	}
//-----------------------------------------------update----------------------------------------------------------------------

	public void addNewEmployee(int projId, Employee employee) {
		Project project = manager.find(Project.class, projId);
		if (project != null) {
			project.getEmployees().add(employee);
			transaction.begin();
			manager.merge(project);
			transaction.commit();
		}
	}

	public void changeDeadLine(int projId, String date) {
		Project project = manager.find(Project.class, projId);
		if (project != null) {
			project.setEndDate(date);
			transaction.begin();
			manager.merge(project);
			transaction.commit();
		}
	}

	public void addExistingEmployeeToProject(int empId, int ProjId) {
		Project project = manager.find(Project.class, ProjId);
		Employee employee = manager.find(Employee.class, empId);

		if (project != null && employee != null) {
			if (!project.getEmployees().contains(employee)) {
				project.getEmployees().add(employee);
				transaction.begin();
				manager.merge(project);
				transaction.commit();
			} else {
				System.out.println("employee is already present");
			}
		} else {
			System.out.println("please pass valid id's");
		}
	}

//	------------------------------------------------remove---------------------------------------------------------------------
	public void removeEmployee(int empId) {
		Employee employee = manager.find(Employee.class, empId);
		Query query = manager.createQuery("select DISTINCT record from Project record");
		List<Project> list = query.getResultList();

		transaction.begin();
		for (Project project : list) {
			project.getEmployees().remove(employee);
			manager.merge(project);
		}
		manager.remove(employee);
		transaction.commit();
	}

	public void removeProject(int projectId) {
		Project project = manager.find(Project.class, projectId);
		if (project != null) {
			project.setEmployees(null);
			transaction.begin();
			manager.remove(project);
			transaction.commit();
		} else {
			System.out.println("project not found");
		}
	}

	public void removeEmployeeFromProject(int empId, int ProjId) {
		Project project = manager.find(Project.class, ProjId);
		Employee employee = manager.find(Employee.class, empId);

		if (project != null) {
			project.getEmployees().remove(employee);
			transaction.begin();
			manager.merge(project);
			transaction.commit();
		}
	}
//	----------------------------------------------find--------------------------------------------------------------------------

	public void findEmployee(int empId) {
		Employee employee = manager.find(Employee.class, empId);
		if (employee != null) {
			System.out.println(employee);
		}
	}

	public void findAllEmployee() {
		Query query = manager.createQuery("select emp from Employee emp");
		List<Employee> empList = query.getResultList();
		for (Employee employee : empList) {
			System.out.println(employee);
		}
	}

	public void findProject(int projectId) {
		Project project = manager.find(Project.class, projectId);
		if (project != null) {
			System.out.println(project);
		}
	}

	public void findAllProject() {
		Query query = manager.createQuery("select project from Project project");
		List<Project> projList = query.getResultList();
		for (Project project : projList) {
			System.out.println(project);
		}
	}

	public void findAllRecords() {
		Query query = manager
				.createQuery("select Distinct record from Project record INNER JOIN FETCH record.employees");
		List<Project> list = query.getResultList();
		for (Project project : list) {
			System.out.println(project);
			List<Employee> empList = project.getEmployees();
			for (Employee employee : empList) {
				System.out.println(employee);
			}
			System.out.println();
		}
	}
}
