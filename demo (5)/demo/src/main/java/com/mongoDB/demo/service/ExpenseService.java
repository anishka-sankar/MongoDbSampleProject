package com.mongoDB.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongoDB.demo.model.Expense;
import com.mongoDB.demo.repo.ExpenseRepository;

@Service
public class ExpenseService {
	
	@Autowired
	private ExpenseRepository repo;
	
	public void addExpense(Expense expense) {
		repo.insert(expense);
	}
	
	public List<Expense> getAllExpense() {
		return repo.findAll();
	}
	
	public Expense getExpenseByName(String name) {		
		return repo.findByName(name).orElseThrow( () -> new RuntimeException("Expense not found"));
	}
	
	public void updateExpense(Expense expense) {
		Expense exp=repo.findById(expense.getId()).orElseThrow(
				() -> new RuntimeException("Expense cannot be found"));
		exp.setExpenseAmount(expense.getExpenseAmount());
		exp.setExpenseCategory(expense.getExpenseCategory());
		exp.setExpenseName(expense.getExpenseName());
		repo.save(exp);
		
	}
	
	public void deleteExpense(String id) {
		repo.deleteById(id);
	}

}
