package lk.ijse.z13springboot.repo;

import lk.ijse.z13springboot.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ItemRepo extends JpaRepository<Item,Integer>{
    @Modifying
    @Query("UPDATE Item i SET i.qty = i.qty - :quantity WHERE i.id = :itemId")
    void updateQTY(@Param("itemId") String itemId, @Param("quantity") double quantity);
}