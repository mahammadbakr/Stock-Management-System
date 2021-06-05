package com.twekl.stockmanagementsystem.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    }
    @DeleteMapping(path = "{itemId}")
    public void addNewItem(@PathVariable("itemId") Long itemId){
        itemServices.deleteItemById(itemId);
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
    }

}
