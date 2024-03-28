package com.RestApiDemoo.rest.Service;

import com.RestApiDemoo.rest.Model.ItemUsed;
import com.RestApiDemoo.rest.repository.ItemUsedRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public interface ItemUsedService {

     List<ItemUsed> getAllItemUseds() ;

     Optional<ItemUsed> getItemUsedById(long id) ;

     ItemUsed saveItemUsed(ItemUsed itemUsed) ;
     ItemUsed updateItemUsed(long id, ItemUsed itemUsed) ;

     void deleteItemUsed(long id) ;
}
