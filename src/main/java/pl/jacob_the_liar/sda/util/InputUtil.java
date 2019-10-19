package pl.jacob_the_liar.sda.util;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * @author: Jakub O.  [https://github.com/JacobTheLiar]
 * @date : 2019-10-13 14:51
 * *
 * @className: InputUtil
 * *
 * *
 ******************************************************/
public class InputUtil{
    
    public static int getInteger(){
        
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        try {
            
            while (true) {
                try {
                    String input = bufferedReader.readLine();
                    int choice = Integer.decode(input);
                    return choice;
                } catch (NumberFormatException ne) {
                    System.out.println("this is not a number, try again");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
    
    
    public static String getStringLine(){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String input = bufferedReader.readLine();
            return input;
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
