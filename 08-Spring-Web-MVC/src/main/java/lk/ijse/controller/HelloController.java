package lk.ijse.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@Controller
@RequestMapping("hello")
public class HelloController {

    public HelloController() {
        System.out.println("HelloController instantiated");
    }
    @GetMapping
    public String sayHello(){
        return "index";
    }

//    @GetMapping("test2")
//    public String test(){
//    return "Hello test!";
//    }
}
