package com.RestApiDemoo.rest.Service;

import com.RestApiDemoo.rest.Controller.NewItemController;
import com.RestApiDemoo.rest.Model.ItemBuy;
import com.RestApiDemoo.rest.Model.NewItem;
import com.RestApiDemoo.rest.repository.ItemBuyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemBuyServiceImp implements ItemBuyService{

    @Autowired
    private ItemBuyRepository itemBuyRepository;

    public List<ItemBuy> getAllItemBuys() {
        return itemBuyRepository.findAll();
    }

    public Optional<ItemBuy> getItemBuyById(long id) {
        return itemBuyRepository.findById(id);
    }

    public ItemBuy saveItemBuy(ItemBuy itemBuy) {
        return itemBuyRepository.save(itemBuy);
    }

    public ItemBuy updateItemBuy(long id, ItemBuy newItemBuy) {
        if (itemBuyRepository.existsById(id)) {
            newItemBuy.setItemBuy_id(id);
            return itemBuyRepository.save(newItemBuy);
        }
        return null; // Or throw an exception if item not found
    }

    public void deleteItemBuy(long id) {
        itemBuyRepository.deleteById(id);
    }
}
