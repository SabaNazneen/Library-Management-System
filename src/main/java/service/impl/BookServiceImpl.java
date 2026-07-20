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
    private BookRepository bookRepository;
    private MemberRepository memberRepository;

    public BookServiceImpl(BookRepository bookRepository, MemberRepository memberRepository) {
        this.bookRepository = bookRepository;
        this.memberRepository = memberRepository;
    }

    @Override
    public void addBook(Book book) {
        Book existing = bookRepository.getBookByID(book.getId());
        if (existing != null) {
            System.out.println("Book with ID " + book.getId() + " already exists.");
            return;
        }
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
        Book existingBook = bookRepository.getBookByID(id);
        if(existingBook == null){
            System.out.println("Book with ID " + id + " does not exist");
            return;
        }
        bookRepository.deleteBook(id);
        System.out.println("Book with ID " + id + " has been deleted");
    }
    @Override
    public void updateBook(Book book) {
        Book existing = bookRepository.getBookByID(book.getId());
        if(existing == null){
            System.out.println("Book not found");
            return;
        }
        existing.setTitle(book.getTitle());
        existing.setAuthor(book.getAuthor());
        existing.setCategory(book.getCategory());
        bookRepository.updateBook(existing);
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
            Member member = memberRepository.searchMembersById(memberId);
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
        System.out.println(memberRepository.getAllMembers());
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
       // System.out.println(memberRepository.getAllMembers());
    }
}
