package one_to_many_bi_controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import one_to_many_bi_dao.Library_Books_Dao;
import one_to_many_bi_dto.Books;
import one_to_many_bi_dto.Library;

public class Library_Books_Controller {
	static Library_Books_Dao library_Books_Dao = new Library_Books_Dao();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		runApplication();

	}

	public static void runApplication() {
		System.out.println("-------------------------***-------------------------------------------------");
		System.out.println();
		System.out.println("-------------------------***-------------------------------------------------");
		System.out.println("insert your choice->:  \n1: insert Library" + " \n2: insert book" + " \n3: update Library"
				+ " \n4: update Book" + " \n5: delete book" + " \n6: delete Library" + " \n7: delete Library with Books"
				+ " \n8: delete books with library" + " \n9: add new book to existing library"
				+ " \n10: update books library" + " \n11: print all records" + " \n12: print all Libraries"
				+ " \n13: print all books \n14: get library \n15: get book \n16: Exit");
		int choice = sc.nextInt();

		switch (choice) {
		case 1:
			System.out.println("To insert new Library");
			Library library = new Library();
			int newLibraryId = library_Books_Dao.getLibraryId();
			library.setId(newLibraryId);
			System.out.println("your library id: " + newLibraryId);
			System.out.println("Enter Library Name:");
			String newLibraryName = sc.next();
			library.setName(newLibraryName);
			System.out.println("enter library phone number");
			long newPhoneNum = sc.nextLong();
			library.setPhoneNo(newPhoneNum);
			System.out.println("enter Location");
			String newLocation = sc.next();
			library.setPlace(newLocation);
			System.out.println("do you want to add Library (yes/no)");
			String input = sc.next();
			if (input.equalsIgnoreCase("yes")) {
				Books book = new Books();
				List<Books> list = new ArrayList<Books>();
				System.out.println("how many books you want to add");
				int noOfBooksToAdd = sc.nextInt();
				for (int i = 1; i <= noOfBooksToAdd; i++) {
					int newBookId = library_Books_Dao.getBookId();
					System.out.println("book id: " + newBookId);
					book.setId(newBookId);
					System.out.println("enter Author name");
					String newAuthorName = sc.next();
					book.setAuthor(newAuthorName);
					System.out.println("enter book name");
					String newBookName = sc.next();
					book.setName(newBookName);
					System.out.println("enter book Price");
					double newBookPrice = sc.nextDouble();
					book.setPrice(newBookPrice);
					list.add(book);
				}
				library.setBooks(list);
				library_Books_Dao.saveLibrary(library);

			} else {
				library_Books_Dao.saveLibrary(library);
			}
			runApplication();
			break;
		case 2:

			Books addBook = new Books();
			List<Books> listBook = new ArrayList<Books>();
			System.out.println("how many books you want to add");
			int noOfBooksToAdd = sc.nextInt();
			for (int i = 1; i <= noOfBooksToAdd; i++) {
				int newBookId = library_Books_Dao.getBookId();
				System.out.println("book id: " + newBookId);
				addBook.setId(newBookId);
				System.out.println("enter Author name");
				String newAuthorName = sc.next();
				addBook.setAuthor(newAuthorName);
				System.out.println("enter book name");
				String newBookName = sc.next();
				addBook.setName(newBookName);
				System.out.println("enter book Price");
				double newBookPrice = sc.nextDouble();
				addBook.setPrice(newBookPrice);
				listBook.add(addBook);
			}

			System.out.println("do you want to add books (yes/no)");
			String inputToAddLibrary = sc.next();
			if (inputToAddLibrary.equalsIgnoreCase("yes")) {

				System.out.println("To insert new Library");
				Library libraryByBook = new Library();
				int newLibraryIdByBook = library_Books_Dao.getLibraryId();
				libraryByBook.setId(newLibraryIdByBook);
				System.out.println("your library id: " + newLibraryIdByBook);
				System.out.println("Enter Library Name:");
				String newLibraryNameByBook = sc.next();
				libraryByBook.setName(newLibraryNameByBook);
				System.out.println("enter library phone number");
				long newPhoneNumByBook = sc.nextLong();
				libraryByBook.setPhoneNo(newPhoneNumByBook);
				System.out.println("enter Location");
				String newLocationByBook = sc.next();
				libraryByBook.setPlace(newLocationByBook);
				for (Books books : listBook) {
					books.setLibrary(libraryByBook);
				}
				library_Books_Dao.saveBooks(addBook);

			} else {
				library_Books_Dao.saveBooks(addBook);
			}
			runApplication();
			break;
		case 3:
			System.out.println("To update Library detalis:");
			System.out.println("Insert id of Lirary to want to update");
			int updateLibraryId = sc.nextInt();
			System.out.println("enter name of the library");
			String updateLibraryName = sc.next();
			System.out.println("Enter phone no you want to set");
			long updatePhoneNo = sc.nextLong();
			System.out.println("Enter place you want to set");
			String updatePlace = sc.next();
			library_Books_Dao.updateLibraryDetails(updateLibraryId, updateLibraryName, updatePhoneNo, updatePlace);
			runApplication();
			break;
		case 4:
			System.out.println("to update book price enter book id");
			int updateBookPriceId = sc.nextInt();
			System.out.println("Enter price you want to set");
			double updatePrice = sc.nextDouble();
			library_Books_Dao.updateBookPrice(updateBookPriceId, updatePrice);
			runApplication();
			break;
		case 5:
			System.out.println("do you want to delete book (yes/no)");
			String inputToDeleteBook = sc.next();
			if (inputToDeleteBook.equalsIgnoreCase("yes")) {
				System.out.println("Enter book id you want to delete");
				int bookIdToDelete = sc.nextInt();
				library_Books_Dao.deleteBookWithoutLibrary(bookIdToDelete);
			} else {
				runApplication();
			}
			break;
		case 6:
			System.out.println("do you want to delete Library (yes/no)");
			String inputToDeleteLibrary = sc.next();
			if (inputToDeleteLibrary.equalsIgnoreCase("yes")) {
				System.out.println("to delete library enter library id");
				int libraryIdToDelete = sc.nextInt();
				library_Books_Dao.deleteLibraryWithoutBooks(libraryIdToDelete);
			} else {
				runApplication();
			}
			break;
		case 7:
			System.out.println("do you want to delete Library your books will also get deleted (yes/no)");
			String inputToDeleteLibraryAndBooks = sc.next();
			if (inputToDeleteLibraryAndBooks.equalsIgnoreCase("yes")) {
				System.out.println("enter lirary id which you want to delete");
				int libraryIdToDeleteLibAndBook = sc.nextInt();
				library_Books_Dao.deleteLibraryWithBooks(libraryIdToDeleteLibAndBook);
			} else {
				runApplication();
			}
			break;
		case 8:
			System.out.println("do you want to delete books your library also get deleted  (yes/no)");
			String inputToDeleteBooksAndLib = sc.next();
			if (inputToDeleteBooksAndLib.equalsIgnoreCase("yes")) {
				System.out.println("enter lirary id which you want to delete");
				int BookIdToDeleteBookAndLib = sc.nextInt();
				library_Books_Dao.deleteLibraryWithBooks(BookIdToDeleteBookAndLib);
			} else {
				runApplication();
			}
			break;
		case 9:
			System.out.println("To add new book to existing library");
//			addNewBooksToLibrary(int id, List<Books> books)
			System.out.println("enter Library in which you wanted to add book");
			int newLibId = sc.nextInt();

			Books addNewBook = new Books();
			List<Books> listNewBook = new ArrayList<Books>();
			System.out.println("how many books you want to add");
			int noOfNewBooksToAdd = sc.nextInt();
			for (int i = 1; i <= noOfNewBooksToAdd; i++) {
				int newBookId = library_Books_Dao.getBookId();
				System.out.println("book id: " + newBookId);
				addNewBook.setId(newBookId);
				System.out.println("enter Author name");
				String newAuthorName = sc.next();
				addNewBook.setAuthor(newAuthorName);
				System.out.println("enter book name");
				String newBookName = sc.next();
				addNewBook.setName(newBookName);
				System.out.println("enter book Price");
				double newBookPrice = sc.nextDouble();
				addNewBook.setPrice(newBookPrice);
				listNewBook.add(addNewBook);
			}
			library_Books_Dao.addNewBooksToLibrary(newLibId, listNewBook);
			runApplication();
			break;
		case 10:
			System.out.println("to update book library enter book id");
			int bookId = sc.nextInt();
			System.out.println("enter library id");
			int libId = sc.nextInt();
			library_Books_Dao.updateBookLibrary(bookId, libId);
			runApplication();
			break;
		case 11:
			System.out.println("All records are");
			library_Books_Dao.findAllRecords();
			runApplication();
			break;
		case 12:
			System.out.println("All libraries are");
			library_Books_Dao.findAllLibraries();
			runApplication();
			break;
		case 13:
			System.out.println("ALL Books are");
			library_Books_Dao.findAllBooks();
			runApplication();
			break;
		case 14:
			System.out.println("to find library enter book id");
			int getLibrary = sc.nextInt();
			library_Books_Dao.findLibraryById(getLibrary);
			runApplication();
			break;
		case 15:
			System.out.println("to find book enter book id");
			int getBookId = sc.nextInt();
			library_Books_Dao.findBookById(getBookId);
			runApplication();
			break;
		case 16:
			System.out.println("Do you want to exit (Yes/no)");
			String dec = sc.next();
			if (dec.equalsIgnoreCase("yes")) {
				System.out.println("thank you");
				break;
			} else {
				runApplication();
			}
			break;
		default:
			System.out.println("enter 16 to exit");
			runApplication();
			break;
		}
	}
}
