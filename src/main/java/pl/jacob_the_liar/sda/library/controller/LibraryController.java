package pl.jacob_the_liar.sda.library.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.jacob_the_liar.sda.library.model.Book;
import pl.jacob_the_liar.sda.library.service.OrderService;

import java.util.Set;


/**
 * @author: Jakub O.  [https://github.com/JacobTheLiar]
 * @date : 2019-10-19 14:25
 * *
 * @className: LibraryController
 * *
 * *
 ******************************************************/
@Controller
public class LibraryController{

    private OrderService orderService;
    
    
    public LibraryController(OrderService orderService){
        this.orderService = orderService;
    }
    

    @GetMapping("/books")
    public ModelAndView listOfBooks(){
        ModelAndView modelAndView = new ModelAndView("books");
        Set<Book> books = orderService.allBooks();
        modelAndView.addObject("books", books);
        return modelAndView;
    }
    
    
}
