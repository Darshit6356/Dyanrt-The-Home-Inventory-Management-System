package com.RestApiDemoo.rest.Service;

import com.RestApiDemoo.rest.Model.Item;
import com.RestApiDemoo.rest.Model.Item;
import com.RestApiDemoo.rest.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImp implements ItemService{

    @Autowired
    private ItemRepository iRepository;
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
        return iRepository.save(it);
    }

    public Item deleteItem(Long id) {
        Optional<Item> it=iRepository.findById(id);
        if(it.isPresent())
        {
            iRepository.deleteById(id);
            return it.get();
        }
        throw new RuntimeException("it with id "+id+" is not found");
    }

    @Override
    public Item updateItem(Item it) {
        return iRepository.save(it);
    }

}
