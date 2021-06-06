package com.twekl.stockmanagementsystem.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/items")
public class ItemController {

    private final ItemServices itemServices;
    @Autowired
    public ItemController(ItemServices itemServices){
        this.itemServices=itemServices;
    }

    @GetMapping
    public List<Item> getItems(){
        return itemServices.getItems();
    }
    @PostMapping
    public void addNewItem(@RequestBody Item item){
        itemServices.addNewItem(item);
        throw new ResponseStatusException(
                HttpStatus.OK, "Item Added Successfully"
        );
    }
    @DeleteMapping(path = "/deleteItem/{itemId}")
    public void deleteItem(@PathVariable("itemId") Long itemId){
        itemServices.deleteItemById(itemId);
        throw new ResponseStatusException(
                HttpStatus.OK, "Item Deleted Successfully"
        );
    }
    @PutMapping(path = "/updateItem/{itemId}")
    public void updateItem(
            @PathVariable("itemId") Long itemId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String code,
            @RequestParam(required = false) int price,
            @RequestParam(required = false) int quantity
    ){
      itemServices.updateItem(itemId,name,code,price,quantity);
        throw new ResponseStatusException(
                HttpStatus.OK, "Item Updated Successfully"
        );
    }


}
