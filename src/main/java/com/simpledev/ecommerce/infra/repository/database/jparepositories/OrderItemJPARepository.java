package com.simpledev.ecommerce.infra.repository.database.jparepositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simpledev.ecommerce.infra.repository.database.models.OrderItemId;
import com.simpledev.ecommerce.infra.repository.database.models.OrderItemModel;

@Repository
public interface OrderItemJPARepository extends JpaRepository<OrderItemModel, OrderItemId> {

	List<OrderItemModel> findByIdOrder(Long idOrder);
}
