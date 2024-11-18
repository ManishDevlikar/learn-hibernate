package many_to_one_uni_assi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import many_to_one_uni_assi.dao.Student_Course_Dao;
import many_to_one_uni_assi.dto.Course;
import many_to_one_uni_assi.dto.Student;

public class Student_Course_Controller {
	static Student_Course_Dao dao = new Student_Course_Dao();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		runApplication();
	}

	static public void runApplication() {
		System.out.println("Enter your choice: " + "\n1: To Add Students " + "\n2: To Add Course  "
				+ "\n3: To Add New Student To Course" + " \n4: To Change Student Course"
				+ " \n5: To Remove Student \n6: To Remove Course \n7: To Find Student \n8: To Find Course \n9: To Find All Records \n10: To Exit");

		int input = sc.nextInt();

		switch (input) {
		case 1:
			System.out.println("do you want to add new student(Yes/No)");
			String newStudentToAdd = sc.next();
			if (newStudentToAdd.equalsIgnoreCase("yes")) {
				System.out.println("how many Students you want to Add");
				int totalStudentsToAdd = sc.nextInt();
				List<Student> newStudentList = new ArrayList<Student>();
				for (int i = 1; i <= totalStudentsToAdd; i++) {
					Student student = new Student();
					System.out.println("Enter Student Id");
					int newStudentId = sc.nextInt();
					student.setId(newStudentId);
					System.out.println("Enter Student Name");
					String newStudentName = sc.next();
					student.setName(newStudentName);
					System.out.println("Enter student email address");
					String newEmailAddress = sc.next();
					student.setEmail(newEmailAddress);
					System.out.println("Enter Student mobile No.");
					String newMobileNo = sc.next();
					student.setMobileNo(newMobileNo);
					newStudentList.add(student);
					System.out.println(i + " student added");
				}
				System.out.println("Do You want to set Course(yes/no)");
				String NewcourseToAdd = sc.next();
				if (NewcourseToAdd.equalsIgnoreCase("yes")) {
					Course course = new Course();
					System.out.println("Enter Coures id");
					int newCourseId = sc.nextInt();
					course.setId(newCourseId);
					System.out.println("Enter course name");
					String newCourseName = sc.next();
					course.setName(newCourseName);
					System.out.println("Enter Course fees");
					String newCourseFees = sc.next();
					course.setFees(newCourseFees);
					System.out.println("Enetr course duration");
					String newCourseDuration = sc.next();
					course.setDuration(newCourseDuration);

					for (Student student : newStudentList) {
						student.setCourse(course);
					}
					dao.saveStudentList(newStudentList);
					runApplication();
					break;

				} else {
					dao.saveStudentList(newStudentList);
					runApplication();
					break;
				}
			} else {
				runApplication();
				break;
			}
		case 2:
			System.out.println("do you want to add new course(yes/no)");
			String newCourseToAdd = sc.next();
			if (newCourseToAdd.equalsIgnoreCase("yes")) {
				Course course = new Course();
				System.out.println("Enter Coures id");
				int newCourseId = sc.nextInt();
				course.setId(newCourseId);
				System.out.println("Enter course name");
				String newCourseName = sc.next();
				course.setName(newCourseName);
				System.out.println("Enter Course fees");
				String newCourseFees = sc.next();
				course.setFees(newCourseFees);
				System.out.println("Enetr course duration");
				String newCourseDuration = sc.next();
				course.setDuration(newCourseDuration);
				dao.saveCourse(course);
				runApplication();
				break;
			} else {
				runApplication();
				break;
			}
		case 3:
			System.out.println("Do you want to add new student to course(yes/no)");
			String newStudentToAddInCourse = sc.next();
			if (newStudentToAddInCourse.equalsIgnoreCase("yes")) {
				System.out.println("enter course id in which you want to add new student");
				int courseId = sc.nextInt();
				Student student = new Student();
				System.out.println("Enter Student Id");
				int newStudentId = sc.nextInt();
				student.setId(newStudentId);
				System.out.println("Enter Student Name");
				String newStudentName = sc.next();
				student.setName(newStudentName);
				System.out.println("Enter student email address");
				String newEmailAddress = sc.next();
				student.setEmail(newEmailAddress);
				System.out.println("Enter Student mobile No.");
				String newMobileNo = sc.next();
				student.setMobileNo(newMobileNo);
				dao.addNewStudent(courseId, student);
				runApplication();
				break;

			} else {
				runApplication();
				break;
			}
		case 4:
			System.out.println("Do you want change student course ? (yes/no)");
			String toChangeStudentCourse = sc.next();
			if (toChangeStudentCourse.equalsIgnoreCase("yes")) {
				System.out.println("enter id of student which to change its course");
				int studId = sc.nextInt();
				System.out.println("enter new course id");
				int courseId = sc.nextInt();
				dao.changeStudCourse(studId, courseId);
				runApplication();
				break;
			} else {
				runApplication();
				break;
			}
		case 5:
			System.out.println("Do you want to remove student ? (yes/no)");
			String toRemoveStudent = sc.next();
			if (toRemoveStudent.equalsIgnoreCase("yes")) {
				System.out.println("Enter student id to remove");
				int studIdToRemove = sc.nextInt();
				dao.removeStudent(studIdToRemove);
				runApplication();
				break;
			} else {
				runApplication();
				break;
			}
		case 6:
			System.out.println("Do you want to remove student ? (yes/no)");
			String toRemoveCourse = sc.next();
			if (toRemoveCourse.equalsIgnoreCase("yes")) {
				System.out.println("Enter Course Id To Remove");
				int courseIdToRemove = sc.nextInt();
				dao.removeCourse(courseIdToRemove);
				runApplication();
				break;
			} else {
				runApplication();
				break;
			}
		case 7:
			System.out.println("enter student id to get record");
			int studIdToFind = sc.nextInt();
			dao.findStudent(studIdToFind);
			runApplication();
			break;
		case 8:
			System.out.println("enter course id to get record");
			int courseIdToFind = sc.nextInt();
			dao.findCourse(courseIdToFind);
			runApplication();
			break;
		case 9:
			System.out.println("All records are:");
			dao.findAllRecords();
			runApplication();
			break;
		case 10:
			System.out.println("do you want to exit (yes/no)");
			String inputToExit = sc.next();
			if (inputToExit.equalsIgnoreCase("yes")) {
				System.out.println("thank you");
				break;
			} else {
				runApplication();
				break;
			}
		default:
			System.out.println("enter 10 to exit");
			runApplication();
			break;
		}

	}
}
