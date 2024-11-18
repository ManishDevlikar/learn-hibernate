package one_to_many_uni_assi_controller;

import java.util.Scanner;

import one_to_many_uni_assi_dao.University_Collage_Dao;

public class University_College_Controller {
	static University_Collage_Dao university_Collage_Dao = new University_Collage_Dao();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		runApplication();
	}

	public static void runApplication() {
		System.out.println("------------------------------------------------");
		System.out.println();
		System.out.println("------------------------------------------------");
		System.out.println(
				"1:create university" + " \n2:add new college" + " \n3:update university" + " \n4:deleteUniversity"
						+ " \n5:update college's university " + "\n6:update college " + "\n7:remove college"
						+ " \n8:find all colleges" + " \n9:find all universities" + " \n10:find university"
						+ " \n11:get all record" + " \n12:delete university and related college \n13:exit");

		System.out.println("Enter your input");
		int input = sc.nextInt();

		switch (input) {
		case 1:
			university_Collage_Dao.insertNewUniversity();
			runApplication();
			break;
		case 2:
			System.out.println("do you want to add colleges (yes/no)");
			String inputToAddCollege = sc.next();
			if (inputToAddCollege.equalsIgnoreCase("yes")) {
				System.out.println("enter university id in which you wanted to add them");
				int universityId = sc.nextInt();
				university_Collage_Dao.addColleges(universityId);
				runApplication();
				break;
			} else {
				runApplication();
			}
			break;
		case 3:
			System.out.println("enter your university id to update its details");
			int universityIdToUpdateDet = sc.nextInt();
			university_Collage_Dao.updateUniversityById(universityIdToUpdateDet);
			runApplication();
			break;
		case 4:
			System.out.println("do you wanted to delele university (yes/no)");
			String inputTodelete = sc.next();
			if (inputTodelete.equalsIgnoreCase("yes")) {
				System.out.println("enter id of university you want to delete");
				int idToDeleteUni = sc.nextInt();
				System.out.println("enter new university id to assign colleges");
				int idToAssNewUni = sc.nextInt();
				university_Collage_Dao.deleteUniversity(idToDeleteUni, idToAssNewUni);
				runApplication();
				break;
			} else {
				runApplication();
			}
			break;
		case 5:
			System.out.println("to update university of college enter previous university id");
			int previousUniversityId = sc.nextInt();
			System.out.println("enter college id you want to update university");
			int collegeIdToChangeUni = sc.nextInt();
			System.out.println("enter new university id");
			int newUniversityIdToassi = sc.nextInt();
			university_Collage_Dao.updateCollegeUniversity(previousUniversityId, collegeIdToChangeUni,
					newUniversityIdToassi);
			runApplication();
			break;
		case 6:
			System.out.println("enter college id to update its details");
			int collegeIdToUpdateDet = sc.nextInt();
			university_Collage_Dao.updateCollageById(collegeIdToUpdateDet);
			runApplication();
			break;
		case 7:
			System.out.println("do you want to remove college (yes/no)");
			String inputToRemoveClg = sc.next();
			if (inputToRemoveClg.equalsIgnoreCase("yes")) {
				System.out.println("enter university id of that college");
				int uniIdToRemoveCollege = sc.nextInt();
				System.out.println("to remove your college enter college id");
				int idToRemoveCollege = sc.nextInt();
				university_Collage_Dao.removeCollegesById(uniIdToRemoveCollege, idToRemoveCollege);
				runApplication();
				break;
			} else {
				runApplication();
			}
			break;
		case 8:
			System.out.println("all colleges are ...");
			university_Collage_Dao.findAllColleges();
			runApplication();
			break;
		case 9:
			System.out.println("all universities are ...");
			university_Collage_Dao.findAllUniversities();
			runApplication();
			break;
		case 10:
			System.out.println("enter university id to get detals");
			int idTogetResult = sc.nextInt();
			university_Collage_Dao.findUniversity(idTogetResult);
			runApplication();
			break;
		case 11:
			System.out.println("all records are ...");
			university_Collage_Dao.findAllUniversitiesAndColleges();
			runApplication();
			break;
		case 12:
			System.out.println("enter university is to delete university and all its colleges");
			int deleteAll = sc.nextInt();
			university_Collage_Dao.deleteUniversityWithColleges(deleteAll);
			runApplication();
			break;
		case 13:
			System.out.println("thank you");
			break;
		default:
			System.out.println("wrong input");
			runApplication();
		}
	}
}
