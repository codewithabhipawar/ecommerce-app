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
public class Product {
	
	private String productId;
	private String userId;
	private String productName;
	private double productPrice;
	private String color;
	private int rating;

}
