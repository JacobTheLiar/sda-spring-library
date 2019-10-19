package pl.jacob_the_liar.sda.library.repository;


import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pl.jacob_the_liar.sda.library.model.Book;

import static org.junit.Assert.*;


/**
 * @author: Jakub O.  [https://github.com/JacobTheLiar]
 * @date : 2019-10-13 12:15
 * *
 * @className: BookRepositoryTest
 * *
 * *
 ******************************************************/
public class BookRepositoryTest{
    
    //    @Autowired
    private BookRepository books;
    
    
    @Before
    public void setUp() throws Exception{
        books = new BookRepository();
    }
    
    
    @Test
    public void shouldHave11booksInLibraryAfterAddingBook(){
        
        Book book = new Book("aaa", "bbb");
        
        books.addNewBook(book);
        
    }
}