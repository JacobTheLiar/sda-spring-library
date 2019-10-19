package pl.jacob_the_liar.sda.library.controller;


import org.springframework.stereotype.Controller;
import pl.jacob_the_liar.sda.library.service.OrderService;


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
    
    
    
}
