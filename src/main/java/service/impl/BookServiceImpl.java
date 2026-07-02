package service.impl;

import model.Book;
import repository.BookRepository;
import repository.MemberRepository;
import repository.impl.BookRepositoryImpl;
import repository.impl.MemberRepositoryImpl;
import service.BookService02;

import java.util.List;

public class BookServiceImpl implements BookService02 {
    private BookRepository bookRepository = new BookRepositoryImpl();
    private MemberRepository memberRepository = new MemberRepositoryImpl();

    @Override
    public void addBook(Book book) {
       bookRepository.addBook(book);
    }

    @Override
    public void searchBooksByAuthor(String author) {

    }

    @Override
    public List<Book> getAllBooksByAuthor(String author) {
        return List.of();
    }

    @Override
    public void deleteBook(int id) {

    }

    @Override
    public void updateBook(Book book) {

    }

    @Override
    public List<Book> getAllBooks() {
        return List.of();
    }

    @Override
    public void issueBook(int bookId, int memberId) {

    }

    @Override
    public void returnBook(int bookId) {

    }
}
