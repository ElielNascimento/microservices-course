package com.microservicosjava.hrwoker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservicosjava.hrwoker.entities.Worker;
import com.microservicosjava.hrwoker.repositories.WorkerRepository;

@Service
public class WorkerService {

	@Autowired
	WorkerRepository workerRepository;

	public List<Worker> findAll() {
		return workerRepository.findAll();
	}

	public Worker workedById(Long workerId) {
		return workerRepository.findById(workerId).get();
	}
}
