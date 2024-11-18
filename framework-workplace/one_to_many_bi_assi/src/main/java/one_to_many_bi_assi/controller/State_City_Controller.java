package one_to_many_bi_assi.controller;

import java.util.ArrayList;
import java.util.List;

import one_to_many_bi_assi.dao.State_City_Dao;
import one_to_many_bi_assi.dto.City;
import one_to_many_bi_assi.dto.State;

public class State_City_Controller {
	static State_City_Dao dao = new State_City_Dao();

	public static void main(String[] args) {
		City city = new City();
		city.setId(102);
		city.setMayor("manish");
		city.setPopulation(20);
		city.setName("mumbai");
		List<City> list = new ArrayList();
		list.add(city);

		State state = new State();
		state.setId(102);
		state.setName("maharastra");
		state.setCapital("mumbai");
		state.setCm("eknath shinde");
		state.setDateOfFormation("1890");
		city.setState(state);
		state.setCities(list);
		dao.saveState(state);
	}
}
