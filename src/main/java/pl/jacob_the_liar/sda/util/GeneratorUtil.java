package pl.jacob_the_liar.sda.util;


/**
 * @author: Jakub O.  [https://github.com/JacobTheLiar]
 * @date : 2019-10-13 11:35
 * *
 * @className: GeneratorUtil
 * *
 * *
 ******************************************************/
public class GeneratorUtil{
    
    private static int genId = 0;
    
    
    public static int getNewId(){
        return genId++;
    }
    
    
}
