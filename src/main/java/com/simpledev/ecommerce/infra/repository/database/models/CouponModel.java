package com.simpledev.ecommerce.infra.repository.database.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
