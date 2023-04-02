package com.simpledev.ecommerce.infra.repository.database.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "coupon")
public class CouponModel {

	@Id
	private String code;
	private Integer percentage;
	@Column(name = "expire_date")
	private LocalDateTime expireDate;
}
