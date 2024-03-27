package com.RestApiDemoo.rest.Controller;

import com.RestApiDemoo.rest.Model.NewItem;
import com.RestApiDemoo.rest.Service.NewItemService;
import com.RestApiDemoo.rest.repository.NewItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class NewItemController {
    @Autowired
    private NewItemService newis;

    @Autowired
    private NewItemRepository newrepo;
    @GetMapping("/newitem")
    public List<NewItem> getNewitem()
    {
        return newis.getNewitem();
    }

    @GetMapping("/newitem/{id}")
    public NewItem getNewitem(@PathVariable("id") long id){
        return newis.getNewitem(id);
    }
    //  it is integrated in Item's service method
//    @DeleteMapping("/newitem/{id}")
//    public NewItem deleteNewitem(@PathVariable("id") long id){
//        return newis.deleteNewitem(id);
//    }
//
//    @PostMapping("/newitem")
//    public NewItem saveNewitem(@RequestBody NewItem item)
//    {
//        return newis.saveNewitem(item);
//    }

    @PutMapping("/newitem/add/{id}")
    public NewItem addQtyNewItem(@PathVariable("id") long id,@RequestBody NewItem newitem)
    {
        newitem.setNewitem_id(id);
        return newis.addQty(newitem);
    }

    @PatchMapping("/newitem/remove/{id}")
    public NewItem removeQtyNewItem(@PathVariable("id") long id,@RequestBody NewItem newitem)
    {
//        Optional<NewItem> ni = newrepo.findById(id);
//        long presentQty=0;
//        if (ni.isPresent()) {
//            presentQty = ni.get().getNewitem_qty();
//        }
//        long removeQty = newitem.getNewitem_qty();
//        if(presentQty - removeQty >=0){
//            newitem.setNewitem_qty(presentQty-removeQty);
//            newitem.setNewitem_id(id);
//            return newis.updateNewitem(newitem);
//        }
//        else{
//            throw new RuntimeException("Not Suffiecient Qauntity in inventory to be remove");
//        }
        newitem.setNewitem_id(id);
        return newis.removeQty(newitem);
    }
}
