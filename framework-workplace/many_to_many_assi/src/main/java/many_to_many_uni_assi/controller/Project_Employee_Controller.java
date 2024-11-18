package many_to_many_uni_assi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import many_to_many_uni_assi.dao.Project_Employee_Dao;
import many_to_many_uni_assi.dto.Employee;
import many_to_many_uni_assi.dto.Project;

public class Project_Employee_Controller {

	static Project_Employee_Dao dao = new Project_Employee_Dao();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		runApplication();
	}

	public static void runApplication() {
		System.out.println("Enter your choice To:" + " \n1: save Project" + " \n2: save Employee"
				+ " \n3: add new employee to project" + " \n4: add Existing employee to project"
				+ " \n5: remove employee" + " \n6: remove project" + " \n7: remove employee from project"
				+ " \n8: find employee"
				+ " \n9: find project \n10: get all employee \n11: get all projects \n12: get all records \n13: exit");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			System.out.println("do you want to add new project (yes/no)");
			String saveInput = sc.next();
			List<Project> projList = new ArrayList<Project>();
			List<Employee> empList = new ArrayList<Employee>();
			if (saveInput.equalsIgnoreCase("yes")) {

				System.out.println("how many projects you want to add");
				int totalProjects = sc.nextInt();
				for (int i = 1; i <= totalProjects; i++) {
					Project project = new Project();
					System.out.println("insert project id");
					int newProjectId = sc.nextInt();
					project.setId(newProjectId);
					System.out.println("enter project name");
					String newProjectName = sc.next();
					project.setName(newProjectName);
					System.out.println("Enter starting date");
					String startDate = sc.next();
					project.setStartDate(startDate);
					System.out.println("enter end date");
					String endDate = sc.next();
					project.setEndDate(endDate);
					projList.add(project);
				}
			} else {
				runApplication();
			}
			System.out.println("do you want to set Employees(yes/no)");
			String saveEmployee = sc.next();
			if (saveEmployee.equalsIgnoreCase("yes")) {
				System.out.println("how many employees you want to add");
				int totalEmployees = sc.nextInt();
				for (int i = 1; i <= totalEmployees; i++) {
					Employee employee = new Employee();
					System.out.println("enter employee id");
					int employeeId = sc.nextInt();
					employee.setId(employeeId);
					System.out.println("enter employee name");
					String employeeName = sc.next();
					employee.setName(employeeName);
					System.out.println("enter position");
					String position = sc.next();
					employee.setPosition(position);
					System.out.println("enter year's of experiance");
					int YOExperiace = sc.nextInt();
					employee.setYearsOfExperiance(YOExperiace);
					empList.add(employee);
				}
			} else {
				dao.saveProject(projList);
				runApplication();
			}
			for (Project project : projList) {
				project.setEmployees(empList);
				dao.saveProject(project);
			}
			runApplication();
			break;
		case 2:
			System.out.println("do you want to add new employee");
			String toAddNewEmp = sc.next();
			if (toAddNewEmp.equalsIgnoreCase("yes")) {
				Employee employee = new Employee();
				System.out.println("enter employee id");
				int empId = sc.nextInt();
				employee.setId(empId);
				System.out.println("enter employee name");
				String empName = sc.next();
				employee.setName(empName);
				System.out.println("enter position of employee");
				String empPosition = sc.next();
				employee.setPosition(empPosition);
				System.out.println("enter employee yeas's of experiance");
				int empExperience = sc.nextInt();
				employee.setYearsOfExperiance(empExperience);
				dao.saveEmployee(employee);
			} else {
				runApplication();
			}
			runApplication();
			break;
		case 3:
			System.out.println("enter project id in which you want to add new employee");
			int projIdToaddNewEmp = sc.nextInt();

			Employee employee = new Employee();
			System.out.println("enter employee id");
			int newEmpId = sc.nextInt();
			employee.setId(newEmpId);
			System.out.println("enter employee name");
			String newEmpName = sc.next();
			employee.setName(newEmpName);
			System.out.println("enter employee position");
			String newEmpPosition = sc.next();
			employee.setPosition(newEmpPosition);
			System.out.println("enter employee years of experience");
			int newEmpExperience = sc.nextInt();
			employee.setYearsOfExperiance(newEmpExperience);
			dao.addNewEmployee(projIdToaddNewEmp, employee);
			runApplication();
			break;
		case 4:
			System.out.println("to add existing employee to the project insert employee id");
			int exiEmpId = sc.nextInt();
			System.out.println("enter existing project in which you want to add employee");
			int exiProjectId = sc.nextInt();
			dao.addExistingEmployeeToProject(exiEmpId, exiProjectId);
			runApplication();
			break;
		case 5:
			System.out.println("enter employee id you want to remove");
			int removeEmpById = sc.nextInt();
			dao.removeEmployee(removeEmpById);
			runApplication();
			break;
		case 6:
			System.out.println("enter project id you want to remove");
			int removeProjById = sc.nextInt();
			dao.removeProject(removeProjById);
			runApplication();
			break;
		case 7:
			System.out.println("to remove employee from project enter employee Id");
			int empIdToremove = sc.nextInt();
			System.out.println("enter project id from where you want to remove employee");
			int projectIdToRemoveEmp = sc.nextInt();
			dao.removeEmployeeFromProject(empIdToremove, projectIdToRemoveEmp);
			runApplication();
			break;
		case 8:
			System.out.println("enter employee id to get detalis");
			int findEmployee = sc.nextInt();
			dao.findEmployee(findEmployee);
			runApplication();
			break;
		case 9:
			System.out.println("enter project id to get project");
			int findProject = sc.nextInt();
			dao.findProject(findProject);
			runApplication();
			break;
		case 10:
			System.out.println("All Employees are: ");
			dao.findAllEmployee();
			runApplication();
			break;
		case 11:
			System.out.println("All project are: ");
			dao.findAllProject();
			break;
		case 12:
			System.out.println("All records are");
			dao.findAllRecords();
			runApplication();
			break;
		case 13:
			System.out.println("do you want to exit: (Yes/no)");
			String exitDecesion = sc.next();
			if (exitDecesion.equalsIgnoreCase("yes")) {
				System.out.println("Thank You");
				break;
			} else {
				runApplication();
				break;
			}
		default:
			System.out.println("wrong input: if you want to exit enter 13");
			runApplication();
			break;
		}
	}
}
