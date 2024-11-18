package many_to_many.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import many_to_many.dao.Customer_Product_Dao;
import many_to_many.dto.Customer;
import many_to_many.dto.Products;

public class Customer_Product_Controller {
	static Scanner sc = new Scanner(System.in);
	static Customer_Product_Dao dao = new Customer_Product_Dao();

	public static void main(String[] args) {

		runApplication();
	}

	public static void runApplication() {
		System.out.println("Enter your choice To:" + " \n1: save Customer" + " \n2: save Product"
				+ " \n3: add new product to customer" + " \n4: add Existing product to customer"
				+ " \n5: remove product" + " \n6: remove customer" + " \n7: remove product from customer"
				+ " \n8: find product" + " \n9: find customer" + " \n10: get all record's" + " \n11: exit");
		int enterChoice = sc.nextInt();

		switch (enterChoice) {
		case 1:
			System.out.println("do you want to Create new Customer (Yes/no)");
			String wantTocreate = sc.next();
			if (wantTocreate.equalsIgnoreCase("yes")) {
				System.out.println("how many customers you want to add");
				int totalCustomres = sc.nextInt();
				List<Customer> custList = new ArrayList<Customer>();
				for (int i = 1; i <= totalCustomres; i++) {
					Customer customer = new Customer();
					System.out.println("Enter customer Id");
					int newCustId = sc.nextInt();
					customer.setId(newCustId);
					System.out.println("Enter customer name");
					String newCustName = sc.next();
					customer.setName(newCustName);
					System.out.println("Enter customer mob.no");
					Long newMobNo = sc.nextLong();
					customer.setMobNo(newMobNo);
					System.out.println("Enter Customer Address");
					String newCustAddress = sc.next();
					customer.setAddress(newCustAddress);
					System.out.println(i + " customer added");
					custList.add(customer);
				}
				System.out.println("do you want to add products (Yes/no)");
				String wantToAddItems = sc.next();
				if (wantToAddItems.equalsIgnoreCase("yes")) {
					List<Products> prodList = new ArrayList<Products>();
					System.out.println("how many products you want to add");
					int totalProducts = sc.nextInt();
					for (int i = 1; i <= totalProducts; i++) {
						Products product = new Products();
						System.out.println("Enter product id");
						int newProductId = sc.nextInt();
						product.setId(newProductId);
						System.out.println("enter product name");
						String newProdName = sc.next();
						product.setName(newProdName);
						System.out.println("Enter product cost");
						double newProdCost = sc.nextDouble();
						product.setCost(newProdCost);
						System.out.println("enter product quantity");
						int newProdQuantity = sc.nextInt();
						product.setQuantity(newProdQuantity);
						System.out.println(i + " Product added");
						prodList.add(product);
					}
					for (Customer customer : custList) {
						customer.setProducts(prodList);
					}
					dao.saveCustomers(custList);
					runApplication();
					break;
				} else {
					dao.saveCustomers(custList);
					runApplication();
					break;
				}
			} else {
				runApplication();
				break;
			}
		case 2:
			System.out.println("do you want to add new product (Yes/no)");
			String wantToAddProduct = sc.next();
			if (wantToAddProduct.equalsIgnoreCase("yes")) {
				Products product = new Products();
				System.out.println("enter product Id");
				int newProdIdToAdd = sc.nextInt();
				product.setId(newProdIdToAdd);
				System.out.println("Enter product Name ");
				String newProdNameToAdd = sc.next();
				product.setName(newProdNameToAdd);
				System.out.println("Enter the cost of Product");
				double newProdCostToAdd = sc.nextDouble();
				product.setCost(newProdCostToAdd);
				System.out.println("Enter the quantity of product");
				int newProdQuantityToAdd = sc.nextInt();
				product.setQuantity(newProdQuantityToAdd);
				dao.saveProduct(product);
			} else {
				runApplication();
				break;
			}
			runApplication();
			break;
		case 3:
			System.out.println("do you want to add new product (Yes/no)");
			String wantToAddProductInput = sc.next();
			if (wantToAddProductInput.equalsIgnoreCase("yes")) {

				System.out.println("Enter customer id to add new product");
				int custIdToAddProd = sc.nextInt();

				Products products = new Products();
				System.out.println("enter product Id");
				int newProdId = sc.nextInt();
				products.setId(newProdId);
				System.out.println("Enter product name");
				String newProdName = sc.next();
				products.setName(newProdName);
				System.out.println("Enter product cost");
				double newProdCost = sc.nextDouble();
				products.setCost(newProdCost);
				System.out.println("enter product quantity");
				int newProdQuantity = sc.nextInt();
				products.setQuantity(newProdQuantity);

				dao.addNewProductToCustomer(custIdToAddProd, products);

			} else {
				runApplication();
				break;
			}
			runApplication();
			break;
		case 4:
			System.out.println("enter product id");
			int existantProdId = sc.nextInt();
			System.out.println("enter customer id");
			int existantCustId = sc.nextInt();
			dao.addExistingProductToCustomer(existantProdId, existantCustId);
			runApplication();
			break;
		case 5:
			System.out.println("Enter product id to remove");
			int prodIdToRemove = sc.nextInt();
			dao.deleteProduct(prodIdToRemove);
			runApplication();
			break;
		case 6:
			System.out.println("enter customer id to remove ");
			int custIdToRemove = sc.nextInt();
			dao.removeCustomer(custIdToRemove);
			runApplication();
			break;
		case 7:
			System.out.println("enter product id from where you want to remove");
			int fromWhereToRemove = sc.nextInt();
			System.out.println("enter product id which you want to remove from customer");
			int prodIdToRemoveFromCust = sc.nextInt();
			dao.removeProductFromCustomer(fromWhereToRemove, prodIdToRemoveFromCust);
			runApplication();
			break;

		case 8:
			System.out.println("Enter product id to find");
			int findProductById = sc.nextInt();
			dao.findProduct(findProductById);
			runApplication();
			break;

		case 9:
			System.out.println("Enter customer id to find");
			int findCustomerById = sc.nextInt();
			dao.findCustomer(findCustomerById);
			runApplication();
			break;

		case 10:
			System.out.println("All Records are:");
			dao.findAllRecords();
			runApplication();
			break;
		case 11:
			System.out.println("do you want to exit (Yes/No)");
			String wantToExit = sc.next();
			if (wantToExit.equalsIgnoreCase("yes")) {
				System.out.println("Thank you");
				break;
			} else {
				runApplication();
				break;
			}
		default:
			System.out.println("wrong input want to exit press 11");
			runApplication();
			break;
		}
	}
}
