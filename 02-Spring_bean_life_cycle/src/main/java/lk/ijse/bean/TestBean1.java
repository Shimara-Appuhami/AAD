package lk.ijse.bean;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component //api hadana class walata witharai use karanne
public class TestBean1 {
    public TestBean1() {
        System.out.println("TestBean1 constructor");
    }
}
