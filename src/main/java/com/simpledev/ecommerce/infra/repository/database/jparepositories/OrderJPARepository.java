package com.simpledev.ecommerce.infra.repository.database.jparepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simpledev.ecommerce.infra.repository.database.models.OrderModel;

@Repository
public interface OrderJPARepository extends JpaRepository<OrderModel, Long> {

}
