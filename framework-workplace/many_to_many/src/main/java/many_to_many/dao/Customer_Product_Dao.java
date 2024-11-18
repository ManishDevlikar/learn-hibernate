package many_to_many.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import many_to_many.dto.Customer;
import many_to_many.dto.Products;

public class Customer_Product_Dao {
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
	private EntityManager manager = factory.createEntityManager();
	private EntityTransaction transaction = manager.getTransaction();

//----------------------------------------------------------save---------------------------------------------------------------------------------
	public void saveCustomers(List<Customer> customer) {

		for (Customer cust : customer) {
			transaction.begin();
			manager.persist(cust);
			transaction.commit();
		}
	}

	public void saveCustomer(Customer customer) {
		transaction.begin();
		manager.merge(customer);
		transaction.commit();
	}

	public void saveProduct(Products product) {
		transaction.begin();
		manager.persist(product);
		transaction.commit();
	}

//--------------------------------------------------------find------------------------------------------------------------------------------------
	public void findProduct(int id) {
		Products product = manager.find(Products.class, id);
		if (product != null) {
			System.out.println(product);
		}
	}

	public void findCustomer(int id) {
		Customer customer = manager.find(Customer.class, id);
		if (customer != null) {
			System.out.println(customer);
			for (Products product : customer.getProducts()) {
				System.out.println(product);
			}
		} else {
			System.out.println("customer not found");
		}
	}

	public void findAllRecords() {
		Query query = manager
				.createQuery("select DISTINCT record from Customer record INNER JOIN FETCH record.products");
		List<Customer> list = query.getResultList();

		for (Customer customer : list) {
			if (customer != null) {
				List<Products> productList = customer.getProducts();
				System.out.println("\n" + customer);
				if (!productList.isEmpty()) {
					for (Products prod : productList) {
						System.out.println(prod);
					}
				}
			}

		}
	}

//---------------------------------------------------delete---------------------------------------------------------------------------------
	public void removeProductFromCustomer(int custId, int prodId) {
		Customer customer = manager.find(Customer.class, custId);
		if (customer != null) {
			Products product = manager.find(Products.class, prodId);
			if (product != null) {
				customer.getProducts().remove(product);
				transaction.begin();
				manager.merge(customer);
				transaction.commit();
			} else {
				System.out.println("product not found");
			}
		} else {
			System.out.println("customer not found");
		}
	}

	public void removeCustomer(int custId) {
		Customer customer = manager.find(Customer.class, custId);
		if (customer != null) {
			customer.setProducts(null);
			transaction.begin();
			manager.remove(customer);
			transaction.commit();
		}
	}

	public void deleteProduct(int prodId) {
		Query query = manager.createQuery("select record from Customer record");
		List<Customer> list = query.getResultList();
		Products product = manager.find(Products.class, prodId);

		for (Customer customer : list) {
			List<Products> prodList = customer.getProducts();
			for (Products prod : prodList) {
				if (prod.equals(product)) {
					customer.getProducts().remove(product);
				}
			}
		}
		transaction.begin();
		manager.remove(product);
		transaction.commit();
	}
//	------------------------------------------------------update----------------------------------------------------------------------------

	public void addNewProductToCustomer(int custId, Products product) {
		Customer customer = manager.find(Customer.class, custId);

		if (customer != null && product != null) {
			if (!customer.getProducts().contains(product)) {
				customer.getProducts().add(product);
				transaction.begin();
				manager.merge(customer);
				transaction.commit();
			} else {
				System.out.println("customer has this product");
			}
		} else {
			System.out.println("customer not found or product not initilize");
		}
	}

	public void addNewProductToCustomer(int custId, List<Products> list) {
		Customer customer = manager.find(Customer.class, custId);
		if (customer != null) {
			List<Products> productList = customer.getProducts();
			if (!list.isEmpty()) {
				productList.addAll(list);
				customer.setProducts(productList);
				transaction.begin();
				manager.merge(customer);
				transaction.commit();

			} else {
				System.out.println("list is empty");
			}
		} else {
			System.out.println("product not found");
		}
	}

	public void addExistingProductToCustomer(int prodId, int custId) {
		Products product = manager.find(Products.class, prodId);
		Customer customer = manager.find(Customer.class, custId);

		if (product != null && customer != null) {
			if (!customer.getProducts().contains(product)) {
				customer.getProducts().add(product);
				transaction.begin();
				manager.merge(customer);
				transaction.commit();
			} else {
				System.out.println("item alredy exist");
			}
		} else {
			System.out.println("please enter valid id's");
		}
	}

	public void updateCustomerName(int custId, String name) {
		Customer customer = manager.find(Customer.class, custId);
		if (customer != null) {
			customer.setName(name);
			transaction.begin();
			manager.merge(customer);
			transaction.commit();
		} else {
			System.out.println("customer not found");
		}
	}

	public void updateCustomerPhoneNo(int custId, long numb) {
		Customer customer = manager.find(Customer.class, custId);
		if (customer != null) {
			customer.setMobNo(numb);
			transaction.begin();
			manager.merge(customer);
			transaction.commit();
		} else {
			System.out.println("customer not found");
		}
	}

	public void updateCustomerAddress(int custId, String address) {
		Customer customer = manager.find(Customer.class, custId);
		if (customer != null) {
			customer.setAddress(address);
			transaction.begin();
			manager.merge(customer);
			transaction.commit();
		} else {
			System.out.println("customer not found");
		}
	}
}
