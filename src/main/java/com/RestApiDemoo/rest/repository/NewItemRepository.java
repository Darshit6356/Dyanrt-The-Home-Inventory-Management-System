package com.RestApiDemoo.rest.repository;

import com.RestApiDemoo.rest.Model.Item;
import com.RestApiDemoo.rest.Model.NewItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewItemRepository extends JpaRepository<NewItem,Long> {
}
