package pl.jacob_the_liar.sda.library.repository;


import org.springframework.stereotype.Repository;
import pl.jacob_the_liar.sda.library.model.Book;

import java.time.LocalDate;
import java.util.*;


/**
 * @author: Jakub O.  [https://github.com/JacobTheLiar]
 * @date : 2019-10-13 11:22
 * *
 * @className: BookRepository
 * *
 * *
 ******************************************************/

@Repository
public class BookRepository{
    
    private Set<Book> bookList = new HashSet<>();
    
    
    public BookRepository(){
        
        bookList.add(new Book("Roger Zelazn", "LORD OF LIGHT"));
        bookList.add(new Book("Anthony Horowitz", "EAGLE STRIKE"));
        bookList.add(new Book("John Searles", "HELP FOR THE HAUNTED"));
        bookList.add(new Book("Mary Higgins Clark", "LET ME CALL YOU SWEETHEART"));
        bookList.add(new Book("Barbara Claypole White", "THE PERFECT SON"));
        bookList.add(new Book("Elisabeth Naughton", "WAIT FOR ME"));
        bookList.add(new Book("Elizabeth Strout", "AMY & ISABELLE"));
        bookList.add(new Book("Michael Connelly", "TRUNK MUSIC"));
        bookList.add(new Book("Donald Crews", "FREIGHT TRAIN (CALDECOTT COLLECTION)"));
        bookList.add(new Book("Christiane F., Kai Hermann, Horst Rieck", "WIR KINDER VOM BAHNHOF ZOO"));
    }
    
    
    public Book addNewBook(Book book){
        bookList.add(book);
        return book;
    }
    
    
    public Optional<Book> borrowBook(String title, LocalDate borrowerTill){
        
        Optional<Book> optBook = bookList.stream()
                .filter(book -> book.getTitle().toUpperCase().contains(title.toUpperCase()))
                .filter(book -> book.getRentedTill() == null)
                .findAny();
        optBook.ifPresent(book -> book.setRentedTill(borrowerTill));
        
        return optBook;
    }
    
    
    public void removeBook(int bookId){
        Book b = bookList.stream()
                .filter(book -> book.getId() == bookId)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Book not found"));
        
        bookList.remove(b);
    }
    
    
    public void deliveryBook(int bookId){
        bookList.stream()
                .filter(book -> book.getId() == bookId)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Book not found"))
                .setRentedTill(null);
    }
    
    
    public Set<Book> allBooks(){
        return bookList;
    }
    
    private int getBooksCount(){
        return bookList.size();
    }
    
    
}
