package com.RestApiDemoo.rest.Controller;
import com.RestApiDemoo.rest.Model.ItemUsed;
import com.RestApiDemoo.rest.Service.ItemUsedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/itemused")
public class ItemUsedController {

    @Autowired
    private ItemUsedService itemUsedService;

    @GetMapping
    public List<ItemUsed> getAllItemUseds() {
        return itemUsedService.getAllItemUseds();
    }

    @GetMapping("/{id}")
    public Optional<ItemUsed> getItemUsedById(@PathVariable("id") long id) {
        return itemUsedService.getItemUsedById(id);
    }

    @PostMapping
    public ItemUsed addItemUsed(@RequestBody ItemUsed itemUsed) {
        System.out.println("Hello123123");
        return itemUsedService.saveItemUsed(itemUsed);
    }

    @PutMapping("/{id}")
    public ItemUsed updateItemUsed(@PathVariable("id") long id, @RequestBody ItemUsed itemUsed) {
        return itemUsedService.updateItemUsed(id, itemUsed);
    }

    @DeleteMapping("/{id}")
    public void deleteItemUsed(@PathVariable("id") long id) {
        itemUsedService.deleteItemUsed(id);
    }


}
