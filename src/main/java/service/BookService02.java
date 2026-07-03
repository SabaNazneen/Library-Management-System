package service;

import model.Book;

import java.util.List;

public interface BookService02 {
    void addBook(Book book);
    List<Book> searchBooksByAuthor(String author);
    List<Book> searchBooksByTitle(String title);
    void deleteBook(int id);
    void updateBook(Book book);
    List<Book>getAllBooks();
    Book getBookById(int id);
    void issueBook(int bookId,int memberId);
    void returnBook(int bookId);
}
