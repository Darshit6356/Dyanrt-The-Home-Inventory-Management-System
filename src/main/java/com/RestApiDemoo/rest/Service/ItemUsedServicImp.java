package com.RestApiDemoo.rest.Service;
import com.RestApiDemoo.rest.Model.ItemUsed;
import com.RestApiDemoo.rest.repository.ItemUsedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemUsedServicImp implements ItemUsedService{

    @Autowired
    private ItemUsedRepository itemUsedRepository;

    public List<ItemUsed> getAllItemUseds() {
        return itemUsedRepository.findAll();
    }

    public Optional<ItemUsed> getItemUsedById(long id) {
        return itemUsedRepository.findById(id);
    }

    public ItemUsed saveItemUsed(ItemUsed itemUsed) {
        return itemUsedRepository.save(itemUsed);
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
