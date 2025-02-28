package lk.ijse.z13springboot.service.impl;

import lk.ijse.z13springboot.dto.CustomerDTO;
import lk.ijse.z13springboot.dto.ItemDTO;
import lk.ijse.z13springboot.entity.Item;
import lk.ijse.z13springboot.repo.ItemRepo;

import lk.ijse.z13springboot.service.ItemService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepo itemRepo;
    @Autowired
    private ModelMapper modelMapper;

    public void addItem(ItemDTO itemDTO) {
//        Item item = new Item(itemDTO.getId(),itemDTO.getName(),itemDTO.getQty(),itemDTO.getPrice());
//        itemRepo.save(item);
//        return true;
        if (itemRepo.existsById(itemDTO.getId())){
            throw new RuntimeException("Item already exists");
        }else {
            itemRepo.save(modelMapper.map(itemDTO,Item.class));
        }


    }

    public List<ItemDTO> getAllItems() {
//        List<Item> items = itemRepo.findAll();
//        List<ItemDTO> itemDTOs = new ArrayList<>();
//        for (Item item : items) {
//            itemDTOs.add(new ItemDTO(item.getId(),item.getName(),item.getQty(),item.getPrice()));
//        }
//        return itemDTOs;
        return modelMapper.map(itemRepo.findAll(),
                new TypeToken<List<ItemDTO>>() {}.getType());

    }

    public void updateItem(ItemDTO itemDTO) {
//        if (itemRepo.existsById(itemDTO.getId())) {
//            Item item = new Item(itemDTO.getId(),itemDTO.getName(),itemDTO.getQty(),itemDTO.getPrice());
//            itemRepo.save(item);
//            return true;
//        }
//        return false;
        if (itemRepo.existsById(itemDTO.getId())) {
            itemRepo.save(modelMapper.map(itemDTO,Item.class));
        }
        throw new RuntimeException("Could not find item");

    }
    public void deleteItem(int id){
       itemRepo.deleteById(id);
    }
}