package com.company.controller;

import java.util.ArrayList;
import java.util.List;

import com.company.dao.Company_Dao;
import com.company.dto.Address;
import com.company.dto.Company;
import com.company.dto.Computer;
import com.company.dto.Employee;
import com.company.dto.Skills;

public class Comapany_Contraller {
	static Company_Dao  dao = new Company_Dao();
	public static void main(String[] args) {
		Company company = new Company();
		company.setId(8);
		company.setName("SAMSUNG");
		company.setEmail("samsung@gmail.com");
		
		
		Address address = new Address();
		address.setId(8);
		address.setCity("south korea");
		address.setPincode("721302");
		
		List<Computer> compList = new ArrayList<Computer>();
		Computer computer1 = new Computer();
		computer1.setId(115);
		computer1.setName("MacBookPro");
		computer1.setPrice("109000");
		compList.add(computer1);
		
		Computer computer2 = new Computer();
		computer2.setId(116);
		computer2.setName("MacBookPro");
		computer2.setPrice("109000");
		compList.add(computer2);
		
		
		List<Employee> empList = new ArrayList<Employee>();
		
		Employee employee1=new Employee();
		employee1.setId(1010);
		employee1.setName("max");
		employee1.setEmail("max@gamil");
		employee1.setDesignation("PHP Devloper");
		employee1.setComputer(computer1);
		empList.add(employee1);
		
		Employee employee2=new Employee();
		employee2.setId(1011);
		employee2.setName("chetan");
		employee2.setEmail("chetan@gamil");
		employee2.setDesignation("MERN Stack Devloper");
		employee2.setComputer(computer2);
		computer2.setEmployee(employee2);
		empList.add(employee2);
		
		
		List<Skills> skillList1=new ArrayList<Skills>();
		Skills skill1=new Skills();
		skill1.setId(10029);
		skill1.setName("react");
		skillList1.add(skill1);
		
		Skills skill2=new Skills();
		skill2.setId(10030);
		skill2.setName("JS");
		skillList1.add(skill2);
		

		List<Skills> skillList2=new ArrayList<Skills>();
		Skills skill3=new Skills();
		skill3.setId(10033);
		skill3.setName("PHP");
		skillList2.add(skill3);
		
		Skills skill4=new Skills();
		skill4.setId(10034);
		skill4.setName("EXPRESS.JS");
		skillList2.add(skill4);
		
		
		employee1.setSkills(skillList1);
		employee2.setSkills(skillList2);
		

		company.setAddress(address);
		company.setComputers(compList);
		company.setEmployees(empList);
		
		
			/*
				1.  public void saveCompany(Company company){}
				2.  public void findALLDetailsOfCompanyById(int compId){}
				3.  public void findEmployeesOfComapanyById(int compId){}
				4.  public void findComputersOfCompanyById(int compId){}
				5.  public void findSkillsOfEmployeesFromCompany(int compId){}
				6.  public void deleteCompany(int compId){}
				7.  public void deleteEmployeeFromCompany(int empId,int compId){}
				8.  public void deleteComputerFromCompany(int compId, int companyId){}
				9.  public void deleteSkillFromEmployee(int skillId,int empId){}
				10. public void deleteAllTheComputersFromCompany(int comId){}
				11. public void deleteAllEmployeeFromCompany(int comId){}
				12. public void addNewEmployeeInCompany(int comId, Employee employee){}
				13. public void addNewComputerInCompany(int comId,Computer computer){}
				14. public void	addNewSkillsInEmployee(int empId, List<Skills> skillList){}
				
			 */
		
		
//		dao.saveCompany(company);
//		dao. findSkillsOfEmployeesFromCompany(1);
//		dao.deleteCompany(3);
//		dao.deleteEmployeeFromCompany(1010, 5);
//		dao.deleteComputerFromCompany(109, 5);
//		dao.deleteSkillFromEmployee(10006, 1003);
//		dao.deleteAllTheComputersFromCompany(1);
//		dao.deleteAllEmployeeFromCompany(6);
//		dao. addNewEmployeeInCompany(1, employee1);
//		dao.addNewComputerInCompany(8,computer2);
		dao.addNewSkillsInEmployee(1011, skillList2);
		
	}
}
