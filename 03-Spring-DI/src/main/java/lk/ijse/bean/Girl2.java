package lk.ijse.bean;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary //girl class 2n meka run karann me class eka use karala kiyala
public class Girl2 implements Aggrement{

    @Override
    public void chat() {
        System.out.println("Girl2 chat");
    }
}
