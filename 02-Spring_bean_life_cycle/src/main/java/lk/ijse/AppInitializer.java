package lk.ijse;

import lk.ijse.bean.MyConnection;
import lk.ijse.bean.TestBean1;
import lk.ijse.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppInitializer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();

//        TestBean1 testBean1 = context.getBean(TestBean1.class);
//        TestBean1 testBean2 = context.getBean(TestBean1.class);
//        System.out.println(testBean1);
//        System.out.println(testBean2);
//
//        MyConnection myConnection1 = context.getBean(MyConnection.class);
//        MyConnection myConnection2 = context.getBean(MyConnection.class);
//        System.out.println(myConnection1);
//        System.out.println(myConnection2);


        MyConnection myConnection = context.getBean(MyConnection.class);

        System.out.println(myConnection);

        context.registerShutdownHook();//me method eka comment karama destroy method eka call wun na

    }
}