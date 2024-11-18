package many_to_one_bi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import many_to_one_bi.dto.Actor;
import many_to_one_bi.dto.Movie;

public class Movie_Actor_Dao {
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
	private EntityManager manager = factory.createEntityManager();
	private EntityTransaction transaction = manager.getTransaction();

//	---------------------------------------------(save)---------------------------------------------------------------------------------------

	public void saveActor(Actor actor) {
		transaction.begin();
		manager.persist(actor);
		transaction.commit();
	}

	public void saveMovie(Movie movie) {
		transaction.begin();
		manager.persist(movie);
		transaction.commit();
	}

//	------------------------------------------------(find)-----------------------------------------------------------------------------------

	public void findActor(int id) {
		Actor actor = manager.find(Actor.class, id);

		if (actor != null) {
			System.out.println(actor);
		} else {
			System.out.println("invalid id");
		}
	}

	public void findMovie(int id) {
		Movie movie = manager.find(Movie.class, id);
		if (movie != null) {
			System.out.println(movie);
		} else {
			System.out.println("invalid input");
		}
	}

	public void findMovieDetails(int id) {
		Movie movie = manager.find(Movie.class, id);
		if (movie != null) {
			System.out.println(movie);
			List<Actor> actors = movie.getActors();
			if (!actors.isEmpty()) {

				for (Actor actor : actors) {
					System.out.println(actor);
				}
			} else {
				System.out.println("no actors found");
			}
		} else {
			System.out.println("invalid input");
		}
	}

	public void getAllRecords() {
		Query query = manager.createQuery("select DISTINCT record from Movie record LEFT JOIN FETCH record.actors");
		List<Movie> movieList = query.getResultList();
		if (!movieList.isEmpty()) {
			for (Movie movie : movieList) {
				System.out.println(movie);

				for (Actor actor : movie.getActors()) {
					System.out.println(actor);
				}
				System.out.println();
			}
		}
	}

//	------------------------------------------------update-----------------------------------------------------------------------------------
	public void addNewActors(int movieId, List<Actor> actors) {
		Movie movie = manager.find(Movie.class, movieId);

		if (movie != null) {
			List<Actor> list = movie.getActors();
			if (!actors.isEmpty()) {
				for (Actor actor : actors) {
					actor.setMovie(movie);
					list.add(actor);
				}
			} else {
				System.out.println("actors list is empty");
			}
		} else {
			System.out.println("movie not found");
		}
		transaction.begin();
		manager.merge(movie);
		transaction.commit();
	}

	public void addNewActor(int movieId, Actor actor) {
		Movie movie = manager.find(Movie.class, movieId);
		if (movie != null) {
			List<Actor> list = movie.getActors();
			if (actor != null) {
				list.add(actor);
				movie.setActors(list);
				actor.setMovie(movie);
				transaction.begin();
				manager.merge(movie);
				transaction.commit();
			} else {
				System.out.println("actor not found");
			}
		} else {
			System.out.println("movie not found");
		}
	}

	public void updateActorsMovie(int newMovieId, int actorId) {
		Movie movie = manager.find(Movie.class, newMovieId);
		Actor actor = manager.find(Actor.class, actorId);
		if (movie != null) {
			if (actor != null) {
				actor.setMovie(movie);
				movie.getActors().add(actor);
				transaction.begin();
				manager.merge(movie);
				transaction.commit();
			} else {
				System.out.println("movie not found");
			}
		} else {
			System.out.println("movie not found");
		}

	}
//	--------------------------------------------delete----------------------------------------------------------------------------------

	public void removeActor(int actorId) {
		Actor actor = manager.find(Actor.class, actorId);
		if (actor != null) {
			actor.setMovie(null);
			transaction.begin();
			manager.remove(actor);
			transaction.commit();

		}
	}

	public void removeMovie(int movieId) {
		Movie movie = manager.find(Movie.class, movieId);
		if (movie != null) {
			List<Actor> actorList = movie.getActors();
			movie.setActors(null);
			for (Actor actor : actorList) {
				actor.setMovie(null);
			}
			transaction.begin();
			manager.remove(movie);
			transaction.commit();
		} else {
			System.out.println("Movie Not Found");
		}
	}

	public void removeActorFromMovie(int movieId, int actorId) {
		Movie movie = manager.find(Movie.class, movieId);
		Actor actor = manager.find(Actor.class, actorId);

		if (movie != null && actor != null) {
			if (movie.getActors().contains(actor)) {
				movie.getActors().remove(actor);
				actor.setMovie(null);
				transaction.begin();
				manager.merge(movie);
				transaction.commit();
			}
		}
	}
}
