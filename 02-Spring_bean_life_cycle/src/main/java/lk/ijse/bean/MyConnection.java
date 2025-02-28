package lk.ijse.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MyConnection implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean,DisposableBean {
    public MyConnection() {
        System.out.println("MyConnection constructor");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("MyConnection setBeanFactory()");

    }

    @Override
    public void setBeanName(String name) {
        System.out.println("MyConnection setBeanName()  " );

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        System.out.println("MyConnection setApplicationContext()  ");
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        System.out.println("MyConnection afterPropertiesSet() ");
    }

    @Override
    public void destroy() throws Exception {

        System.out.println("MyConnection destroy() ");
    }
}
