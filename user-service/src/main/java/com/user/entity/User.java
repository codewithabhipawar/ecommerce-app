package com.user.entity;



import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@jakarta.persistence.Table(name = "users")
public class User {
	
	@Id
	private String userId;
	
	@Column(name = "name", length = 20)
	private String name;
	
	private String email;
	
	private String about;
	
	@Transient
	private Cart cart;
	
	@Transient
	private List<Order> orders;

}
