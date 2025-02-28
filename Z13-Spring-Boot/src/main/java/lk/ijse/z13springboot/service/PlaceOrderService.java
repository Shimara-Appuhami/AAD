package lk.ijse.z13springboot.service;

import lk.ijse.z13springboot.dto.OrderDTO;

public interface PlaceOrderService {
    public boolean addOrder(OrderDTO ordersDTO);
}
