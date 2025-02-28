package lk.ijse.z13springboot.service;

import lk.ijse.z13springboot.dto.ItemDTO;

import java.util.List;

public interface ItemService {
    public void addItem(ItemDTO itemDTO) ;
    public List<ItemDTO> getAllItems();
    public void updateItem(ItemDTO itemDTO);
    public void deleteItem(int id);
}
