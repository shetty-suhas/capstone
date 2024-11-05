package com.ust.eventmanagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.eventmanagement.Exceptions.NoBudgetFoundException;
import com.ust.eventmanagement.Model.Budget;
import com.ust.eventmanagement.Service.BudgetService;

@RestController
@RequestMapping("/budget")
public class BudgetController {  
	
	@Autowired
	private BudgetService budgetService;
	
	@GetMapping("/getByUserId/{userId}") 
	public ResponseEntity<Budget> getByUserId(@PathVariable String userId){ 
		try {  
			return budgetService.getBudgetByUserId(userId);
		} 
		catch(NoBudgetFoundException e) { 
			return ResponseEntity.noContent().build();
		}
	} 
	
	@GetMapping("/getById/{id}") 
	public ResponseEntity<Budget> getById(@PathVariable String id){ 
		try {  
			return budgetService.getBudgetById(id);
		} 
		catch(NoBudgetFoundException e) { 
			return ResponseEntity.noContent().build();
		}
	} 
	
	@PostMapping("/addBudget") 
	public ResponseEntity<Budget> addBudget(@RequestBody Budget budget){ 
		return budgetService.addBudget(budget);
	}
}
