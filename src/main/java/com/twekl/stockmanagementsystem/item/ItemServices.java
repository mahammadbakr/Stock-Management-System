package com.twekl.stockmanagementsystem.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class ItemServices {
    private final ItemRepository itemRepository;

    @Autowired
    public ItemServices(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> getItems(){
        return itemRepository.findAll();
    }

    public void addNewItem(Item item) {
        Optional<Item> optionalItem= itemRepository.findItemByName(item.getName());
        if(optionalItem.isPresent()){
            throw new IllegalStateException("Name Already Taken");
        }
        itemRepository.save(item);
    }

    public void deleteItemById(Long itemId) {
        boolean exists = itemRepository.existsById(itemId);
        if(!exists){
            throw new IllegalStateException("Item with id: "+itemId+" does not exist");
        }
        itemRepository.deleteById(itemId);
    }
    @Transactional
    public void updateItem(Long itemId, String name, String code, int price, int quantity) {
        Item item = itemRepository.findById(itemId).orElseThrow(
                ()-> new IllegalStateException("Item with id: "+itemId+" does not exist"));
        if(name!=null && name.length() >0 && !Objects.equals(item.getName(),name)){
            item.setName(name);
        }
        if(code!=null && code.length() >0 && !Objects.equals(item.getCode(),code)){
            item.setCode(code);
        }
        if( !Objects.equals(item.getPrice(),price)){
            item.setCode(code);
        }
        if( !Objects.equals(item.getQuantity(),quantity)){
            item.setQuantity(quantity);
        }

        itemRepository.save(item);
    }
}
