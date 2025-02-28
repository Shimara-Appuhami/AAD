package lk.ijse.bean;

import org.springframework.stereotype.Component;

@Component  //adura gannwa bean ekak kiyala
public class SpringBean {
    public SpringBean() {
        System.out.println("SpringBean constructor");
    }

    public void SayHello(){
        System.out.println("Spring say hello");
    }



}
