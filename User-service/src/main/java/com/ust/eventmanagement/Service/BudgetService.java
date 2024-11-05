package com.ust.eventmanagement.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ust.eventmanagement.Model.Budget;
import com.ust.eventmanagement.Repository.BudgetRepository;

@Service
public class BudgetService {

    @Autowired
    private BudgetRepository budgetRepository;

    public ResponseEntity<Budget> create(Budget budget) {
        Budget savedBudget = budgetRepository.save(budget);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBudget);
    }

    public ResponseEntity<Budget> getById(String id) {
        Optional<Budget> budgetOpt = budgetRepository.findById(id);
        return budgetOpt.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    public ResponseEntity<List<Budget>> getAll() {
        List<Budget> budgets = budgetRepository.findAll();
        return ResponseEntity.ok(budgets);
    }

    public ResponseEntity<Budget> update(String id, Budget budget) {
        Optional<Budget> existingBudgetOpt = budgetRepository.findById(id);
        if (existingBudgetOpt.isPresent()) {
            Budget existingBudget = existingBudgetOpt.get();
            existingBudget.setTotalAmount(budget.getTotalAmount());
            existingBudget.setAllocatedAmount(budget.getAllocatedAmount());
            existingBudget.setSpentAmount(budget.getSpentAmount());
            existingBudget.setCategoryAllocations(budget.getCategoryAllocations());
            existingBudget.setSubEventId(budget.getSubEventId());

            Budget updatedBudget = budgetRepository.save(existingBudget);
            return ResponseEntity.ok(updatedBudget);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    public ResponseEntity<Void> delete(String id) {
        Optional<Budget> budgetOpt = budgetRepository.findById(id);
        if (budgetOpt.isPresent()) {
            budgetRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    public ResponseEntity<Budget> findBySubEventId(String subEventId) {
        Optional<Budget> budget = budgetRepository.findBySubEventId(subEventId);
        if (budget.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(budget.get());
    }
}
