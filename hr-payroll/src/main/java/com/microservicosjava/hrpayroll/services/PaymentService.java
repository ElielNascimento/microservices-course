package com.microservicosjava.hrpayroll.services;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservicosjava.hrpayroll.entities.Payment;
import com.microservicosjava.hrpayroll.entities.Worker;
import com.microservicosjava.hrpayroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Autowired
	private WorkerFeignClient workerFeignClient;

	public Payment PaymentCont(long workerId, int days) {

		Worker worker = workerFeignClient.workerById(workerId).getBody();
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}
