package many_to_one_uni.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import many_to_one_uni.dto.Department;
import many_to_one_uni.dto.Employee;

public class Department_Employee_dao {
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
	private EntityManager manager = factory.createEntityManager();
	private EntityTransaction transaction = manager.getTransaction();

//	--------------------------------save-------------------------------------

	public void saveDepartment(Department department) {
		transaction.begin();
		manager.persist(department);
		transaction.commit();
	}

	public void saveMultipleDepartMent(List<Department> department) {
		transaction.begin();
		for (Department department2 : department) {
			manager.persist(department2);
		}
		transaction.commit();
	}

	public void saveEmployee(Employee employee) {
		transaction.begin();
		manager.persist(employee);
		transaction.commit();
	}

//	----------------------------------update-----------------------------------

	public void updateDepartmentName(int id, String name) {
		Department department = manager.find(Department.class, id);
		if (department != null) {
			department.setName(name);
			transaction.begin();
			manager.merge(department);
			transaction.commit();
		} else {
			System.out.println("department not found");
		}
	}

	public void updateDepartmentPhoneNo(int id, long phoneNo) {
		Department department = manager.find(Department.class, id);
		if (department != null) {
			department.setPhoneNo(phoneNo);
			transaction.begin();
			manager.merge(department);
			transaction.commit();
		} else {
			System.out.println("department not found");
		}
	}

	public void updateDepartmentEmail(int id, String email) {
		Department department = manager.find(Department.class, id);
		if (department != null) {
			department.setEmail(email);
			transaction.begin();
			manager.merge(department);
			transaction.commit();
		} else {
			System.out.println("department not found");
		}
	}

	public void updateEmployeeAddress(int empId, String address) {
		Employee employee = manager.find(Employee.class, empId);
		if (employee != null) {
			employee.setAddress(address);
			transaction.begin();
			manager.merge(employee);
			transaction.commit();
		} else {
			System.out.println("employee not present");
		}
	}

	public void updateEmployeeSalary(int empId, String salary) {
		Employee employee = manager.find(Employee.class, empId);
		if (employee != null) {
			employee.setSal(salary);
			transaction.begin();
			manager.merge(employee);
			transaction.commit();
		}
	}

	public void updateDepartmentsEmployee(int departmentId, int empId) {
		Department department = manager.find(Department.class, departmentId);
		if (department != null) {
			Employee employee = manager.find(Employee.class, empId);
			if (employee != null) {
				transaction.begin();
				department.setEmployee(employee);
				manager.merge(department);
				transaction.commit();
			} else {
				System.out.println("Employee not found");
			}
		} else {
			System.out.println("department not found");
		}
	}

	public void addNewDepartMent(int empId, Department dept) {
		Employee employee = manager.find(Employee.class, empId);

		if (dept != null) {
			dept.setEmployee(employee);
			transaction.begin();
			manager.merge(dept);
			transaction.commit();
		}
	}

//---------------------------------find----------------------------------------------
	public void findAllRecords() {
		Query query = manager.createQuery("select record from Department record");
		List<Department> list = query.getResultList();
		for (Department dep : list) {
			System.out.println(dep);

			if (dep.getEmployee() != null) {
				System.out.println(dep.getEmployee());
			}
		}
	}

	public void findAllEmployee() {
		Query query = manager.createQuery("select emp from Employee emp");
		List<Employee> list = query.getResultList();
		for (Employee employee : list) {
			System.out.println(employee);
		}
	}

	public void findAllDepartment() {
		Query query = manager.createQuery("select record from Department record");
		List<Department> list = query.getResultList();
		for (Department dep : list) {
			System.out.println(dep + " Associate Emp" + dep.getEmployee());
		}
	}

	public void findEmployee(int empId) {
		Employee employee = manager.find(Employee.class, empId);
		if (employee != null) {
			System.out.println(employee);
		} else {
			System.out.println("employee not found");
		}
	}

	public void findDepartment(int depId) {
		Department department = manager.find(Department.class, depId);

		if (department != null) {
			System.out.println(department);
		} else {
			System.out.println("department id not found");
		}
	}

//	------------------------------------delete---------------------------------------

	public void removeEmployeeFromDepartment(int departMentId) {
		Department department = manager.find(Department.class, departMentId);
		if (department != null) {
			transaction.begin();
			department.setEmployee(null);
			manager.merge(department);
			transaction.commit();
		}
	}

	public void removeDepartment(int deptId) {
		Department department = manager.find(Department.class, deptId);
		if (department != null) {
			department.setEmployee(null);
			transaction.begin();
			manager.remove(department);
			transaction.commit();
		}
	}

	public void removeEmployee(int empId) {
		Employee employee = manager.find(Employee.class, empId);
		Query query = manager.createQuery("select dep from Department dep");
		List<Department> list = query.getResultList();

		if (employee != null) {
			for (Department department : list) {
				if (department.getEmployee() != null && department.getEmployee().equals(employee)) {
					department.setEmployee(null);
				}
			}
			transaction.begin();
			manager.remove(employee);
			transaction.commit();
		} else {
			System.out.println("Employee not found");
		}

	}
}
