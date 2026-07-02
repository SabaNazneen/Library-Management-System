package repository;

import model.Book;
import java.util.List;

public interface BookRepository {
    /*Passing a domain object keeps the method signature clean,
     makes future changes easier, and avoids passing many
    individual parameters.*/
    void addBook(Book book); //Adding new books
    void deleteBook(int id); //Deleting books
    void updateBook(Book book); //Updating Book details
    List<Book> getAllBooks(); //Getting all the books available
    Book getBookByID(int id); //Books with their IDs
    List<Book> searchBooksByTitle(String title);//searching books by their title
    List<Book> searchBooksByAuthor(String author);
}
