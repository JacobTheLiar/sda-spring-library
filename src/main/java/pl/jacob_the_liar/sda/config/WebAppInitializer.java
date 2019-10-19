package pl.jacob_the_liar.sda.config;


import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


/**
 * @author: Jakub O.  [https://github.com/JacobTheLiar]
 * @date : 2019-10-19 14:09
 * *
 * @className: WebAppInitializer
 * *
 * *
 ******************************************************/
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    
    @Override
    protected Class<?>[] getRootConfigClasses(){
        return new Class[]{AppConfig.class};
    }
    
    
    @Override
    protected Class<?>[] getServletConfigClasses(){
        return new Class[]{WebConfig.class};
    }
    
    
    @Override
    protected String[] getServletMappings(){
        return new String[]{"/"};
    }
}
