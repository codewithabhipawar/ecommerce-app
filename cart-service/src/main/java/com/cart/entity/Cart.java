package com.cart.entity;



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
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString
@Table(name = "carts")
public class Cart {
	
	@Id
	private String cartId;
	private String userId;
	private String status;
	private double shipping_amount;
	private double total_amount;
	
	@Transient
	private List<Product> products;

}
