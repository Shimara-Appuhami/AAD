package lk.ijse.z13springboot.dto;


import java.util.List;

public class OrderDTO {
    private int orderId;
    private String customerId;
    private double total;
    private List<OrderDetailDTO> orderDetails;


    public OrderDTO() {
    }

    public OrderDTO(int orderId, String customerId, double total, List<OrderDetailDTO> orderDetails) {
        this.orderId = orderId;
        this.total = total;
        this.orderDetails = orderDetails;
    }

    public int getOrderId() {
        return orderId;
    }

    public List<OrderDetailDTO> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetailDTO> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }


    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
