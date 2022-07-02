package com.simpledev.ecommerce.infra.repository.database.jparepositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.simpledev.ecommerce.infra.repository.database.models.OrderModel;

@Repository
public interface OrderJPARepository extends JpaRepository<OrderModel, Long> {

	List<OrderModel> findByCode(String code);

	@Query(value = "select om.code from OrderModel om")
	List<String> findCodes();
}
