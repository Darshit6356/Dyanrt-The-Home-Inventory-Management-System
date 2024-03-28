package com.RestApiDemoo.rest.Service;

import com.RestApiDemoo.rest.Model.ItemBuy;

import java.util.List;
import java.util.Optional;

public interface ItemBuyService {
     List<ItemBuy> getAllItemBuys();

     Optional<ItemBuy> getItemBuyById(long id);

     ItemBuy saveItemBuy(ItemBuy itemBuy);

     ItemBuy updateItemBuy(long id, ItemBuy newItemBuy);

     void deleteItemBuy(long id) ;
}
