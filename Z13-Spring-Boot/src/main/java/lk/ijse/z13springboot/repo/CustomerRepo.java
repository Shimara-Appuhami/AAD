package lk.ijse.z13springboot.repo;

import lk.ijse.z13springboot.entity.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<Customer ,Integer>{
    //query methods
//    List<Customer>findByAddress(String address);
//    List<Customer> readCustomerByAddress(String name);
//    List<Customer>getCustomerByName(String name);
//    long countCustomerById(int id);
//
//    //native queries
//    @Query(value = "SELECT * FROM customer", nativeQuery = true)
//    List<Customer> getAllCustomers();
//
//    @Query(value = "SELECT * FROM customer where name=?", nativeQuery = true)
//    Customer searchcustomerbyname(String name);
}
