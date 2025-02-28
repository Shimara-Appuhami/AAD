package lk.ijse;

import lk.ijse.bean.*;
import lk.ijse.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppInitializer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();

//        Object bean = context.getBean("springBean");
//        System.out.println(bean);
//
////        SpringBean springBean=context.getBean(SpringBean.class);
////        springBean.SayHello();
//
//
////        SpringBean  bean = context.getBean(SpringBean.class);;
////        System.out.println(bean);
//        TestBean1 testBean1=context.getBean(TestBean1.class);
//        System.out.println(testBean1);
//        TestBean2 testBean2=context.getBean(TestBean2.class);
//        System.out.println(testBean2);
//
//        MyConection conection=context.getBean(MyConection.class);
//        System.out.println(conection);
//
//
////        Runtime.getRuntime().addShutdownHook(new Thread(){
////            public void run() {
////                System.out.println("shut down");
////                context.close();
////            };
////        });
//        //or
//        context.registerShutdownHook();
//        TestBean3 testBean3=context.getBean(TestBean3.class);
//        System.out.println(testBean3);


//        TestBean1 ref1=context.getBean(TestBean1.class);
//        System.out.println(ref1);
//        TestBean1 ref2=context.getBean(TestBean1.class);
//        System.out.println(ref2);
//        MyConection ref3=context.getBean(MyConection.class);

        context.close();
    }
}
