package com.RestApiDemoo.rest.Service;

import com.RestApiDemoo.rest.Model.Item;
import com.RestApiDemoo.rest.Model.NewItem;

import java.util.List;

public interface NewItemService {
    List<NewItem> getNewitem();

    NewItem getNewitem(Long id);

    NewItem saveNewitem(NewItem it);

    NewItem deleteNewitem(Long id);

    NewItem updateNewitem(NewItem it);
}
