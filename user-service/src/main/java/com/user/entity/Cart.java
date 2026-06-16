package com.user.entity;

import java.util.List;

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
public class Cart {
	
	private String cartId;
	private String userId;
	private String status;
	private double shipping_amount;
	private double total_amount;
//	private List<Product> products;
	

}
