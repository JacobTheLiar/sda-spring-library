package pl.jacob_the_liar.sda;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.jacob_the_liar.sda.library.Menu;


/**
 * Hello world!
 */
public class App{
    
    public static void main(String[] args){
        System.out.println("Hello World!");
        
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        
        Menu menu = context.getBean(Menu.class);
        
        while (menu.programLoop()) {
        }
    }
}
