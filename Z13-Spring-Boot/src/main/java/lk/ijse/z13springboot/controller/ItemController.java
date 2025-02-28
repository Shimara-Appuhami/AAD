package lk.ijse.z13springboot.controller;


import lk.ijse.z13springboot.dto.ItemDTO;
import lk.ijse.z13springboot.service.impl.ItemServiceImpl;
import lk.ijse.z13springboot.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin(origins = "http://localhost:63342")

public class ItemController {

    @Autowired
    private ItemServiceImpl itemService;

    @PostMapping("save")
    public ResponseUtil saveItem(@RequestBody ItemDTO itemDTO){
        itemService.addItem(itemDTO);
        return new ResponseUtil(201, "Item saved successfully",null);
    }
    @GetMapping("getAll")
    public List<ItemDTO> getAllItems(){
      itemService.getAllItems();
      return itemService.getAllItems();
    }
    @PutMapping("update")
    public ResponseUtil updateItem(@RequestBody ItemDTO itemDTO){
        itemService.updateItem(itemDTO);
        return new ResponseUtil(200, "Item updated successfully",null);
    }
    @DeleteMapping("delete/{id}")
    public ResponseUtil deleteItem(@PathVariable("id") String id){
         itemService.deleteItem(Integer.parseInt(id));
         return new ResponseUtil(200, "Item deleted successfully",null);
    }
}