package pl.jacob_the_liar.sda.library;


import org.springframework.stereotype.Component;
import pl.jacob_the_liar.sda.library.model.Book;
import pl.jacob_the_liar.sda.library.service.OrderService;

import java.util.Optional;

import static pl.jacob_the_liar.sda.util.InputUtil.getInteger;
import static pl.jacob_the_liar.sda.util.InputUtil.getStringLine;


/**
 * @author: Jakub O.  [https://github.com/JacobTheLiar]
 * @date : 2019-10-13 13:53
 * *
 * @className: Menu
 * *
 * *
 ******************************************************/

@Component
public class Menu{
    
    private final OrderService orderService;
    private       boolean      loop;
    
    
    public Menu(OrderService orderService){
        this.orderService = orderService;
        this.loop = true;
    }
    
    
    public boolean programLoop(){
        
        System.out.println("\n\n");
        System.out.print(getMenuView());
        
        int choice = getChoice();
        
        switch (choice) {
            case 0:
                exit();
                break;
            case 1:
                addBook();
                break;
            case 2:
                borrowBook();
                break;
            case 3:
                returnBook();
                break;
            case 4:
                listBooks();
                break;
            case 8:
                deleteBook();
                break;
            
            default:
                System.out.println("invalid choice!");
        }
        
        return loop;
    }
    
    
    private void listBooks(){
        System.out.println("list of books");
        System.out.println();
        
        orderService.allBooks().forEach(book -> showBookItem(book));
    }
    
    
    private void showBookItem(Book book){
        System.out.println(String.format("%3d. %50s - %-50s - [%tF]", book.getId(), book.getTitle(), book.getAuthor(),
                                         book.getRentedTill()));
    }
    
    
    private void deleteBook(){
        System.out.println("delete book");
        System.out.print("id: ");
        
        int id = getInteger();
        
        orderService.removeBook(id);
    }
    
    
    private void returnBook(){
        System.out.println("return book");
        System.out.print("id: ");
        
        int id = getInteger();
        
        orderService.returnBook(id);
    }
    
    
    private void borrowBook(){
        System.out.println("borrow book");
        System.out.print("title: ");
        
        String title = getStringLine();
        
        Optional<Book> bookOptional = orderService.borrowBook(title);
        
        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();
            System.out.println("borrowed book:");
            System.out.println("id: " + book.getId());
            System.out.println("title: " + book.getTitle());
            System.out.println("author: " + book.getAuthor());
            System.out.println("till: " + book.getRentedTill());
        } else {
            System.out.println("unknown book");
        }
    }
    
    
    private void addBook(){
        System.out.println("adding book");
        System.out.print("title: ");
        String title = getStringLine();
        
        System.out.print("author: ");
        String author = getStringLine();
        
        Book book = orderService.addBook(author, title);
        
        System.out.println("added @ id = " + book.getId());
    }
    
    
    private void exit(){
        System.out.println("exiting from application");
        loop = false;
    }
    
    
    private int getChoice(){
        return getInteger();
    }
    
    
    private String getMenuView(){
        StringBuilder stringBuilder = new StringBuilder();
        
        stringBuilder.append("library menu:\n")
                .append("\t0 - exit\n")
                .append("\t1 - add book\n")
                .append("\t2 - borrow book\n")
                .append("\t3 - return book\n")
                .append("\t4 - book list\n")
                .append("\t8 - delete book\n")
                .append("\n")
                .append("your choice: ");
        
        return stringBuilder.toString();
    }
}
