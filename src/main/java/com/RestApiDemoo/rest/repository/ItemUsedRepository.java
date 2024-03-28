package com.RestApiDemoo.rest.repository;

import com.RestApiDemoo.rest.Model.ItemUsed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemUsedRepository extends JpaRepository<ItemUsed,Long> {
}
