import model.Book;
import model.Member;
import repository.BookRepository;
import repository.MemberRepository;
import repository.impl.BookRepositoryImpl;
import repository.impl.MemberRepositoryImpl;
import service.BookService02;
import service.MemberService;
import service.impl.BookServiceImpl;
import service.impl.MemberServiceImpl;

import java.util.Scanner;

public class Main {
    static void main() {
        BookRepository bookRepository = new BookRepositoryImpl();
        MemberRepository memberRepository = new MemberRepositoryImpl();
        BookService02 bookService = new BookServiceImpl(bookRepository,memberRepository);
        MemberService memberService = new MemberServiceImpl(memberRepository);
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        while(running){
            System.out.println("=================================");
            System.out.println("Library Management\n");
            System.out.println("=================================");
            System.out.println("1. Add Book");
            System.out.println("2. Add Member");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. View Books");
            System.out.println("6. View Members");
            System.out.println("7. Search Book");
            System.out.println("8. Exit");


            System.out.println("Enter your choice");
            int choice = sc.nextInt();
            switch(choice){
               case 1:
                   addBookFlow(sc, bookService);
                   break;
               case 2:
                   addMemberFlow(sc,memberService);
                   break;
                case 3:
                    issueBook(sc,bookService);
                    break;
                case 4:
                    returnBook(sc,bookService);
                    break;
                case 5:
                    viewBooks(sc,bookService);
                    break;
                case 6:
                    viewMembers(sc,memberService);
                    break;
                case 7:
                    searchBook(sc,bookService);
                    break;
                case 8:
                    System.out.println("Exit");
                    running = false;
                    break;
               default:
                   System.out.println("Invalid choice");
            }
        }
    }

    private static void searchBook(Scanner sc, BookService02 bookService) {
        sc.nextLine();
        System.out.println("Enter Book Title");
        String title = sc.nextLine();
        bookService.searchBooksByTitle(title).forEach(System.out::println);
    }

    private static void viewMembers(Scanner sc, MemberService memberService) {
        System.out.println("All Members");
        memberService.getAllMembers().forEach(System.out::println);
    }


    private static void viewBooks(Scanner sc, BookService02 bookService) {
        System.out.println("All Books");
        bookService.getAllBooks().forEach(System.out::println);
    }

    private static void returnBook(Scanner sc, BookService02 bookService) {
        System.out.println("Enter Book ID");
        int bookId = sc.nextInt();
        bookService.returnBook(bookId);
    }

    private static void issueBook(Scanner sc, BookService02 bs) {
        System.out.println("Enter Book ID");
        int bookid = sc.nextInt();
        System.out.println("Enter Member ID");
        int  memberId = sc.nextInt();
        bs.issueBook(bookid,memberId);
    }

    private static void addMemberFlow(Scanner sc, MemberService ms) {
        System.out.println("\n==== Add Members ====");
        System.out.println("Enter Member ID");
        int memberID = sc.nextInt();
        System.out.println("Enter Member Name");
        String memberName = sc.next();
        System.out.println("Enter Email");
        String memberEmail = sc.next();
        System.out.println("Enter Phone Number");
        String memberPhone = sc.next();
        Member member = new Member(memberID,memberName,memberEmail,memberPhone);
        ms.addMember(member);
    }

    private static void addBookFlow(Scanner sc,BookService02 bookService02) {
        System.out.println("\n===== Add Book =====");
        System.out.println("Enter Book ID: ");
        int bookID = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Book Title: ");
        String title = sc.nextLine();
        System.out.println("Enter Book Author: ");
        String author = sc.nextLine();
        System.out.println("Enter Category: ");
        String category = sc.nextLine();

        Book book = new Book(bookID,title,author,category,null);
        bookService02.addBook(book);
        System.out.println("Book added successfully");
    }
}
