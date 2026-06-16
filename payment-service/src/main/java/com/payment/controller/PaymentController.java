package com.payment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.entity.Payment;
import com.payment.service.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	@GetMapping
	public ResponseEntity<List<Payment>> getPayments()
	{
		return ResponseEntity.ok(paymentService.getAllPayments());
	}
	
	@GetMapping("/{paymentId}")
	public ResponseEntity<Payment> getPaymentByPaymentId(@PathVariable String paymentId)
	{
		return ResponseEntity.ok(paymentService.getSinglePayment(paymentId));
	}
	
	@GetMapping("/orders/{orderId}")
	public ResponseEntity<Payment> getPaymentByOrderId(@PathVariable int orderId)
	{
		return ResponseEntity.ok(paymentService.getPaymentByOrderId(orderId));
	}
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<List<Payment>> getPaymentByUserId(@PathVariable String userId)
	{
		return ResponseEntity.ok(paymentService.getPaymentByUserId(userId));
	}
	
	@PostMapping
	public ResponseEntity<Payment> savePayments(@RequestBody Payment payment)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(paymentService.createPayment(payment));
	}

}
