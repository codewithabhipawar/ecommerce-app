package com.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cart.entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, String>{
	Cart findByUserId(String userId);
}
