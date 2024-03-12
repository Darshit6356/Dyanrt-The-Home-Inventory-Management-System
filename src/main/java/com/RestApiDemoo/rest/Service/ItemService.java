package com.RestApiDemoo.rest.Service;

import com.RestApiDemoo.rest.Model.Item;
import com.RestApiDemoo.rest.Model.Item;

import java.util.List;

public interface ItemService {
    List<Item> getItems();

    Item getItem(Long id);

    Item saveItem(Item it);

    Item deleteItem(Long id);

    Item updateItem(Item it);
}
