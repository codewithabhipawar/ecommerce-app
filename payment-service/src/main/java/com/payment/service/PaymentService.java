package com.payment.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.entity.Payment;
import com.payment.exception.PaymentNotFoundException;
import com.payment.repository.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;

	// get All payments
	public List<Payment> getAllPayments() {
		return paymentRepository.findAll();
	}

	// get single payment by paymentId
	public Payment getSinglePayment(String paymentId) throws PaymentNotFoundException {
		return paymentRepository.findById(paymentId)
				.orElseThrow(() -> new PaymentNotFoundException("payment not found for this payment id: " + paymentId));
	}

	// get payment by order id
	public Payment getPaymentByOrderId(int orderId) {
		return paymentRepository.findByOrderId(orderId);
	}

	// get payment by user id
	public List<Payment> getPaymentByUserId(String userId) {
		return paymentRepository.findByUserId(userId);
	}

	// create payment
	public Payment createPayment(Payment payment) {
		String paymentId = UUID.randomUUID().toString();
		payment.setPaymentId(paymentId);
		return paymentRepository.save(payment);
	}

}
