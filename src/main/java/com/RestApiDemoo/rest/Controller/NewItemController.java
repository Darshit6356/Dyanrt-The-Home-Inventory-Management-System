package com.RestApiDemoo.rest.Controller;

import com.RestApiDemoo.rest.Model.NewItem;
import com.RestApiDemoo.rest.Service.NewItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NewItemController {
    @Autowired
    private NewItemService newis;

    @GetMapping("/newitem")
    public List<NewItem> getNewitem()
    {
        return newis.getNewitem();
    }

    @GetMapping("/newitem/{id}")
    public NewItem getNewitem(@PathVariable("id") long id){
        return newis.getNewitem(id);
    }

    @DeleteMapping("/newitem/{id}")
    public NewItem deleteNewitem(@PathVariable("id") long id){
        return newis.deleteNewitem(id);
    }

    @PostMapping("/newitem")
    public NewItem saveNewitem(@RequestBody NewItem item)
    {
        return newis.saveNewitem(item);
    }

    @PutMapping("/newitem/{id}")
    public NewItem updateNewitem(@PathVariable("id") long id,@RequestBody NewItem newitem)
    {
        newitem.setNewitem_id(id);
        return newis.updateNewitem(newitem);
    }
}
