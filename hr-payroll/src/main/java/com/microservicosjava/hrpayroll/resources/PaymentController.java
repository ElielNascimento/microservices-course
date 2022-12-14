package com.microservicosjava.hrpayroll.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservicosjava.hrpayroll.entities.Payment;
import com.microservicosjava.hrpayroll.services.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@RestController
@RequestMapping(value = "/payments")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	@HystrixCommand(fallbackMethod = "getPaymentAlternative")
	@GetMapping(value = "/{id}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable Long id, @PathVariable Integer days) {
		Payment response = paymentService.PaymentCont(id, days);
		return ResponseEntity.ok(response);
	}

	public ResponseEntity<Payment> getPaymentAlternative(Long id,  Integer days) {
		Payment payment = new Payment("Brann", 400.0, days);
		return ResponseEntity.ok(payment);
	}
}
