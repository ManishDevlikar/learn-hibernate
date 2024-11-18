package one_to_one_uni_assi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import one_to_one_uni_assi.dto.Vehicle;
import one_to_one_uni_assi.dto.VehicleNumber;

public class Vehicle_VehicleNumber_dao {
	static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
	static EntityManager entityManager = entityManagerFactory.createEntityManager();
	static EntityTransaction entityTransaction = entityManager.getTransaction();

	public void saveVehicle(Vehicle vehicle) {
		if (vehicle != null) {

			entityTransaction.begin();
			entityManager.persist(vehicle);
			entityTransaction.commit();
		} else {
			System.out.println("Object is null");
		}
	}

	public void findVehicle(int vehicleId) {

		Vehicle vehicle = entityManager.find(Vehicle.class, vehicleId);

		if (vehicle != null) {
			System.out.println(vehicle.toString());
		}
	}

	public void updateVehicle(Vehicle vehicle) {
		if (vehicle != null) {
			entityTransaction.begin();
			entityManager.merge(vehicle);
			entityTransaction.commit();
		} else {
			System.out.println("Object is null");
		}
	}

	public void deleteVehicle(int vehicleId) {

		Vehicle vehicle = entityManager.find(Vehicle.class, vehicleId);
		if (vehicle != null) {
			entityTransaction.begin();
			entityManager.remove(vehicle);
			entityTransaction.commit();
			System.out.println("Object is removed");
		} else {
			System.out.println("Id not found");
		}
	}

	public void findAll() {
		Query query = entityManager.createQuery("select vehicle from Vehicle vehicle");
		List<Vehicle> list = query.getResultList();
		for (Vehicle vehicle : list) {
			System.out.println(vehicle);
		}
	}

	public void deleteNumber(int id) {
		VehicleNumber vn = entityManager.find(VehicleNumber.class, id);
		if (vn != null) {
			entityTransaction.begin();
			entityManager.remove(vn);
			entityTransaction.commit();
		} else {
			System.out.println("id not found");
		}
	}
}
