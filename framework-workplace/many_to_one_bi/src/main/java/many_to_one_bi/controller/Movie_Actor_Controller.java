package many_to_one_bi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import many_to_one_bi.dao.Movie_Actor_Dao;
import many_to_one_bi.dto.Actor;
import many_to_one_bi.dto.Movie;

public class Movie_Actor_Controller {
	static Scanner sc = new Scanner(System.in);
	static Movie_Actor_Dao dao = new Movie_Actor_Dao();

	public static void main(String[] args) {
		runApplication();
	}

	public static void runApplication() {
		System.out.println("Enter your Choice : " + "\n1: To Add New Movie " + "\n2: Add new Actor To Movie"
				+ "\n3: Change Actors Movie " + "\n4: Remove Actor \n5: Remove Movie " + "\n6: Remove Actor From Movie "
				+ "\n7: Find Movie By Id "
				+ "\n8: Find Actor By Id \n9: Find Movie With Actors \n10: find All Records \n11: Exit");

		System.out.println("enter your choice");
		int input = sc.nextInt();
		switch (input) {

		case 1:
			System.out.println("Do you want to add new movie (yes/no)");
			String toAddNewMovie = sc.next();
			if (toAddNewMovie.equalsIgnoreCase("yes")) {
				Movie movie = new Movie();
//				System.out.println("Enter movie Id");
//				int movieId = sc.nextInt();
//				movie.setId(movieId);
				System.out.println("Enter movie Name");
				String movieName = sc.next();
				movie.setName(movieName);
				System.out.println("Enter Movie Budget");
				double movieBudget = sc.nextDouble();
				movie.setBudget(movieBudget);
				System.out.println("Enter Movie Rating");
				int movieRating = sc.nextInt();
				movie.setRating(movieRating);

				System.out.println("Enter Movie Release date");
				String movieReleaseDate = sc.next();
				movie.setReleaseDate(movieReleaseDate);

				System.out.println("Do you want to add Actors (yes/no)");
				String toAddActors = sc.next();
				if (toAddActors.equalsIgnoreCase("yes")) {
					List<Actor> actorList = new ArrayList<Actor>();
					System.out.println("How many actors you want to add");
					int totalActors = sc.nextInt();
					for (int i = 1; i <= totalActors; i++) {
						Actor actor = new Actor();
//						System.out.println("Enter Actor Id");
//						int actorId = sc.nextInt();
//						actor.setId(actorId);
						System.out.println("Enter Actor Name");
						String actorName = sc.next();
						actor.setName(actorName);
						System.out.println("Enter Actor Age");
						int actorAge = sc.nextInt();
						actor.setAge(actorAge);
						System.out.println("Enter Actors fees");
						double actorFees = sc.nextDouble();
						actor.setFees(actorFees);
						actorList.add(actor);
						actor.setMovie(movie);
						System.out.println(i + " actor added");
					}
					movie.setActors(actorList);
					dao.saveMovie(movie);
					runApplication();
					break;

				} else {
					dao.saveMovie(movie);
					runApplication();
					break;
				}

			} else {
				runApplication();
				break;
			}

		case 2:
			System.out.println("Do you want to add Actor to movie (yes/no)");
			String toAddActors = sc.next();
			if (toAddActors.equalsIgnoreCase("yes")) {
				System.out.println("Enter movie id in which you want to add new actor");
				int movieId = sc.nextInt();
				System.out.println("Enter new Actor Details:");
				Actor actor = new Actor();
				System.out.println("Enter Actor Name");
				String actorName = sc.next();
				actor.setName(actorName);
				System.out.println("Enter Actor Age");
				int actorAge = sc.nextInt();
				actor.setAge(actorAge);
				System.out.println("Enter Actors fees");
				double actorFees = sc.nextDouble();
				actor.setFees(actorFees);
				dao.addNewActor(movieId, actor);
			} else {
				runApplication();
				break;
			}
		case 3:
			System.out.println("Do you want to Change Actor's movie (yes/no)");
			String toChangeMovie = sc.next();
			if (toChangeMovie.equalsIgnoreCase("yes")) {
				System.out.println("Enter Actor Id");
				int actorId = sc.nextInt();
				System.out.println("Enter new Movie Id");
				int movieId = sc.nextInt();
				dao.updateActorsMovie(movieId, actorId);
				runApplication();
				break;
			} else {
				runApplication();
				break;
			}

		case 4:
			System.out.println("Do you want to Remove Actor (yes/no)");
			String toRemoveActor = sc.next();
			if (toRemoveActor.equalsIgnoreCase("yes")) {
				System.out.println("Enter actor id To remove");
				int actorId = sc.nextInt();
				dao.removeActor(actorId);
				runApplication();
				break;
			} else {
				runApplication();
				break;
			}
		case 5:
			System.out.println("Do you want to Remove movie (yes/no)");
			String toRemoveMovie = sc.next();
			if (toRemoveMovie.equalsIgnoreCase("yes")) {
				System.out.println("Enter Movie Id to Remove");
				int movieId = sc.nextInt();
				dao.removeMovie(movieId);
				runApplication();
				break;
			} else {
				runApplication();
				break;
			}
		case 6:
			System.out.println("Do you want to Remove Actor From movie movie (yes/no)");
			String toRemoveActorFromMovie = sc.next();
			if (toRemoveActorFromMovie.equalsIgnoreCase("yes")) {
				System.out.println("Enter Movie Id From where you want to remove Actor");
				int movieId = sc.nextInt();
				System.out.println("Enter Actor Id You want to remove");
				int actorId = sc.nextInt();
				dao.removeActorFromMovie(movieId, actorId);
				runApplication();
				break;
			} else {
				runApplication();
				break;
			}

		case 7:
			System.out.println("Enter movie id you want to find");
			int findMovieById = sc.nextInt();
			dao.findMovie(findMovieById);
			runApplication();
			break;

		case 8:
			System.out.println("Enter Actor Id to Find");
			int findActorById = sc.nextInt();
			dao.findActor(findActorById);
			runApplication();
			break;
		case 9:
			System.out.println("Enter Movie Id To get Details");
			int getMovieDetails = sc.nextInt();
			dao.findMovieDetails(getMovieDetails);
			runApplication();
			break;
		case 10:
			System.out.println("All Records Are: ");
			dao.getAllRecords();
			runApplication();
			break;

		case 11:
			System.out.println("Do you want to Exit (yes/no)");
			String toExit = sc.next();
			if (toExit.equalsIgnoreCase("yes")) {
				System.out.println("Thank You");
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
