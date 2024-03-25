package com.RestApiDemoo.rest.Controller;

import com.RestApiDemoo.rest.Model.Item;
import com.RestApiDemoo.rest.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class ItemController {
    @Autowired
    private ItemService is;

    @GetMapping("/items")
    public List<Item> getItems()
    {
        return is.getItems();
    }

    @GetMapping("/items/{id}")
    public Item getItem(@PathVariable("id") long id){
        return is.getItem(id);
    }

    @DeleteMapping("/items/{id}")
    public Item deleteItem(@PathVariable("id") long id){
        return is.deleteItem(id);
    }

    @PostMapping("/items")
    public Item saveItem(@RequestBody Item item)
    {
        return is.saveItem(item);
    }

    @PutMapping("/items/{id}")
    public Item updateItem(@PathVariable("id") long id,@RequestBody Item item)
    {
        item.setItem_id(id);
        return is.updateItem(item);
    }
}
