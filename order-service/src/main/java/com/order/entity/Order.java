package com.order.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "orders")
public class Order {
	
	@Id
	private int orderId;
	private String userId;
	private String cartId;
	private int order_number;
	private String status;
	private Date deliveryDate;
	private double shipping_amount;
	private double total_amount;
	private String payment_status;
	
	@Transient
	private List<Product> products;
	
	@Transient
	private Payment payment;

}
