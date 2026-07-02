package repository.impl;
import model.Book;
import repository.BookRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class BookRepositoryImpl implements BookRepository {
    private Map<Integer,Book> books = new HashMap<Integer,Book>();
    @Override
    public void addBook(Book book) {
        books.put(book.getId(),book);
    }

    @Override
    public void deleteBook(int id) {
        if(books.containsKey(id)){
            books.remove(id);
        }
    }

    @Override
    public void updateBook(Book book) {
       if(books.containsKey(book.getId()))
       {
           books.put(book.getId(),book);
       }

    }

    @Override
    public List<Book> getAllBooks() {
        //new ArrayList<>(map.values()) → us collection ko List mein convert karta hai.
        return new ArrayList<>(books.values());
    }

    @Override
    public Book getBookByID(int id) {
        return  books.get(id);
    }

    @Override
    public List<Book> searchBooksByTitle(String title) {
        /*we are using a list here coz many books can have same titles
        so we are just returning the book list of those titles
         */

        List<Book> bookList = new ArrayList<>();
        for(Book book:books.values()){
            /*
            Whenever you compare strings like titles,
            names, authors, emails, etc., you almost always want equals().
             */
            if(title.equals(book.getTitle()))
            {
                bookList.add(book);
            }
        }
        return bookList;
    }

    @Override
    public List<Book> searchBooksByAuthor(String author) {
        List<Book> bookList = new ArrayList<>();
        for(Book book:books.values())
        {
            if(author.equals(book.getAuthor()))
            {
                bookList.add(book);
            }
        }
        return bookList;
    }


}
