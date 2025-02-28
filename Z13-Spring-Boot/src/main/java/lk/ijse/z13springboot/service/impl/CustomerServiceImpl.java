package lk.ijse.z13springboot.service.impl;

import lk.ijse.z13springboot.dto.CustomerDTO;
import lk.ijse.z13springboot.entity.Customer;
import lk.ijse.z13springboot.repo.CustomerRepo;
import lk.ijse.z13springboot.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void addCustomer(CustomerDTO customerDTO) {
        if (customerRepo.existsById(customerDTO.getId())) {
            throw new RuntimeException("Customer already exists");
        }
        customerRepo.save(modelMapper.map(customerDTO, Customer.class));

//            customerRepo.save(
////                new Customer(
////                customerDTO.getId(),
////                customerDTO.getName(),
////                customerDTO.getAddress()
////        )
//                    modelMapper.map(customerDTO, Customer.class)


//            );
//        }
    }
    @Override
    public List<CustomerDTO> getAllCustomers() {
//        List<Customer> customers = customerRepo.findAll();
//        List<CustomerDTO> customerDTOs = new ArrayList<>();
//
//        for (Customer c : customers) {
//            customerDTOs.add(new CustomerDTO(c.getId(), c.getName(), c.getAddress()));
//        }
//        return customerDTOs;
        return modelMapper.map(customerRepo.findAll(),
                new TypeToken<List<CustomerDTO>>() {}.getType());
   }
   @Override
    public void updateCustomer(CustomerDTO customerDTO){

//        Customer customer = customerRepo.findById(
//                customerDTO.getId()).
//                orElse(null);
//        if (customer!=null){
//            customer.setName(customerDTO.getName());
//            customer.setAddress(customerDTO.getAddress());
//            customerRepo.save(customer);
//            return true;
//        }
//        return false;
        if (customerRepo.existsById(customerDTO.getId())){
            customerRepo.save(modelMapper.map(customerDTO, Customer.class));
        }
        throw new RuntimeException("Customer does not exist");
    }
    @Override
    public void deleteCustomer(int id){
       customerRepo.deleteById(id);
    }
}
