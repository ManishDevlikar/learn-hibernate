package one_to_many_uni_dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import one_to_many_uni_dto.FlipKart;
import one_to_many_uni_dto.Items;

public class FlipKart_Items_Dao {

	private Scanner sc = new Scanner(System.in);
	private EntityManagerFactory entityManagerFactory = null;
	private EntityManager entityManager = null;
	private EntityTransaction entityTransaction = null;

	public EntityManager getManager() {
		entityManagerFactory = Persistence.createEntityManagerFactory("dev");
		return entityManagerFactory.createEntityManager();

	}

	public void saveFlipKart(FlipKart kart) {
		EntityManager manager = getManager();
		entityTransaction = manager.getTransaction();
		entityTransaction.begin();
		manager.persist(kart);
		entityTransaction.commit();
	}

	public void deleteFlipKart(int id) {
		entityManager = getManager();
		entityTransaction = entityManager.getTransaction();
		FlipKart flipKart = entityManager.find(FlipKart.class, id);
		if (flipKart != null) {
			entityTransaction.begin();
			entityManager.remove(flipKart);
			entityTransaction.commit();
		} else {
			System.out.println("invalid id");
		}
	}

	public void findFlipKart(int id) {
		entityManager = getManager();
		FlipKart flipKart = entityManager.find(FlipKart.class, id);
		if (flipKart != null) {
			List<Items> allList = flipKart.getList();
			if (!(allList.isEmpty())) {
				for (Items item : allList) {
					System.out.println(item);
				}
			} else {
				System.out.println("item not found");
			}
		} else {
			System.out.println("record not found");
		}
	}

	public void updateFlipKart(FlipKart flipKart) {
		entityManager = getManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(flipKart);
		entityTransaction.commit();
	}

	public void findAllFlipKart() {
		entityManager = getManager();
		Query query = entityManager
				.createQuery("select DISTINCT flipkart from FlipKart flipkart INNER JOIN FETCH flipkart.list");
		List<FlipKart> list = query.getResultList();

		for (FlipKart flipKart : list) {
			if (flipKart != null) {
				System.out.println(flipKart.getId());
				List<Items> allList = flipKart.getList();
				if (allList != null) {

					for (Items item : allList) {
						System.out.println(item);
					}
				} else {
					System.out.println("items not found");
				}
			} else {
				System.out.println("Account not found");
			}
		}
	}

	public int getFlipKartId() {
		entityManager = getManager();
		Query query = entityManager.createQuery("select flipkart from FlipKart flipkart");
		List<FlipKart> list = query.getResultList();
		int id = 100;
		for (FlipKart flipKart : list) {
			id = flipKart.getId();
		}
		return ++id;
	}

	public int getItemId() {
		entityManager = getManager();
		Query query = entityManager.createQuery("select item from Items item");
		List<Items> list = query.getResultList();
		int id = 100;
		for (Items item : list) {
			id = item.getId();
		}
		return ++id;
	}

	public void getFlipKart() {
		System.out.println("Create your Account");
		EntityManager manager = getManager();
		entityTransaction = manager.getTransaction();
		FlipKart flipKart = new FlipKart();
		int id = getFlipKartId();
		System.out.println("flipkart id: " + id);
		flipKart.setId(id);
		System.out.println("enter FlipKart Email Address");
		String email = sc.next();
		flipKart.setEmail(email);
		System.out.println("Enter Address");
		String address = sc.next();
		flipKart.setAddress(address);
		System.out.println("Enter mobile Number");
		String mobNo = sc.next();
		flipKart.setMno(mobNo);
		System.out.println("Enter GST Number");
		String gstNo = sc.next();
		flipKart.setGst(gstNo);

		System.out.println("do you want to add items (Yes or No)");
		String decision = sc.next();
		if (decision.equalsIgnoreCase("yes")) {
			List<Items> items = new ArrayList();
			System.out.println("\nHow many items do you want to add");
			int input = sc.nextInt();
			for (int i = 1; i <= input; i++) {
				Items item = new Items();
				int itemId = getItemId();
				System.out.println("item id: " + itemId);
				item.setId(itemId);
				System.out.println("Enter product you want to add");
				String prod = sc.next();
				item.setName(prod);
				System.out.println("Enter price you want to set");
				double price = sc.nextDouble();
				item.setPrice(price);
				System.out.println("Enter quantity");
				int quant = sc.nextInt();
				item.setQuantity(quant);
				items.add(item);
				flipKart.setList(items);
				System.out.println(i + ": Item added");
				entityTransaction.begin();
				manager.merge(flipKart);
				entityTransaction.commit();
			}
		} else {
			entityTransaction.begin();
			manager.persist(flipKart);
			entityTransaction.commit();
		}
		entityTransaction.begin();
		manager.merge(flipKart);
		entityTransaction.commit();
	}

	public void addNewItems(int id) {
		entityManager = getManager();
		entityTransaction = entityManager.getTransaction();
		FlipKart flipKart = entityManager.find(FlipKart.class, id);

		if (flipKart != null) {
			List<Items> prevItems = flipKart.getList();
			System.out.println("\nHow many items do you want to add");
			int input = sc.nextInt();
			for (int i = 1; i <= input; i++) {
				Items item = new Items();
				int itemId = getItemId();
				item.setId(itemId);
				System.out.println(item.getId());
				System.out.println("Enter product you want to add");
				String prod = sc.next();
				item.setName(prod);
				System.out.println("Enter price you want to set");
				double price = sc.nextDouble();
				item.setPrice(price);
				System.out.println("Enter quantity");
				int quant = sc.nextInt();
				item.setQuantity(quant);
				prevItems.add(item);
				System.out.println(i + ": Item added");
				entityTransaction.begin();
				flipKart.setList(prevItems);
				entityManager.merge(flipKart);
				entityTransaction.commit();
			}

		} else {
			System.out.println("account not found");
		}

	}

	public void deleteItemById(int flipkartId, int itemId) {
		entityManager = getManager();
		entityTransaction = entityManager.getTransaction();
		FlipKart flipKart = entityManager.find(FlipKart.class, flipkartId);
		Items item = entityManager.find(Items.class, itemId);

		if (flipKart != null) {
			entityTransaction.begin();
			flipKart.getList().remove(item);
			entityManager.remove(item);
			entityTransaction.commit();
			System.out.println("item deleted");
		} else {
			System.out.println("flipKart is empty");
		}

	}

	public void updateAccountInfo(int id) {
		entityManager = getManager();
		entityTransaction = entityManager.getTransaction();
		FlipKart flipKart = entityManager.find(FlipKart.class, id);
		if (flipKart != null) {
			List<Items> list = flipKart.getList();
			System.out.println("Your id is:" + flipKart.getId());
			System.out.println("Enter Your email");
			String username = sc.next();
			flipKart.setEmail(username);
			System.out.println("enter your gst-number");
			String gstNo = sc.next();
			flipKart.setGst(gstNo);
			System.out.println("enter your address");
			String address = sc.next();
			flipKart.setAddress(address);
			System.out.println("enter your mobile Number");
			String mobNo = sc.next();
			flipKart.setMno(mobNo);
			entityTransaction.begin();
			flipKart.setList(list);
			entityManager.merge(flipKart);
			entityTransaction.commit();
		} else {
			System.out.println("Account is not found");
		}
	}

	public void updateItem(int id) {
		entityManager = getManager();
		entityTransaction = entityManager.getTransaction();
		Items item = entityManager.find(Items.class, id);
		if (item != null) {
			System.out.println("item id: " + item.getId());
			System.out.println("enter quantity");
			int quantity = sc.nextInt();
			item.setQuantity(quantity);
			entityTransaction.begin();
			entityManager.merge(item);
			entityTransaction.commit();
		} else {
			System.out.println("item not found");
		}
	}
}
