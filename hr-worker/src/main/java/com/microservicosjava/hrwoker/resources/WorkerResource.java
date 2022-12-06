package com.microservicosjava.hrwoker.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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

	private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);

	@Autowired
	private Environment env;

	@Autowired
	private WorkerService workerService;

	@GetMapping
	private ResponseEntity<List<Worker>> findAll() {
		List<Worker> list = workerService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping("/{id}")
	private ResponseEntity<Worker> workerById(@PathVariable Long id) {

		/*
		 * int x = 1; if(x == 1) throw new RuntimeException("test");
		 */

		/*
		 * try { Thread.sleep(3000L); } catch (InterruptedException e) { // TODO
		 * Auto-generated cath block e.printStackTrace(); }
		 * 
		 */

		logger.info("PORT =" + env.getProperty("local.server.port"));

		Worker response = workerService.workedById(id);
		return ResponseEntity.ok(response);

	}
}
