package com.company.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.company.dto.Address;
import com.company.dto.Company;
import com.company.dto.Computer;
import com.company.dto.Employee;
import com.company.dto.Skills;

public class Company_Dao {
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
	private EntityManager manager = factory.createEntityManager();
	private EntityTransaction transaction = manager.getTransaction();

//	-----------------------------------------------save------------------------------------------------------------------------

	public void saveCompany(Company company) {
		if(company!=null) {
			if(company.getAddress()!=null&&company.getComputers()!=null&&company.getEmployees()!=null) {
			Address address	=company.getAddress();
			List<Employee> employeeList = company.getEmployees();
			List<Computer> compList=company.getComputers();
			address.setCompany(company);
			for (Employee employee : employeeList) {
				List<Skills> skillList= employee.getSkills();
				if(!skillList.isEmpty()) {				
					for (Skills skill : skillList) {
						skill.setEmployee(employee);
					}
				}else {	
					System.out.println("empty");
				}
			}
			for (Computer computer : compList) {
				computer.setCompany(company);
			}
			for (Employee employee : employeeList) {
				employee.setCompany(company);
			}
			transaction.begin();
			manager.persist(company);
			transaction.commit();
			}
		}else {
			System.out.println("Company not found");
		}
	}
	
	
//	---------------------------------------------------find methods----------------------------------------------------------------
	
//	---------------------------------------------------find all details of company--------------------------------------------------------------
	
	public void findALLDetailsOfCompanyById(int compId) {
		Company company = manager.find(Company.class, compId);
		if(company!=null) {
			System.out.println("Comapny Deatils: "+ company);
			if(company.getAddress()!=null) {
				System.out.println("Comapny Address: "+ company.getAddress());
			}else {
				System.out.println("Address Not Found");
			}
			if(company.getEmployees()!=null) {
				List<Employee> empList = company.getEmployees();
				for (Employee employee : empList) {
					System.out.println(employee);
				}
			}else {
				System.out.println("Employee Not Found");
			}
			if(company.getComputers()!=null) {
				List<Computer> compList=company.getComputers();
				for (Computer computer : compList) {
					System.out.println(computer);
				}
			}
		}else {
			System.out.println("Company Not Found");
		}
	}
	
//	-----------------------------find employees of company-------------------------------------------------------------
	
	public void findEmployeesOfComapanyById(int compId) {
		Company company = manager.find(Company.class, compId);
		if(company!=null) {
			if(company.getEmployees()!=null) {
				List<Employee> empList = company.getEmployees();
				for (Employee employee : empList) {
					System.out.println(employee);
				}
			}else {
				System.out.println("Employee Not Found");
			}
		}else {
			System.out.println("Company Not Found");
		}
	}
//	--------------------------------------find computers of company--------------------------------------------------------
	
	public void findComputersOfCompanyById(int compId) {
		Company company = manager.find(Company.class, compId);
		if(company!=null) {
			if(company.getComputers()!=null) {
				List<Computer> compList=company.getComputers();
				for (Computer computer : compList) {
					System.out.println(computer);
				}
			}else {
				System.out.println("Computers Not Found");
			}
		}else {
			System.out.println("Company Not Found");
		}
	}
	
//	---------------------------find skills of all employees from company---------------------------------------------------
	
	public void findSkillsOfEmployeesFromCompany(int compId) {
		Company company = manager.find(Company.class, compId);
		if(company!=null) {
			if(company.getEmployees()!=null) {
				List<Employee> empList=company.getEmployees();
				for (Employee employee : empList) {
					if(employee.getSkills()!=null) {
						List<Skills> skillList=employee.getSkills();
						System.out.println("Employee :"+employee);
						for (Skills skill : skillList) {
							System.out.println(skill);
						}
					}else {
						System.out.println("Skills Not Found");
					}
				}
			}
		}else {
			System.out.println("Company Not Found");
		}
	}
	
//	-------------------------------------------------delete methods--------------------------------------------------------
	
//	--------------------------------------------------delete Company-------------------------------------------------------
	
	public void deleteCompany(int compId) {
		Company company = manager.find(Company.class, compId);	
		if(company!=null) {
			transaction.begin();
			manager.remove(company);
			transaction.commit();
		}else {
			System.out.println("Company Not Found");
		}
	}
	
//	---------------------------------------------------delete employee from company-----------------------------------------
	
	
	public void deleteEmployeeFromCompany(int empId,int compId) {
		Company company = manager.find(Company.class, compId);
		Employee employee = manager.find(Employee.class, empId);
		
		if(company!=null&&employee!=null) {
			if(!company.getEmployees().isEmpty()) {
				if(company.getEmployees().contains(employee)) {
					company.getEmployees().remove(employee);
					Computer computer = employee.getComputer();
					computer.setEmployee(null);
					employee.setCompany(null);
					employee.setComputer(null);
					List<Skills> skillList=employee.getSkills();
					employee.setSkills(null);
					transaction.begin();
					for (Skills skills : skillList) {
						manager.remove(skills);
					}
					manager.remove(employee);
					transaction.commit();
				}else {
					System.out.println("Employee does not belong to this company");
				}
			}else {
				System.out.println("Comapny does not contain any employee");
			}
		}else {
			System.out.println("Check CompanyId and Employee Id");
		}
	}
	
//	-----------------------------------------------delete Computer From Company--------------------------------------------
	
	public void deleteComputerFromCompany(int compId, int companyId) {
		Company company = manager.find(Company.class, companyId);
		Computer computer = manager.find(Computer.class, compId);
		if(company!=null&&computer!=null) {
			if(company.getComputers()!=null  && computer.getCompany()!=null) {
				if(company.getComputers().contains(computer)&&computer.getCompany().equals(company)) {
					company.getComputers().remove(computer);
					computer.setCompany(null);
					if(computer.getEmployee()!=null) {
						Employee employee = computer.getEmployee();
						employee.setComputer(null);
					}
					computer.setEmployee(null);		
					transaction.begin();
					manager.remove(computer);
					transaction.commit();
				}else {
					System.out.println("company does not have the computer you mention");
				}
			}else {
				System.out.println("company does not have any computers or computer does not associate with any company");
			}
		}else {
			System.out.println("Computer or Company Not Found");
		}
	}
	
//	------------------------------------------------Delete Skill From Employee--------------------------------------------
	
	public void deleteSkillFromEmployee(int skillId,int empId) {
		Skills skill = manager.find(Skills.class, skillId);
		Employee employee = manager.find(Employee.class, empId);
		
		if(skill!=null && employee!=null) {
			if(skill.getEmployee()!=null && employee.getSkills()!=null) {
				if(skill.getEmployee().equals(employee)&&employee.getSkills().contains(skill)) {
					employee.getSkills().remove(skill);
					skill.setEmployee(null);
					transaction.begin();
					manager.remove(skill);
					transaction.commit();
					
				}else {
					System.out.println("skill and employee are not associate with each other");
				}
			}else {
				System.out.println("skill does not contain any employee  or employee skills are empty");
			}
		}else {
			System.out.println("skill not found or employee not found");
		}
	}
	
//	-------------------------------------------------Delete All The Computer from Company--------------------------------
	
	public void deleteAllTheComputersFromCompany(int comId) {
		Company company = manager.find(Company.class, comId);
		if(company!=null) {
			List<Computer> compList=company.getComputers();
			company.setComputers(null);
			if(compList!=null) {
				for (Computer computer : compList) {
					computer.setCompany(null);
					if(computer.getEmployee()!=null) {
						Employee employee = computer.getEmployee();
						employee.setComputer(null);
						computer.setEmployee(null);	
					}
					transaction.begin();
					manager.remove(computer);
					transaction.commit();
				}
			}else {
				System.out.println("Company does not found any computes");
			}
		}else {
			System.out.println("Company not found");
		}
	}
	
//	----------------------------------------------------Delete All Employee From Company-----------------------------------
	
	public void deleteAllEmployeeFromCompany(int comId) {
		Company company = manager.find(Company.class, comId);
		
		if(company!=null) {
			if(company.getEmployees()!=null && !company.getEmployees().isEmpty()) {
				List<Employee> empList = company.getEmployees();
				company.setEmployees(null);
				for (Employee employee : empList) {
					if(employee.getCompany()!=null) {
						employee.setCompany(null);
					}
					if(employee.getComputer()!=null) {
						Computer computer = employee.getComputer();
						computer.setEmployee(null);
						employee.setComputer(null);
					}
					transaction.begin();
					manager.remove(employee);
					transaction.commit();
					
				}
			}else {
				System.out.println("Company does not have any Employees");
			}
		}else {
			System.out.println("company Not Found");
		}
	}
	
//	-----------------------------------------------------------update Methods---------------------------------------------------
	
//	---------------------------------------Add New Employee To Company-----------------------------------------------------------
	
	public void addNewEmployeeInCompany(int comId, Employee employee) {
		Company company = manager.find(Company.class, comId);
		
		if(company!=null && employee!=null) {
			company.getEmployees().add(employee);
			employee.setCompany(company);
			if(employee.getComputer()!=null) {
				Computer computer = employee.getComputer();
				computer.setCompany(company);
				company.getComputers().add(computer);
			}
			if(employee.getSkills()!=null) {
				List<Skills> skillList = employee.getSkills();
				for (Skills skills : skillList) {
					skills.setEmployee(employee);
				}
			}
			transaction.begin();
			manager.merge(company);
			transaction.commit();
			
		}else {
			System.out.println("company not found");
		}
	}
	
//	---------------------------------------Add New Computer To Company-----------------------------------------------------------
	
	public void addNewComputerInCompany(int comId,Computer computer) {
		Company company = manager.find(Company.class, comId);
		
		if(company!=null && computer!=null) {
			company.getComputers().add(computer);
			computer.setCompany(company);
			if(computer.getEmployee()!=null) {
			 Employee employee=computer.getEmployee();
			 company.getEmployees().add(employee);
			 employee.setComputer(computer);
			 employee.setCompany(company);
			 
			 if(employee.getSkills()!=null) {
				 List<Skills> skillList=employee.getSkills();
				 for (Skills skills : skillList) {
					skills.setEmployee(employee);
				}
			 }
			}
			transaction.begin();
			manager.merge(company);
			transaction.commit();
		}else {
			System.out.println("company not found");
		}
	}
	
//	---------------------------------------Add New Skill To Employee-----------------------------------------------------------
	
	public void	addNewSkillsInEmployee(int empId, List<Skills> skillList) {
		
		Employee employee = manager.find(Employee.class, empId);
		
		if(employee!=null && !skillList.isEmpty()) {
			employee.getSkills().addAll(skillList);
			for (Skills skills : skillList) {
				skills.setEmployee(employee);
			}
			transaction.begin();
			manager.merge(employee);
			transaction.commit();
		}else {
			System.out.println("Employee Not Found");
		}
	
	}
}
