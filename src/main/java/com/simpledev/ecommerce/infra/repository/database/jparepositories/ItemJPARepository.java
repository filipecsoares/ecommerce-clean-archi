package com.simpledev.ecommerce.infra.repository.database.jparepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simpledev.ecommerce.infra.repository.database.models.ItemModel;

@Repository
public interface ItemJPARepository extends JpaRepository<ItemModel, Long> {

}
