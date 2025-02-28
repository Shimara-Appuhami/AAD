package lk.ijse.z13springboot.controller;

import lk.ijse.z13springboot.dto.OrderDTO;
import lk.ijse.z13springboot.service.PlaceOrderService;
import lk.ijse.z13springboot.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/order")
@CrossOrigin
public class PlaceOrderController {

    @Autowired
    private PlaceOrderService placeOrderService;

    @PostMapping("place")
    public ResponseUtil saveOrder(@RequestBody OrderDTO ordersDTO) {
        boolean res = placeOrderService.addOrder(ordersDTO);
        if(res){
            return new ResponseUtil(201," Saved",null);
        }else {
            return new ResponseUtil(200,"",null);
}
}
}
