package com.user.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Payment {
	
	private String paymentId;
	private int orderId;
	private String userId;
	private double amount;
	private String paymentStatus;

}
