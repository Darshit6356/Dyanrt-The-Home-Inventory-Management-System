package com.RestApiDemoo.rest.Controller;

import com.RestApiDemoo.rest.Model.Item;
import com.RestApiDemoo.rest.Model.NewItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/shopinglist")
public class ShopingListController {

    @Autowired
    private ItemController itemsController;

    @Autowired
    private NewItemController newItemController;

    @GetMapping
    public List<Item> generateShoppingList() {
        List<Item> items = itemsController.getItems();
        List<NewItem> newItems = newItemController.getNewitem();
        long id=0;
        List<Item> shoppingList = new ArrayList<>();
        for (NewItem newItem : newItems) {
            for (Item item : items) {
                if (newItem.getNewitem_name().equals(item.getName())) {
                    long neededQuantity = Math.max(0, item.getMin_Q() - newItem.getNewitem_qty());
                    if (neededQuantity > 0) {
                        id=id+1;
                        Item shoppingListItem = new Item();
                        shoppingListItem.setItem_id(id);
                        shoppingListItem.setName(item.getName());
                        shoppingListItem.setMin_Q(neededQuantity);
                        shoppingList.add(shoppingListItem);
                    }
                }
            }
        }

        return shoppingList;
    }
}
