package lk.ijse.config;

import lk.ijse.bean.MyConection;
import lk.ijse.bean.TestBean1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Configuration
//@ComponentScan(basePackages = "lk.ijse.bean")
//@ComponentScan(basePackageClasses = TestBean1.class)


public class AppConfig {
//    public AppConfig(){
//        System.out.println("App config constructor");
//    }
    @Scope
    @Bean
    public MyConection myConection(){
        return new MyConection();
    }
}
