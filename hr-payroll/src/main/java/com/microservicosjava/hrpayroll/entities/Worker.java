package com.microservicosjava.hrpayroll.entities;

public class Worker {

	private Long id;
	private String name;
	private Double dailyIncome;

	public Worker() {
		// TODO Auto-generated constructor stub
	}

	public Worker(Long id, String name, Double dailyIncome) {
		this.id = id;
		this.name = name;
		this.dailyIncome = dailyIncome;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getDailyIncome() {
		return dailyIncome;
	}

	public void setDailyIncome(Double dailyIncome) {
		this.dailyIncome = dailyIncome;
	}

	public Long getId() {
		return id;
	}
}
