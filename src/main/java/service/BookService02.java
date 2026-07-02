package service;

import model.Book;

import java.util.List;

public interface BookService02 {
    void addBook(Book book);
    void searchBooksByAuthor(String author);
    List<Book> getAllBooksByAuthor(String author);
    void deleteBook(int id);
    void updateBook(Book book);
    List<Book>getAllBooks();
    void issueBook(int bookId,int memberId);
    void returnBook(int bookId);
}
