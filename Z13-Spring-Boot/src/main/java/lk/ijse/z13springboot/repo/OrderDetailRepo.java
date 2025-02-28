package lk.ijse.z13springboot.repo;

import lk.ijse.z13springboot.entity.OrderDetail;
import lk.ijse.z13springboot.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepo extends JpaRepository<OrderDetail,Integer> {
}
