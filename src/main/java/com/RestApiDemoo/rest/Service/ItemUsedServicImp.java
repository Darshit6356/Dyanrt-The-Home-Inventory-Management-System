package com.RestApiDemoo.rest.Service;
import com.RestApiDemoo.rest.Model.Item;
import com.RestApiDemoo.rest.Model.ItemUsed;
import com.RestApiDemoo.rest.Model.NewItem;
import com.RestApiDemoo.rest.repository.ItemRepository;
import com.RestApiDemoo.rest.repository.ItemUsedRepository;
import com.RestApiDemoo.rest.repository.NewItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemUsedServicImp implements ItemUsedService{

    @Autowired
    private ItemUsedRepository itemUsedRepository;
    @Autowired
    private ItemRepository itrepo;
    @Autowired
    private NewItemRepository nitrepo;
    @Autowired
    private NewItemServiceImp nitserv;

    public List<ItemUsed> getAllItemUseds() {
        return itemUsedRepository.findAll();
    }

    public Optional<ItemUsed> getItemUsedById(long id) {
        return itemUsedRepository.findById(id);
    }

    public ItemUsed saveItemUsed(ItemUsed itemUsed) {
        List<Item> item = itrepo.findAll();
        boolean status = false;
        if(!item.isEmpty()){
            String nameitb = itemUsed.getItemUsedName();
//            System.out.println("nameitb is = "+nameitb);
            for(Item i:item){
                if(nameitb.equals(i.getName())){
                    status = true;
                    break;
                }
            }
            if(!status){
                throw new RuntimeException("The item you are trying to used is not present in the system please enter it first");
            }
            //till here checking of that item is present or not
            // now below is NewItem object creation and setting its fields and finding its relevent id and setting it
            NewItem n = new NewItem();
            n.setNewitem_name(itemUsed.getItemUsedName());
            n.setNewitem_qty(itemUsed.getItemUsedQty());
            List<NewItem> nitem = nitrepo.findAll();
            if(!nitem.isEmpty()){
                for(NewItem i:nitem){
                    if(nameitb.equals(i.getNewitem_name())){
                        n.setNewitem_id(i.getNewitem_id());
                        break;
                    }
                }
                nitserv.removeQty(n);
                return itemUsedRepository.save(itemUsed);
            }

        }
        return null;

    }

    public ItemUsed updateItemUsed(long id, ItemUsed itemUsed) {
        if (itemUsedRepository.existsById(id)) {
            itemUsed.setItemUsed_id(id);
            return itemUsedRepository.save(itemUsed);
        } else {
            throw new RuntimeException("ItemUsed with id " + id + " not found");
        }
    }

    public void deleteItemUsed(long id) {
        itemUsedRepository.deleteById(id);
    }


}
