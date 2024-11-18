package one_to_one_uni_assi.controller;

import java.util.Scanner;

import one_to_one_uni_assi.dao.Vehicle_VehicleNumber_dao;
import one_to_one_uni_assi.dto.Vehicle;
import one_to_one_uni_assi.dto.VehicleNumber;

public class Vehicle_VehicleNumber_controller {
	static Scanner sc = new Scanner(System.in);

	static Vehicle_VehicleNumber_dao vehicle_VehicleNumber_dao = new Vehicle_VehicleNumber_dao();

	public static void main(String[] args) {
		runApplication();
//		vehicle_VehicleNumber_dao.deleteNumber(102);
	}

	public static void runApplication() {
		System.out.println("select 1:create  2:update  3:remove  4:find  5:findAll  6:exit");
		int option = sc.nextInt();

		switch (option) {
		case 1:
			System.out.println("Vehicle details");
			System.out.println("Enter vehicle type (ex. car,bike,truck)");
			String type = sc.next();
			System.out.println("Enter vehicle id");
			int id = sc.nextInt();
			System.out.println("Enter price");
			double price = sc.nextDouble();
			Vehicle vehicle = new Vehicle();
			vehicle.setType(type);
			vehicle.setVehicleId(id);
			vehicle.setPrice(price);
			VehicleNumber vehicleNumber = new VehicleNumber();
			System.out.println("vehicle number details");
			System.out.println("enter vehicle number id");
			int noId = sc.nextInt();
			System.out.println("enter registered number");
			String regNumber = sc.next();
			System.out.println("enter issued date");
			String issuedDate = sc.next();
			System.out.println("enter owner name");
			String owner = sc.next();
			System.out.println("enter region");
			String region = sc.next();
			vehicleNumber.setId(noId);
			vehicleNumber.setNumber(regNumber);
			vehicleNumber.setIssuedDate(issuedDate);
			vehicleNumber.setOwner(owner);
			vehicleNumber.setRegion(region);
			vehicle.setVehicleNumber(vehicleNumber);
			vehicle_VehicleNumber_dao.saveVehicle(vehicle);
			runApplication();
			break;
		case 2:
			System.out.println("Enter the id you want to update");
			System.out.println("Enter vehicle id");
			int idUpdate = sc.nextInt();
			System.out.println("enter vehicle type");
			String typeUpdate = sc.next();
			System.out.println("Enter price");
			double priceUpdate = sc.nextDouble();
			Vehicle vehicleUpdate = new Vehicle();
			vehicleUpdate.setType(typeUpdate);
			vehicleUpdate.setVehicleId(idUpdate);
			vehicleUpdate.setPrice(priceUpdate);
			VehicleNumber vehicleNumberUpdate = new VehicleNumber();
			System.out.println("vehicle number details");
			System.out.println("enter vehicle number id");
			int noIdUpdate = sc.nextInt();
			System.out.println("enter registered number");
			String regNumberUpdate = sc.next();
			System.out.println("enter issued date");
			String issuedDateUpdate = sc.next();
			System.out.println("enter owner name");
			String ownerUpdate = sc.next();
			System.out.println("enter region");
			String regionUpdate = sc.next();
			vehicleNumberUpdate.setId(noIdUpdate);
			vehicleNumberUpdate.setNumber(regNumberUpdate);
			vehicleNumberUpdate.setIssuedDate(issuedDateUpdate);
			vehicleNumberUpdate.setOwner(ownerUpdate);
			vehicleNumberUpdate.setRegion(regionUpdate);
			vehicleUpdate.setVehicleNumber(vehicleNumberUpdate);
			vehicle_VehicleNumber_dao.updateVehicle(vehicleUpdate);
			runApplication();
			break;
		case 3:
			System.out.println("Enter a three digit Vehicle Id To delete record");
			int deleteId = sc.nextInt();
			vehicle_VehicleNumber_dao.deleteVehicle(deleteId);
			runApplication();
			break;
		case 4:
			System.out.println("Enter a three digit Vehicle Id To get record");
			int findId = sc.nextInt();
			vehicle_VehicleNumber_dao.findVehicle(findId);
			runApplication();
			break;
		case 5:
			vehicle_VehicleNumber_dao.findAll();
			break;
		case 6:
			System.out.println("Thank you ");
			break;
		default:
			System.out.println("Invalid Option");
			break;
		}

	}

}
