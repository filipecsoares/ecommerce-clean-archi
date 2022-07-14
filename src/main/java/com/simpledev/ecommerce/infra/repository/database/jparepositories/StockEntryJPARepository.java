package com.simpledev.ecommerce.infra.repository.database.jparepositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simpledev.ecommerce.infra.repository.database.models.StockEntryModel;

@Repository
public interface StockEntryJPARepository extends JpaRepository<StockEntryModel, Long> {

	List<StockEntryModel> findByIdItem(Long idItem);
}
