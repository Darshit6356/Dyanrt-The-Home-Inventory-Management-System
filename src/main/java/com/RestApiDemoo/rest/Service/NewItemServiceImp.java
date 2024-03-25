package com.RestApiDemoo.rest.Service;

import com.RestApiDemoo.rest.Model.Item;
import com.RestApiDemoo.rest.Model.NewItem;
import com.RestApiDemoo.rest.repository.NewItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class NewItemServiceImp implements NewItemService{

    @Autowired
    private NewItemRepository niRepository;
    public List<NewItem> getNewitem()
    {
        return niRepository.findAll();
    }

    @Override
    public NewItem getNewitem(Long id) {
        Optional<NewItem> it=niRepository.findById(id);
        if(it.isPresent())
            return it.get();
        throw new RuntimeException("Item with id "+id+" not found.");
    }

    public NewItem saveNewitem(NewItem it) {
        return niRepository.save(it);
    }

    public NewItem deleteNewitem(Long id) {
        Optional<NewItem> it=niRepository.findById(id);
        if(it.isPresent())
        {
            niRepository.deleteById(id);
            return it.get();
        }
        throw new RuntimeException("it with id "+id+" is not found");
    }

    @Override
    public NewItem updateNewitem(NewItem it) {
        return niRepository.save(it);
    }
}
