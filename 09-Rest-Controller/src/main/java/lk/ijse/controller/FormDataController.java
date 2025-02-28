package lk.ijse.controller;

import lk.ijse.dto.CustomerDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("form")
public class FormDataController {
    //id-1
    //name-shim
    //address-panadura
    //params wadi wena eka karadara nisa DTO ekak hada gannwa
//    @PostMapping
//    public String test1(@RequestParam("id") String id,@RequestParam("name") String name){
//        return "id=" + id+" name=" + name;
//
//    }
    @PostMapping(path = "test2")
    public String test2( CustomerDTO customerDTO){
        return customerDTO.toString();

    }
}
