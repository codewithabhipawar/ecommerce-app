package com.user.entity;

import java.util.Date;

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
public class Order {
	
	private int orderId;
	private String userId;
	private String cartId;
	private int order_number;
	private String status;
	private Date deliveryDate;
	private double shipping_amount;
	private double total_amount;
	private String payment_status;

}
