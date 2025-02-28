package lk.ijse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("wildcard")
public class WildCardMapping {
    @GetMapping(path = "test1/*/hello")
    public String test1(){
        return "Wild card get mapping1";
    }
    @GetMapping(path = "test2/*/*")
    public String test2(){
        return "Wild card get mapping2";
    }
}
