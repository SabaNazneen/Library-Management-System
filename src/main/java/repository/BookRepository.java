package repository;

import model.Book;
import model.Member;

import java.util.List;

public interface BookRepository {
    /*Passing a domain object keeps the method signature clean,
     makes future changes easier, and avoids passing many
    individual parameters.*/
    void addBook(Book book); //Adding new books
    void deleteBook(int id); //Deleting books
    void updateBook(int id); //Updating Book details
    List<Book> getBooks(); //Getting all the books available
    List<Book>getBooksByID(int id); //Books with their IDs
    List<Book> searchBooksByTitle(String title); //searching books by their title
}
