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

import java.util.List;
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
            System.out.println("5. Update Book");
            System.out.println("6. Delete Book");
            System.out.println("7. View Books");
            System.out.println("8. Search Book");
            System.out.println("9. View Members");
            System.out.println("10.  Update Member");
            System.out.println("11. Delete Member");
            System.out.println("12. Search Member");
            System.out.println("13. Exit");


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
                    updateBooks(sc,bookService);
                    break;
                case 6:
                    deleteBooks(sc,bookService);
                    break;
                case 7:
                    viewBooks(sc,bookService);
                    break;
                case 8:
                    searchBook(sc,bookService);
                    break;
                case 9:
                    viewMembers(sc,memberService);
                    break;
                case 10:
                    updateMember(sc,memberService);
                    break;
                case 11:
                    deleteMember(sc,memberService);
                    break;
                case 12:
                    searchMember(sc,memberService);
                    break;
                case 13:
                    System.out.println("Exit");
                    running = false;
                    break;
               default:
                   System.out.println("Invalid choice");
            }
        }
    }

    private static void searchMember(Scanner sc, MemberService memberService) {
        System.out.println("Enter Member ID: ");
        int id = sc.nextInt();
        Member member = memberService.searchMemberByID(id);
        System.out.println(member);
    }

    private static void deleteMember(Scanner sc, MemberService memberService) {
        System.out.println("Please enter the ID of the Member you want to delete: ");
        int id = sc.nextInt();
        memberService.deleteMember(id);
    }

    private static void updateMember(Scanner sc, MemberService memberService) {
        System.out.println("Enter Member ID: ");
        int memberid = sc.nextInt();
        System.out.println("Enter New Member Name: ");
        sc.nextLine();
        String membername = sc.next();
        System.out.println("Enter member email: ");
        String memberemail = sc.next();
        System.out.println("Enter member phone number: ");
        String memberphonenum = sc.next();
        Member mb = new Member(memberid,membername,memberemail,memberphonenum);
        memberService.updateMember(mb);
    }


    private static void deleteBooks(Scanner sc, BookService02 bookService) {
        System.out.println("Enter Book ID");
        int bookId = sc.nextInt();
        bookService.deleteBook(bookId);
    }

    private static void updateBooks(Scanner sc,BookService02 bookService) {
        System.out.println("Enter Book ID: ");
        int bookId = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter New Title:: ");
        String title = sc.nextLine();
        System.out.println("Enter Author: ");
        String author = sc.nextLine();
        System.out.println("Enter Category: ");
        String category = sc.nextLine();
        System.out.println("Book issuedId: ");
        Book bk = new Book(bookId,title,author,category,null);
        bookService.updateBook(bk);
    }

    private static void searchBook(Scanner sc, BookService02 bookService) {
        sc.nextLine();
        System.out.println("Enter Book Title");
        String title = sc.nextLine();
        bookService.searchBooksByTitle(title).forEach(System.out::println);
    }

    private static void viewMembers(Scanner sc, MemberService memberService) {
        List<Member> members = memberService.getAllMembers();
        if(members.isEmpty()){
            System.out.println("No members found");
            System.out.println("1.Add Member");
            System.out.println("2.Back");
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    addMemberFlow(sc,memberService);
                    break;
                case 2:
                    break;
                default:
                    System.out.println("Invalid choice");
            }
            return;
        }
        System.out.println("=====Members======");
       members.forEach(System.out::println);
    }


    private static void viewBooks(Scanner sc, BookService02 bookService) {
        List<Book> book = bookService.getAllBooks();
        if(book.isEmpty()){
            System.out.println("No Books found");
            System.out.println("1.Add Book");
            System.out.println("2.Back");
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    addBookFlow(sc,bookService);
                    break;
                case 2:
                    break;
                default:
                    System.out.println("Invalid choice");
            }
            return;
        }
        System.out.println("=====Books======");
        book.forEach(System.out::println);
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
        while(bookID<=0) {
            System.out.println("Invalid Book ID,must be greater than zero");
            System.out.println("Enter Book ID: ");
            bookID = sc.nextInt();
        }
        sc.nextLine();
        System.out.println("Enter Book Title: ");
        String title = sc.nextLine();
        while(title.trim().isEmpty()){
            System.out.println("Title is empty");
            System.out.println("Enter Book Title: ");
            title = sc.nextLine();
        }
        System.out.println("Enter Book Author: ");
        String author = sc.nextLine();
        while(author.trim().isEmpty()){
            System.out.println("Author is empty");
            System.out.println("Enter Book Author: ");
            author = sc.nextLine();
        }
        System.out.println("Enter Category: ");
        String category = sc.nextLine();
        while(category.trim().isEmpty()){
            System.out.println("Category is empty");
            System.out.println("Enter Book Category: ");
            category = sc.nextLine();
        }
        Book book = new Book(bookID,title,author,category,null);
        bookService02.addBook(book);
        System.out.println("Book added successfully");
    }
}
