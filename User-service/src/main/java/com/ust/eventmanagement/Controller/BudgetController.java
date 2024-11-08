package com.ust.eventmanagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.eventmanagement.Model.Budget;
import com.ust.eventmanagement.Service.BudgetService;

@RestController
@RequestMapping("/budget")
public class BudgetController {  
	
	@Autowired
	private BudgetService budgetService;

    @PostMapping
    public ResponseEntity<Budget> create(@RequestBody Budget budget) {
        return budgetService.create(budget);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Budget> getById(@PathVariable String id) {
        return budgetService.getById(id);
    }

    @GetMapping
    public ResponseEntity<List<Budget>> getAll() {
        return budgetService.getAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Budget> update(@PathVariable String id, @RequestBody Budget budget) {
        return budgetService.update(id, budget);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        return budgetService.delete(id);
    }
    
    @GetMapping("/subevent/{subEventId}")
    public ResponseEntity<Budget> findBySubEventId(@PathVariable String subEventId) {
        return budgetService.findBySubEventId(subEventId);
    }
}

