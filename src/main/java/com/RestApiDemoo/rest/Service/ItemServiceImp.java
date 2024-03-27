package com.RestApiDemoo.rest.Service;

import com.RestApiDemoo.rest.Model.Item;
import com.RestApiDemoo.rest.Model.Item;
import com.RestApiDemoo.rest.Model.NewItem;
import com.RestApiDemoo.rest.repository.ItemRepository;
import com.RestApiDemoo.rest.repository.NewItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImp implements ItemService {
    @Autowired
    private ItemRepository iRepository;
    @Autowired
    private NewItemRepository niRepository;
    public List<Item> getItems()
    {
        return iRepository.findAll();
    }

    @Override
    public Item getItem(Long id) {
         Optional<Item> it=iRepository.findById(id);
         if(it.isPresent())
             return it.get();
         throw new RuntimeException("Item with id "+id+" not found.");
    }

    public Item saveItem(Item it) {
        NewItem n = new NewItem();
        n.setNewitem_name(it.getName());
        n.setNewitem_qty(0);
        niRepository.save(n);
        return iRepository.save(it);
    }

    public Item deleteItem(Long id) {
        Optional<Item> it=iRepository.findById(id);
        List<NewItem> ni = niRepository.findAll();
        long Iid=0;
        if(it.isPresent())
        {
            String name = it.get().getName();
            for(NewItem n : ni){
                if(n.getNewitem_name().equals(name)){
                    Iid = n.getNewitem_id();
                    break;
                }
            }
            niRepository.deleteById(Iid);
            iRepository.deleteById(id);
            return it.get();
        }
        throw new RuntimeException("it with id "+id+" is not found");
    }

    @Override
    public Item updateItem(Item it) {
        Optional<Item> ite=iRepository.findById(it.getItem_id());
        List<NewItem> ni = niRepository.findAll();
        long Iid=0;
        if(ite.isPresent())
        {
            String name = ite.get().getName();
            for(NewItem n : ni){
                if(n.getNewitem_name().equals(name)){
                    Iid = n.getNewitem_id();
                    break;
                }
            }
            Optional<NewItem> niu = niRepository.findById(Iid);
            if(niu.isPresent()){
                niu.get().setNewitem_name(it.getName());
                niRepository.save(niu.get());
            }
        }
        return iRepository.save(it);
    }

}
