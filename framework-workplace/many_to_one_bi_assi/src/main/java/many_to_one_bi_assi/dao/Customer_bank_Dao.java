package many_to_one_bi_assi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import many_to_one_bi_assi.dto.Bank;
import many_to_one_bi_assi.dto.Customer;

public class Customer_bank_Dao {
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
	private EntityManager manager = factory.createEntityManager();
	private EntityTransaction transaction = manager.getTransaction();

//	-----------------------------------------------save-------------------------------------------------------------

	public void saveBank(Bank bank) {
		transaction.begin();
		manager.persist(bank);
		transaction.commit();
	}

	public void saveCustomer(Customer customer) {
		transaction.begin();
		manager.persist(customer);
		transaction.commit();
	}

	public void saveBank2(Bank bank) {
		transaction.begin();
		List<Customer> custList = bank.getCustomer();
		for (Customer customer : custList) {
			customer.setBank(bank);
		}
		manager.persist(bank);
		transaction.commit();
	}

//	-----------------------------------------------find---------------------------------------------------------------

	public void findBank(int id) {
		Bank bank = manager.find(Bank.class, id);
		if (bank != null) {
			System.out.println(bank);
		}
	}

	public void findCustomer(int id) {
		Customer customer = manager.find(Customer.class, id);
		if (customer != null) {
			System.out.println(customer);
		}
	}

	public void findBankWithCustomers(int id) {
		Bank bank = manager.find(Bank.class, id);
		if (bank != null) {
			List<Customer> custList = bank.getCustomer();
			System.out.println(bank);
			for (Customer customer : custList) {
				System.out.println(customer);
			}
		}
	}

	public void findCustomerWithBank(int custId) {
		Customer customer = manager.find(Customer.class, custId);

		if (customer != null) {
			Bank bank = customer.getBank();
			System.out.println(customer);
			if (bank != null) {
				System.out.println(bank);
			}
		}
	}

	public void findAllRecords() {
		Query query = manager.createQuery("select DISTINCT record from Bank record LEFT JOIN FETCH record.customer");
		List<Bank> bankList = query.getResultList();
		for (Bank bank : bankList) {
			System.out.println(bank);
			List<Customer> custList = bank.getCustomer();
			for (Customer customer : custList) {
				System.out.println(customer);
			}
			System.out.println();
		}
	}
//----------------------------------------------------------update--------------------------------------------------------------

	public void addCustomer(int bankId, Customer customer) {
		Bank bank = manager.find(Bank.class, bankId);
		if (bank != null) {
			bank.getCustomer().add(customer);
			customer.setBank(bank);
			transaction.begin();
			manager.merge(bank);
			transaction.commit();

		} else {
			System.out.println("bank not found");
		}
	}

	public void changeBank(int newBankId, int custId) {
		Bank bank = manager.find(Bank.class, newBankId);
		Customer customer = manager.find(Customer.class, custId);

		if (bank != null) {
			customer.setBank(bank);
			bank.getCustomer().add(customer);
			transaction.begin();
			manager.merge(customer);
			transaction.commit();
		} else {
			System.out.println("bank not found");
		}
	}

//----------------------------------------------------------delete--------------------------------------------------------------
	public void removeCustomer(int custId) {
		Customer customer = manager.find(Customer.class, custId);
		if (customer != null && customer.getBank() != null) {
			Bank bank = customer.getBank();
			bank.getCustomer().remove(customer);
			customer.setBank(null);
			transaction.begin();
			manager.remove(customer);
			transaction.commit();
		} else {
			transaction.begin();
			manager.remove(customer);
			transaction.commit();
		}
	}

	public void removeBank(int bankId) {
		Bank bank = manager.find(Bank.class, bankId);
		if (bank != null) {
			List<Customer> customer = bank.getCustomer();
			for (Customer cust : customer) {
				cust.setBank(null);
			}
			bank.setCustomer(null);
			transaction.begin();
			manager.remove(bank);
			transaction.commit();
		}
	}

	public void removeCustomerFromBank(int custId) {
		Customer customer = manager.find(Customer.class, custId);
		if (customer != null) {
			Bank bank = customer.getBank();
			if (bank != null) {
				bank.getCustomer().remove(customer);
				customer.setBank(null);
				transaction.begin();
				manager.merge(bank);
				transaction.commit();
			} else {
				System.out.println("not attached to any bank");
			}
		} else {
			System.out.println("Account Not Found");
		}
	}

	public void removeBankWithAccounts(int bankId) {
		Bank bank = manager.find(Bank.class, bankId);
		if (bank != null) {
			transaction.begin();
			manager.remove(bank);
			transaction.commit();
		}
	}
}
