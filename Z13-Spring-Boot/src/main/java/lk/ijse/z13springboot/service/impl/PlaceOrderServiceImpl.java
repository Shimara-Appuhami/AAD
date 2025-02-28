package lk.ijse.z13springboot.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.z13springboot.dto.OrderDTO;
import lk.ijse.z13springboot.dto.OrderDetailDTO;
import lk.ijse.z13springboot.entity.Customer;
import lk.ijse.z13springboot.entity.Item;
import lk.ijse.z13springboot.entity.OrderDetail;
import lk.ijse.z13springboot.entity.Orders;
import lk.ijse.z13springboot.repo.CustomerRepo;
import lk.ijse.z13springboot.repo.ItemRepo;
import lk.ijse.z13springboot.repo.OrderDetailRepo;
import lk.ijse.z13springboot.repo.OrderRepo;
import lk.ijse.z13springboot.service.PlaceOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PlaceOrderServiceImpl implements PlaceOrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private OrderDetailRepo orderDetailRepo;

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Transactional
    public boolean addOrder(OrderDTO ordersDTO) {
        try {
            Customer customer = customerRepo.findById(Integer.valueOf(ordersDTO.getCustomerId()))
                    .orElseThrow(() -> new RuntimeException("Customer not found"));

            Orders order = new Orders();
            order.setTotal(ordersDTO.getTotal());
            order.setCustomer(customer);

            Orders savedOrder = orderRepo.save(order);

            for (OrderDetailDTO orderDetailDTO : ordersDTO.getOrderDetails()) {
                Item item = itemRepo.findById(orderDetailDTO.getItemId())
                        .orElseThrow(() -> new RuntimeException("Item not found"));

                OrderDetail orderDetails = new OrderDetail();
                orderDetails.setQuantity(orderDetailDTO.getQuantity());
                orderDetails.setTotal(orderDetailDTO.getTotal());
                orderDetails.setItem(item);  // Set the item from the itemId
                orderDetails.setOrder(savedOrder);

                orderDetailRepo.save(orderDetails);
            }

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
