package com.mongoDB.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongoDB.demo.model.Expense;
import com.mongoDB.demo.repo.ExpenseRepository;
import com.mongoDB.demo.service.ExpenseService;

@RestController
@RequestMapping("/expense")
public class ExpenseController {
	
	@Autowired
	private ExpenseService service;
	
	@PostMapping("/add")
	public ResponseEntity addExpense(@RequestBody Expense expense) {
		service.addExpense(expense);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@GetMapping("/get")
	public ResponseEntity getAllExpense() {
		return ResponseEntity.ok(service.getAllExpense());
	}
	
	@GetMapping("/get/{name}")
	public ResponseEntity<Expense> getExpenseByName(@PathVariable String name) {
		return ResponseEntity.ok(service.getExpenseByName(name));
	}
	
	@PutMapping("/update")
	public ResponseEntity updateExpense(@RequestBody Expense expense) {
		service.updateExpense(expense);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity deleteExpense(@PathVariable String id) {
		service.deleteExpense(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		
	}

}
