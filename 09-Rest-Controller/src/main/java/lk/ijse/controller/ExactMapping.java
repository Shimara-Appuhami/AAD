package lk.ijse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("exact")
public class ExactMapping {
    @GetMapping(path = "test1")
    public String test1(){
        return "Exact Mapping test1";
    }
    @GetMapping(path = "test2")
    public String test2(){
        return "Exact Mapping test2";
    }

}
