package com.microservicosjava.hrpayroll.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservicosjava.hrpayroll.entities.Payment;
import com.microservicosjava.hrpayroll.services.PaymentService;

@RestController
@RequestMapping(value = "/api/payment")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	@GetMapping("/{id}/days/{days}")
	private ResponseEntity<Payment> getPayment(@PathVariable Long id, @PathVariable Integer days) {
		Payment response = paymentService.PaymentCont(id, days);
		return ResponseEntity.ok(response);
	}
}
