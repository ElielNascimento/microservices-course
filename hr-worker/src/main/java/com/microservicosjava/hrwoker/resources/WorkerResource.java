package com.microservicosjava.hrwoker.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservicosjava.hrwoker.entities.Worker;
import com.microservicosjava.hrwoker.services.WorkerService;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

	@Autowired
	private WorkerService workerService;

	@GetMapping
	private ResponseEntity<List<Worker>> findAll() {
		List<Worker> list = workerService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping("/{id}")
	private ResponseEntity<Worker> workerById(@PathVariable Long id) {
		Worker response = workerService.workedById(id)	;
		return ResponseEntity.ok(response);

	}
}
