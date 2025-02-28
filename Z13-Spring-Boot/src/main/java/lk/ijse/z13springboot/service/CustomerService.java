package lk.ijse.z13springboot.service;

import lk.ijse.z13springboot.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    public void addCustomer(CustomerDTO customerDTO);
    public List<CustomerDTO> getAllCustomers() ;
    public void updateCustomer(CustomerDTO customerDTO);
    public void deleteCustomer(int id);
}
