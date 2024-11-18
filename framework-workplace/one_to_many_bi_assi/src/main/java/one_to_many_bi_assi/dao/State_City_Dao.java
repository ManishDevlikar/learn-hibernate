package one_to_many_bi_assi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import one_to_many_bi_assi.dto.City;
import one_to_many_bi_assi.dto.State;

public class State_City_Dao {
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
	private EntityManager manager = factory.createEntityManager();
	private EntityTransaction transaction = manager.getTransaction();

//	-----------------------------------------------save---------------------------------------------------------------
	public void saveState(State state) {
		transaction.begin();
		manager.persist(state);
		transaction.commit();
	}

	public void saveCity(City city) {
		transaction.begin();
		manager.persist(city);
		transaction.commit();
	}

//	-----------------------------------------------find---------------------------------------------------------------
	public void findAllState() {
		Query query = manager.createQuery("select state from State state");

		List<State> list = query.getResultList();

		for (State state : list) {
			System.out.println("state Id: " + state.getId());
			List<City> cityList = state.getCities();
			for (City city : cityList) {
				System.out.println(city);
			}
		}
	}

	public void findAllCityes() {
		Query query = manager.createQuery("select city from City city");
		List<City> list = query.getResultList();
		for (City city : list) {
			System.out.println(city);
		}
	}

	public void findStateById(int id) {
		State state = manager.find(State.class, id);
		if (state != null) {
			System.out.println(state);
		}
	}

	public void findCityById(int id) {
		City city = manager.find(City.class, id);
		if (city != null) {
			System.out.println(city);
		}
	}

	public void getAllRecords() {
		Query query = manager.createQuery("select record from State record INNER JOIN FETCH record.cities");
		List<State> list = query.getResultList();
		for (State state : list) {
			System.out.println("State Id: " + state.getId());
			for (City city : state.getCities()) {
				System.out.println(city);
			}
		}
	}

//	----------------------------------------------- delete ---------------------------------------------------------------
	public void deleteCityWithState(int id) {
		City city = manager.find(City.class, id);
		transaction.begin();
		manager.remove(city);
		transaction.commit();
	}

	public void deleteStateWithCity(int id) {
		State state = manager.find(State.class, id);
		transaction.begin();
		manager.remove(state);
		transaction.commit();
	}

//	------------------------------------------------- update --------------------------------------------------------------

//	-------------------------------------------------- create id's ------------------------------------------------------

	public int getStateId() {
		Query query = manager.createQuery("select state from State state");
		List<State> list = query.getResultList();

		int id = 100;

		for (State state : list) {
			id = state.getId();
		}
		return ++id;
	}

	public int getCityId() {
		Query query = manager.createQuery("select city from City city");
		List<City> list = query.getResultList();
		int id = 100;
		for (City city : list) {
			id = city.getId();
		}
		return ++id;
	}
}
