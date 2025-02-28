package lk.ijse.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Boy implements DI{
//    @Autowired
    Agreement girl;

    //constructor injection
//    @Autowired
//    Boy(Agreement girl){
//        this.girl=girl;
//
//    }

    //setter method injection
//    @Autowired
//    public void setter(Agreement girl) {
//        this.girl = girl;
//    }
    public void chatWithGirl(){
        girl.chat();
    }

    @Autowired
    @Override
    public void inject(Agreement agreement) {
        this.girl=agreement;
    }
}
