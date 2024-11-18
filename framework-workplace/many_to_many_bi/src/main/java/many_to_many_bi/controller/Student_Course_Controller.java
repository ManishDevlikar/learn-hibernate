package many_to_many_bi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import many_to_many_bi.dao.Student_Course_Dao;
import many_to_many_bi.dto.Courses;
import many_to_many_bi.dto.Student;

public class Student_Course_Controller {

	static Student_Course_Dao dao = new Student_Course_Dao();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		runApplicatin();
	}

	public static void runApplicatin() {
		System.out.println("Enter your Choice : " + "\n1: To Add New Student " + "\n2: Add new Student To Course"
				+ "\n3: Add new Course To Student " + "\n4: update student courses \n5: Remove Student "
				+ "\n6: Remove Course " + "\n7: Find Course By Id "
				+ "\n8: Find Student By Id \n9: find All Records \n10: Exit");

		System.out.println("enter your choice");
		int input = sc.nextInt();

		switch (input) {
		case 1:
			System.out.println("do you want to add new Student (yes/no)");
			String toAddNewStudent = sc.next();
			if (toAddNewStudent.equalsIgnoreCase("yes")) {
				System.out.println("how many students you want to add");
				int totalStudent = sc.nextInt();
				List<Student> studentList = new ArrayList<Student>();
				for (int i = 0; i < totalStudent; i++) {
					Student student = new Student();
					System.out.println("Enter Student ID");
					int sId = sc.nextInt();
					student.setId(sId);
					System.out.println("Enter Student name");
					String sName = sc.next();
					student.setName(sName);
					System.out.println("Enter Student emailId");
					String sEmail = sc.next();
					student.setEmail(sEmail);
					studentList.add(student);
					System.out.println(i + 1 + " student added");
				}
				System.out.println("Do you want to set courese for student (yes/no)");
				String toSetCourses = sc.next();
				if (toSetCourses.equalsIgnoreCase("yes")) {
					System.out.println("how many Courses you want to set");
					int totalCourses = sc.nextInt();
					List<Courses> courseList = new ArrayList<Courses>();
					for (int i = 0; i < totalCourses; i++) {
						Courses course = new Courses();
						System.out.println("Enter Course ID");
						int cId = sc.nextInt();
						course.setId(cId);
						System.out.println("Enter Course name");
						String cName = sc.next();
						course.setName(cName);
						System.out.println("Enter Course Code");
						String cCode = sc.next();
						course.setCode(cCode);
						courseList.add(course);
						System.out.println(i + 1 + " course added");
					}

					for (Student students : studentList) {
						students.setCourses(courseList);
					}
					dao.saveStudent(studentList);
					runApplicatin();
					break;

				} else {
					dao.saveStudent(studentList);
					runApplicatin();
					break;
				}

			} else {
				runApplicatin();
				break;
			}

		case 2:
			System.out.println("Do you want to add new Student to coures(yes/no)");
			String toAddNewStud = sc.next();
			if (toAddNewStud.equalsIgnoreCase("yes")) {
				System.out.println("Enter Course Id In which You want to add students");
				int cId = sc.nextInt();
				System.out.println("how many students you want to add");
				int totalStudent = sc.nextInt();
				List<Student> studentList = new ArrayList<Student>();
				for (int i = 0; i < totalStudent; i++) {
					Student student = new Student();
					System.out.println("Enter Student ID");
					int sId = sc.nextInt();
					student.setId(sId);
					System.out.println("Enter Student name");
					String sName = sc.next();
					student.setName(sName);
					System.out.println("Enter Student emailId");
					String sEmail = sc.next();
					student.setEmail(sEmail);
					studentList.add(student);
					System.out.println(i + 1 + " student added");
				}
				dao.addNewStudentToCourse(cId, studentList);
				runApplicatin();
				break;

			} else {
				runApplicatin();
				break;
			}
		case 3:
			System.out.println("Do you want to add new Course to Student(yes/no)");
			String toAddNewCourse = sc.next();
			if (toAddNewCourse.equalsIgnoreCase("yes")) {
				System.out.println("Enter Student Id In Which You Want To Set Set New Courses");
				int studId = sc.nextInt();
				System.out.println("how many Courses you want to set");
				int totalCourses = sc.nextInt();
				List<Courses> courseList = new ArrayList<Courses>();
				for (int i = 0; i < totalCourses; i++) {
					Courses course = new Courses();
					System.out.println("Enter Course ID");
					int cId = sc.nextInt();
					course.setId(cId);
					System.out.println("Enter Course name");
					String cName = sc.next();
					course.setName(cName);
					System.out.println("Enter Course Code");
					String cCode = sc.next();
					course.setName(cName);
					courseList.add(course);
					System.out.println(i + 1 + " course added");
				}
				dao.addNewCourseToStudent(studId, courseList);
				runApplicatin();
				break;

			} else {
				runApplicatin();
				break;
			}
		case 4:
			System.out.println("Do you want to update Student Course (Yes/no)");
			String wantToUpdate = sc.next();
			if (wantToUpdate.equalsIgnoreCase("yes")) {
				System.out.println("Enter Course Id");
				int cId = sc.nextInt();
				System.out.println("Enter Student Id");
				int sId = sc.nextInt();
				dao.updateStudentCourses(sId, cId);
				runApplicatin();
				break;
			} else {
				runApplicatin();
				break;
			}
		case 5:
			System.out.println("Do You Want to remove student (Yes/No)");
			String toRemove = sc.next();
			if (toRemove.equalsIgnoreCase(toRemove)) {
				System.out.println("Enter Student Id to Remove");
				int sId = sc.nextInt();
				dao.removeStudent(sId);
				runApplicatin();
				break;
			} else {
				runApplicatin();
				break;
			}
		case 6:
			System.out.println("Do you want to remove Course (yes/no)");
			String toRemoveCourse = sc.next();
			if (toRemoveCourse.equalsIgnoreCase("yes")) {
				System.out.println("Enter Course Id to Remove");
				int cId = sc.nextInt();
				dao.removeCourse(cId);
				runApplicatin();
				break;
			} else {
				runApplicatin();
				break;
			}
		case 7:
			System.out.println("Enter Coures Id To Find");
			int cId = sc.nextInt();
			dao.findCourse(cId);
			runApplicatin();
			break;
		case 8:
			System.out.println("Enter Student Id To Find");
			int sId = sc.nextInt();
			dao.findStudent(sId);
			runApplicatin();
			break;
		case 9:
			System.out.println("All Records Are");
			dao.findAllRecords();
			runApplicatin();
			break;
		case 10:
			System.out.println("Do you want to Exit (Yes/No)");
			String toExit = sc.next();
			if (toExit.equalsIgnoreCase("yes")) {
				System.out.println("Thank You");
				break;
			} else {
				runApplicatin();
				break;
			}
		default:
			System.out.println("Enter 10 To Exit");
			runApplicatin();
			break;
		}
	}

}
