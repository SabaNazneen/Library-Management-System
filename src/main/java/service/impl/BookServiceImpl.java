package service.impl;

import model.Book;
import model.Member;
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
    public Book getBookById(int id) {
        return bookRepository.getBookByID(id);
    }

    @Override
    public List<Book> searchBooksByAuthor(String author) {
       return bookRepository.searchBooksByAuthor(author);
    }
    @Override
    public void deleteBook(int id) {
        bookRepository.deleteBook(id);
    }
    @Override
    public void updateBook(Book book) {
        bookRepository.updateBook(book);
    }
    @Override
    public List<Book> getAllBooks() {

        return bookRepository.getAllBooks();
    }

    @Override
    public List<Book> searchBooksByTitle(String title) {
        return bookRepository.searchBooksByTitle(title);
    }

    @Override
    public void issueBook(int bookId, int memberId) {
            Book book = bookRepository.getBookByID(bookId);
            if(book==null){
                System.out.println("Book not found");
                return;
            }
            Member member = memberRepository.getMemberByID(memberId);
            if(member==null){
                System.out.println("Member not found");
                return;
            }
            if(book.getIssuedMemberId()!=null)
            {
                System.out.println("Book is already issued");
                return;
            }
            book.setIssuedMemberId(memberId);
            bookRepository.updateBook(book);
            System.out.println("Book issued");
        }



    @Override
    public void returnBook(int bookId) {
       Book book = bookRepository.getBookByID(bookId);
       if(book==null){
            System.out.println("Book not found");
            return;
       }
       if(book.getIssuedMemberId()==null){
           System.out.println("Book is not currently issued");
           return;
       }
       book.setIssuedMemberId(null);
       bookRepository.updateBook(book);
       System.out.println("Book returned");
    }
}
