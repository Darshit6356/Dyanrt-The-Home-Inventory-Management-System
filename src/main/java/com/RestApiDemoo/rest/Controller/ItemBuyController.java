package com.RestApiDemoo.rest.Controller;

import com.RestApiDemoo.rest.Model.ItemBuy;
import com.RestApiDemoo.rest.Service.ItemBuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/itembuy")
public class ItemBuyController {

    @Autowired
    private ItemBuyService itemBuyService;

    @GetMapping
    public List<ItemBuy> getAllItemBuys() {
//        System.out.println("HEllo");
        return itemBuyService.getAllItemBuys();
    }

    @GetMapping("/{id}")
    public Optional<ItemBuy> getItemBuyById(@PathVariable("id") long id) {
        return itemBuyService.getItemBuyById(id);
    }

    @PostMapping
    public ItemBuy addItemBuy(@RequestBody ItemBuy itemBuy) {
        return itemBuyService.saveItemBuy(itemBuy);
    }

    @PutMapping("/{id}")
    public ItemBuy updateItemBuy(@PathVariable("id") long id, @RequestBody ItemBuy itemBuy) {
        return itemBuyService.updateItemBuy(id, itemBuy);
    }

    @DeleteMapping("/{id}")
    public void deleteItemBuy(@PathVariable("id") long id) {
        itemBuyService.deleteItemBuy(id);
    }
}
