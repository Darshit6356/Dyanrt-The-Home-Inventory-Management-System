package com.RestApiDemoo.rest.repository;

import com.RestApiDemoo.rest.Model.ItemBuy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemBuyRepository extends JpaRepository<ItemBuy,Long> {
}
