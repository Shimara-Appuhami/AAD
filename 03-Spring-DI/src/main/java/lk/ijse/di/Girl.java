package lk.ijse.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Girl implements Agreement{
    @Autowired
    Agreement girl;
    @Override
    public void chat() {
        System.out.println("Girl chat");
    }
}
