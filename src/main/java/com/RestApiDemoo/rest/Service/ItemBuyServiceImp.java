package com.RestApiDemoo.rest.Service;

import com.RestApiDemoo.rest.Controller.NewItemController;
import com.RestApiDemoo.rest.Model.Item;
import com.RestApiDemoo.rest.Model.ItemBuy;
import com.RestApiDemoo.rest.Model.NewItem;
import com.RestApiDemoo.rest.repository.ItemBuyRepository;
import com.RestApiDemoo.rest.repository.ItemRepository;
import com.RestApiDemoo.rest.repository.NewItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemBuyServiceImp implements ItemBuyService{

    @Autowired
    private ItemBuyRepository itemBuyRepository;

    @Autowired
    private ItemRepository itrepo;
    @Autowired
    private NewItemRepository nitrepo;
    @Autowired
    private NewItemServiceImp nitserv;

    public List<ItemBuy> getAllItemBuys() {
        return itemBuyRepository.findAll();
    }

    public Optional<ItemBuy> getItemBuyById(long id) {
        return itemBuyRepository.findById(id);
    }

    public ItemBuy saveItemBuy(ItemBuy itemBuy) {
        List<Item> item = itrepo.findAll();
        boolean status = false;
        if(!item.isEmpty()){
            String nameitb = itemBuy.getItemBuyName();
//            System.out.println("nameitb is = "+nameitb);
            for(Item i:item){
                if(nameitb.equals(i.getName())){
                    status = true;
                    break;
                }
            }
            if(!status){
                throw new RuntimeException("The item you are trying to buy is not present in the system please enter it first");
            }
            //till here checking of that item is present or not
            // now below is NewItem object creation and setting its fields and finding its relevent id and setting it
            NewItem n = new NewItem();
            n.setNewitem_name(itemBuy.getItemBuyName());
            n.setNewitem_qty(itemBuy.getItemBuyQty());
            List<NewItem> nitem = nitrepo.findAll();
            if(!nitem.isEmpty()){
                for(NewItem i:nitem){
                    if(nameitb.equals(i.getNewitem_name())){
                        n.setNewitem_id(i.getNewitem_id());
                        break;
                    }
                }
                nitserv.addQty(n);
                return itemBuyRepository.save(itemBuy);
            }

        }
        return null;

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
