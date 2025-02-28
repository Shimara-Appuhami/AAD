package lk.ijse.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Boy {
//    @Qualifier("girl1") //dekema primary dala thibboth mehema karanna
    @Autowired //object satisfiyng kara gannawa(deparak print wun na constructor eka)
    Aggrement girl;
    Boy(){
        System.out.println("Boy constructor");
    }
    public void chatWithGirl(){
        girl.chat();
    }
}
