package com.microservicosjava.hrwoker.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservicosjava.hrwoker.entities.Worker;
import com.microservicosjava.hrwoker.repositories.WorkerRepository;


@RefreshScope
@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

	private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);

	@Autowired
	private Environment env;

	@Autowired
	private WorkerRepository workerService;

	@GetMapping(value = "/configs")
	public ResponseEntity<Void> getConfigs() {
		//logger.info("CONFIG = " + testConfig);
		return ResponseEntity.noContent().build();
	}

	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
		List<Worker> list = workerService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	private ResponseEntity<Worker> workerById(@PathVariable Long id) {

		try {
			Thread.sleep(3000L);
		} catch (InterruptedException e) { // TODO
			e.printStackTrace();
		}

		logger.info("PORT =" + env.getProperty("local.server.port"));

		Worker response = workerService.findById(id).get();
		return ResponseEntity.ok(response);

	}
}
