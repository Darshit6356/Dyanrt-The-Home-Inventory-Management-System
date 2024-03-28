package com.RestApiDemoo.rest.Service;

import com.RestApiDemoo.rest.Model.Item;
import com.RestApiDemoo.rest.Model.NewItem;
import com.RestApiDemoo.rest.repository.NewItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class NewItemServiceImp implements NewItemService {

    @Autowired
    private NewItemRepository niRepository;

    public List<NewItem> getNewitem() {
        return niRepository.findAll();
    }

    @Override
    public NewItem getNewitem(Long id) {
        Optional<NewItem> it = niRepository.findById(id);
        if (it.isPresent())
            return it.get();
        throw new RuntimeException("Item with id " + id + " not found.");
    }

    public NewItem saveNewitem(NewItem it) {
        return niRepository.save(it);
    }

    public NewItem deleteNewitem(Long id) {
        Optional<NewItem> it = niRepository.findById(id);
        if (it.isPresent()) {
            niRepository.deleteById(id);
            return it.get();
        }
        throw new RuntimeException("it with id " + id + " is not found");
    }

    @Override
    public NewItem updateNewitem(NewItem it) {
        return niRepository.save(it);
    }

    // both below function is not yet called from controller
    @Override
    public NewItem removeQty(NewItem nit) {
        Optional<NewItem> nie = niRepository.findById(nit.getNewitem_id());
        long presentQty = 0;
        if (nie.isPresent()) {
            presentQty = nie.get().getNewitem_qty();
        }
        long removeQty = nit.getNewitem_qty();
        if(presentQty - removeQty >=0){
            nit.setNewitem_qty(presentQty-removeQty);
//            nit.setNewitem_id(id);
            return niRepository.save(nit);
        }
        else{
            throw new RuntimeException("Not Suffiecient Qauntity in inventory to be remove");
        }
//        nit.setNewitem_qty(presentQty + removeQty);
        //nit.setNewitem_id(id);

    }

    @Override
    public NewItem addQty(NewItem nit) {
        Optional<NewItem> nie = niRepository.findById(nit.getNewitem_id());
        String pname ="";
        long presentQty = 0;
        if (nie.isPresent()) {
            presentQty = nie.get().getNewitem_qty();
            pname=nie.get().getNewitem_name();
        }
        String IncomingName = nit.getNewitem_name();
        if(pname.equals(IncomingName)){
        long addQty = nit.getNewitem_qty();
        nit.setNewitem_qty(presentQty + addQty);
        //nit.setNewitem_id(id);
        return niRepository.save(nit);}
        else{
            throw new RuntimeException("Name of the item is not same which you are trying to add");
        }
    }
}