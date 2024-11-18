package many_to_one_uni.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import many_to_one_uni.dao.Department_Employee_dao;
import many_to_one_uni.dto.Department;
import many_to_one_uni.dto.Employee;

public class Department_Employee_controller {
	static Scanner sc = new Scanner(System.in);
	static Department_Employee_dao dao = new Department_Employee_dao();

	public static void main(String[] args) {
		runApplication();
//		dao.removeEmployee(102);

	}

	public static void runApplication() {
		System.out.println("Enter your choice : \n1: To Add Department " + "\n2: To Add Employee "
				+ "\n3: change departmets employee " + "\n4: Add new Department to employee "
				+ "\n5: remove employee from department " + "\n6: remove department "
				+ "\n7: remove employee \n8: find employee \n9: find department \n10: find all records \n11: exit");

		int yourChoice = sc.nextInt();

		switch (yourChoice) {
		case 1:
			System.out.println("Do you want to add new department(yes/no)");
			String newDeptToAdd = sc.next();
			if (newDeptToAdd.equalsIgnoreCase("yes")) {
				List<Department> deptList = new ArrayList<Department>();
				System.out.println("how many department you want to add");
				int totalDepartment = sc.nextInt();
				for (int i = 1; i <= totalDepartment; i++) {
					Department department = new Department();
					System.out.println("Enter department Id");
					int newDeptId = sc.nextInt();
					department.setId(newDeptId);
					System.out.println("Enter department Name");
					String newDeptName = sc.next();
					department.setName(newDeptName);
					System.out.println("Enter department email");
					String newDeptEmail = sc.next();
					department.setEmail(newDeptEmail);
					System.out.println("Enter depatment Phone No");
					long newDeptPhoneNo = sc.nextLong();
					department.setPhoneNo(newDeptPhoneNo);
					deptList.add(department);
				}
				System.out.println("Do you want to set Employee (yes/no)");
				String newEmployeeToAdd = sc.next();
				if (newEmployeeToAdd.equalsIgnoreCase("yes")) {
					Employee employee = new Employee();
					System.out.println("enter employee id");
					int newEmpId = sc.nextInt();
					employee.setId(newEmpId);
					System.out.println("enter employee name");
					String newEmpName = sc.next();
					employee.setName(newEmpName);
					System.out.println("enter employee sal");
					String newSalToAdd = sc.next();
					employee.setSal(newSalToAdd);
					System.out.println("enter employee address");
					String newEmpAdd = sc.next();
					employee.setAddress(newEmpAdd);
					for (Department department : deptList) {
						department.setEmployee(employee);
					}
					dao.saveMultipleDepartMent(deptList);
					runApplication();
					break;
				} else {
					dao.saveMultipleDepartMent(deptList);
					runApplication();
					break;
				}
			} else {
				runApplication();
				break;
			}
		case 2:
			System.out.println("Do you want to Add Employee (yes/no)");
			String newEmployeeToAdd = sc.next();
			if (newEmployeeToAdd.equalsIgnoreCase("yes")) {
				Employee employee = new Employee();
				System.out.println("enter employee id");
				int newEmpId = sc.nextInt();
				employee.setId(newEmpId);
				System.out.println("enter employee name");
				String newEmpName = sc.next();
				employee.setName(newEmpName);
				System.out.println("enter employee sal");
				String newSalToAdd = sc.next();
				employee.setSal(newSalToAdd);
				System.out.println("enter employee address");
				String newEmpAdd = sc.next();
				employee.setAddress(newEmpAdd);
				dao.saveEmployee(employee);
				runApplication();
				break;
			} else {
				runApplication();
				break;
			}
		case 3:

			System.out.println("Do you want to Change Employee (yes/no)");
			String inputToChange = sc.next();
			if (inputToChange.equalsIgnoreCase("yes")) {

				System.out.println("To change depatments employee enter department id:");
				int deptIdToChange = sc.nextInt();
				System.out.println("enter employee id which you want to set in departmet");
				int empId = sc.nextInt();
				dao.updateDepartmentsEmployee(deptIdToChange, empId);
				runApplication();
				break;
			} else {
				runApplication();
				break;
			}

		case 4:
			System.out.println("Do you want to add department to Employee (yes/no)");
			String inputToAddDepartment = sc.next();
			if (inputToAddDepartment.equalsIgnoreCase("yes")) {
				System.out.println("enter employee id: ");
				int empId = sc.nextInt();
				System.out.println("Enter New Departmets Details:");
				Department department = new Department();
				System.out.println("Enter department Id");
				int newDeptId = sc.nextInt();
				department.setId(newDeptId);
				System.out.println("Enter department Name");
				String newDeptName = sc.next();
				department.setName(newDeptName);
				System.out.println("Enter department email");
				String newDeptEmail = sc.next();
				department.setEmail(newDeptEmail);
				System.out.println("Enter depatment Phone No");
				long newDeptPhoneNo = sc.nextLong();
				department.setPhoneNo(newDeptPhoneNo);
				dao.addNewDepartMent(empId, department);
				runApplication();
				break;
			} else {
				runApplication();
				break;
			}
		case 5:
			System.out.println("Do you want to remove employee from department (yes/no)");
			String inputToRemoveDept = sc.next();
			if (inputToRemoveDept.equalsIgnoreCase("yes")) {
				System.out.println("to remove employee from department enter department id:");
				int deptId = sc.nextInt();
				dao.removeEmployeeFromDepartment(deptId);
				runApplication();
				break;
			} else {
				runApplication();
				break;
			}
		case 6:
			System.out.println("Do you want to Delete department (yes/no)");
			String inputToDeleteDept = sc.next();
			if (inputToDeleteDept.equalsIgnoreCase("yes")) {
				System.out.println("enter depatment id to delete department");
				int deptId = sc.nextInt();
				dao.removeDepartment(deptId);
				runApplication();
				break;
			} else {
				runApplication();
				break;
			}

		case 7:
			System.out.println("Do you want to Delete Employee (yes/no)");
			String inputToDeleteEmp = sc.next();
			if (inputToDeleteEmp.equalsIgnoreCase("yes")) {
				System.out.println("Enter employee id to delete");
				int empId = sc.nextInt();
				dao.removeEmployee(empId);
				runApplication();
				break;
			} else {
				runApplication();
				break;
			}
		case 8:
			System.out.println("Enter employee id to find");
			int findEmpById = sc.nextInt();
			dao.findEmployee(findEmpById);
			runApplication();
			break;

		case 9:
			System.out.println("Enter department id to find");
			int findDeptById = sc.nextInt();
			dao.findDepartment(findDeptById);
			runApplication();
			break;
		case 10:
			System.out.println("All Records Are :");
			dao.findAllRecords();
			runApplication();
			break;
		case 11:
			System.out.println("Do you want to Exit (yes/no)");
			String inputToExit = sc.next();
			if (inputToExit.equalsIgnoreCase("yes")) {
				System.out.println("Thank you");
				break;
			} else {
				runApplication();
				break;
			}
		default:
			System.out.println("Enter 11 to Exit");
			runApplication();
			break;
		}
	}
}
