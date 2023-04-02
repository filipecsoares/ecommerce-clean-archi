package com.simpledev.ecommerce.infra.repository.database.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "order_model")
public class OrderModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "coupon_code")
	private String couponCode;
	@Column(name = "coupon_percentage")
	private Integer couponPercentage;
	private String code;
	private String cpf;
	@Column(name = "issue_date")
	private LocalDateTime issueDate;
	private BigDecimal freight;
	private Long sequence;
	private BigDecimal total;
}
