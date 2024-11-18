package one_to_many_bi_dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import one_to_many_bi_dto.Books;
import one_to_many_bi_dto.Library;

public class Library_Books_Dao {
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
	private EntityManager manager = factory.createEntityManager();
	private EntityTransaction transaction = manager.getTransaction();

//	---------------------------------(save)-------------------------------------------------------------------------	

	public void saveLibraryWithBooks(Library library) {

		transaction.begin();
		List<Books> list = library.getBooks();
		for (Books books : list) {
			books.setLibrary(library);
		}
		manager.persist(library);
		transaction.commit();
	}

	public void saveLibrary(Library library) {
		transaction.begin();
		manager.persist(library);
		transaction.commit();
	}

	public void saveBooks(Books books) {
		transaction.begin();
		manager.persist(books);
		transaction.commit();
	}

//	---------------------------------(delete)-------------------------------------------------------------------------

	public void deleteLibraryWithBooks(int id) {
		Library library = manager.find(Library.class, id);
		if (library != null) {
			transaction.begin();
			manager.remove(library);
			transaction.commit();
		}
	}

	public void deleteBooksWithLibrary(int id) {
		Books book = manager.find(Books.class, id);
		if (book != null) {
			transaction.begin();
			manager.remove(book);
			transaction.commit();
		}
	}

	public void deleteLibraryWithoutBooks(int id) {
		Library library = manager.find(Library.class, id);
		if (library != null) {
			List<Books> list = library.getBooks();
			transaction.begin();
			manager.remove(library);
			transaction.commit();

			if (!list.isEmpty()) {
				for (Books books : list) {
					books.setLibrary(null);
					transaction.begin();
					manager.merge(books);
					transaction.commit();
				}
			} else {
				System.out.println("Books not found");
			}
		} else {
			System.out.println("library not found");
		}
	}

	public void deleteBookWithoutLibrary(int id) {
		Books book = manager.find(Books.class, id);
		Library library = book.getLibrary();

		if (book != null) {
			transaction.begin();
			library.getBooks().remove(book);
			manager.remove(book);
			transaction.commit();
		}
		transaction.begin();
		manager.merge(library);
		transaction.commit();
	}

//	---------------------------------(update)-------------------------------------------------------------------------
//	public void addUnaddesBookToLibrary(int libraryId, int bookId) {
//		Library library = manager.find(Library.class, libraryId);
//		Books book = manager.find(Books.class, bookId);
//		if (library != null && book != null) {
//			List<Books> list = library.getBooks();
//			if (book.getLibrary() == null) {
//				book.setLibrary(library);
//				list.add(book);
//				transaction.begin();
//				library.setBooks(list);
//				manager.merge(library);
//				transaction.commit();
//			} else {
//				System.out.println("book belong to :" + book.getLibrary().getId() + " library");
//			}
//		} else {
//			System.out.println("library not found or book not found");
//		}
//	}

	public void addNewBooksToLibrary(int id, List<Books> books) {
		Library library = manager.find(Library.class, id);
		List<Books> list = library.getBooks();
		transaction.begin();
		for (Books books2 : books) {
			books2.setLibrary(library);
			list.add(books2);
		}
		manager.merge(library);
		transaction.commit();
	}

	public void updateBookPrice(int id, double price) {
		Books book = manager.find(Books.class, id);

		if (book != null) {
			book.setPrice(price);
			transaction.begin();
			manager.merge(book);
			transaction.commit();
		} else {
			System.out.println("book not found");
		}
	}

	public void updateLibraryDetails(int id, String name, long phoneNo, String place) {
		Library library = manager.find(Library.class, id);
		if (library != null) {
			library.setName(name);
			library.setPhoneNo(phoneNo);
			library.setPlace(place);
			transaction.begin();
			manager.merge(library);
			transaction.commit();
		} else {
			System.out.println("library not found");
		}
	}

	public void updateBookLibrary(int bookId, int NewLibraryId) {
		Books books = manager.find(Books.class, bookId);
		Library newLibrary = manager.find(Library.class, NewLibraryId);
		List<Books> list = newLibrary.getBooks();
		if (books != null && newLibrary != null) {
			books.setLibrary(null);
			transaction.begin();
			books.setLibrary(newLibrary);
			list.add(books);
			manager.merge(newLibrary);
			transaction.commit();
		} else {
			System.out.println("library not found");
		}
	}

//	---------------------------------(find)-------------------------------------------------------------------------	
	public void findAllRecords() {
		Query query = manager
				.createQuery("select distinct records from Library records INNER JOIN FETCH records.books");
		List<Library> list = query.getResultList();
		if (list != null) {
			for (Library library : list) {
				System.out.println(library.getId() + " " + library.getName());
				List<Books> list2 = library.getBooks();
				for (Books book : list2) {
					System.out.println(book);
				}
			}
		}
	}

	public void findAllBooks() {
		Query query = manager.createQuery("select book from Books book");
		List<Books> list = query.getResultList();
		if (!list.isEmpty()) {
			for (Books books : list) {
				System.out.println(books);
			}
		}
	}

	public void findAllLibraries() {
		Query query = manager.createQuery("select library from Library library");
		List<Library> list = query.getResultList();
		if (!list.isEmpty()) {
			for (Library library : list) {
				System.out.println(library.getId() + " " + library.getName());
			}
		}
	}

	public void findBookById(int id) {
		Books books = manager.find(Books.class, id);
		if (books != null) {
			if (books.getLibrary() != null) {
				System.out.println("Library Id: " + books.getLibrary().getId());
			} else {
				System.out.println("book is not associated with any library");
			}
			System.out.println(books);
		} else {
			System.out.println("invalid id");
		}
	}

	public void findLibraryById(int id) {
		Library library = manager.find(Library.class, id);
		if (library != null) {
			List<Books> list = library.getBooks();
			System.out.println(library.getId() + " " + library.getName());
			if (!list.isEmpty()) {

				for (Books books : list) {
					System.out.println(books);
				}
			} else {
				System.out.println("no books available in library");
			}
		} else {
			System.out.println("invalid library id");
		}
	}

//	----------------------------- To Get Id's --------------------------------------------------------

	public int getLibraryId() {
		Query query = manager.createQuery("select library From Library library");
		List<Library> list = query.getResultList();
		int id = 100;
		for (Library library : list) {
			id = library.getId();
		}
		return ++id;
	}

	public int getBookId() {
		Query query = manager.createQuery("select book from Books book");
		List<Books> list = query.getResultList();
		int id = 100;
		for (Books books : list) {
			id = books.getId();
		}
		return ++id;
	}
}
