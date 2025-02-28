package lk.ijse.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpringBean implements InitializingBean {

    @Value("vagi")
    private String name;
    public SpringBean() {
        System.out.println("Spring Bean Constructor");
        System.out.println("name : "+name);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("name : "+name);

    }
//    public SpringBean() {}
//    @Autowired(required=false)
//    public SpringBean(@Value("vagii")String name,@Value("1") int id,@Value("vagi@gmail.com")String email,@Value("true")boolean enabled) {
//        System.out.println("Spring Bean Constructor");
//        System.out.println("id : "+name);
//        System.out.println(id);
//        System.out.println(email);
//        System.out.println(enabled);
//    }
//    @Autowired(required = false)//meka inject kara gann kiyala kiyanna puluwan
//    public SpringBean(@Value("vagii")String name,@Value("1") int id,@Value("vagi@gmail.com")String email) {
//        System.out.println("Spring Bean Constructor");
//        System.out.println("id : "+name);
//        System.out.println(id);
//        System.out.println(email);
//    }

}