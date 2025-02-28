package lk.ijse.z13springboot.controller;

import lk.ijse.z13springboot.dto.CustomerDTO;
import lk.ijse.z13springboot.service.impl.CustomerServiceImpl;
import lk.ijse.z13springboot.util.ResponseUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin(origins = "http://localhost:63342")
public class CustomerController {
    @Autowired
    private CustomerServiceImpl customerService;


    @PostMapping(value = "save",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveCustomer(@RequestBody CustomerDTO customerDTO){
       customerService.addCustomer(customerDTO);
       return new ResponseUtil(201, "Customer Saved", null);

    }
    @GetMapping("getAll")
    public List<CustomerDTO> getAllCustomers() {
        customerService.getAllCustomers();
        return customerService.getAllCustomers();
    }
    @PutMapping(value = "update",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateCustomer(@RequestBody CustomerDTO customerDTO){
        customerService.updateCustomer(customerDTO);
        return new ResponseUtil(200, "Customer Updated", null);
    }
    @DeleteMapping("delete/{id}")
    public ResponseUtil deleteCustomer(@PathVariable("id") String id){
        customerService.deleteCustomer(Integer.parseInt(id));
        return new ResponseUtil(200, "Customer deleted", null);
    }
}
