package lk.ijse.config;


import lk.ijse.bean.MyConnection;
import lk.ijse.bean.TestBean1;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = {"lk.ijse.bean"})
public class AppConfig implements BeanNameAware {
    @Bean
    @Scope()
    public MyConnection getMyConnection() {
        return new MyConnection();
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("myConnection setBeanAware setBeanName: ");
    }

}
