package com.simpledev.ecommerce.infra.repository.database.models;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemId implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idOrder;
	private Long idItem;

}
