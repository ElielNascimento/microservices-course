package com.microservicosjava.hrpayroll.services;

import java.io.Serializable;

import org.springframework.stereotype.Service;

import com.microservicosjava.hrpayroll.entities.Payment;

@Service
public class PaymentService implements Serializable {
	private static final long serialVersionUID = 1L;

	public Payment PaymentCont(long workerId, int days) {
		return new Payment("Eliel", 250.00, days);

	}
}
