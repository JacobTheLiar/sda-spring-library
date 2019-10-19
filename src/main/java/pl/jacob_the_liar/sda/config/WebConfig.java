package pl.jacob_the_liar.sda.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


/**
 * @author: Jakub O.  [https://github.com/JacobTheLiar]
 * @date : 2019-10-19 14:11
 * *
 * @className: WebConfig
 * *
 * *
 ******************************************************/
@EnableWebMvc
@Configuration
@ComponentScan("pl.jacob_the_liar.sda.library.controller")
public class WebConfig{
    
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/pages/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
    
}
