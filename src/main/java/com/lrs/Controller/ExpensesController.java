package com.lrs.Controller;

import com.lrs.Entity.Expenses;
import com.lrs.Service.ExpenseService;
import com.lrs.ServiceImpl.ExpenseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/expenses")
@RestController
@Slf4j
public class ExpensesController {
    private ExpenseService expenseService;
    private ModelMapper modelMapper;
    ExpenseServiceImpl service;
    @Autowired
    public ExpensesController(ExpenseService expenseService,
                           ModelMapper modelMapper,
                           ExpenseServiceImpl service){
        this.expenseService = expenseService;
        this.modelMapper = modelMapper;
        this.service = service;
    }

    // Create
    @PostMapping
    public Expenses create(@RequestBody Expenses status) {
        return service.save(status);
    }

    // Update
    @PutMapping("/{id}")
    public Expenses update(@PathVariable Long id, @RequestBody Expenses status) {
        status.setId(id);
        return service.update(status);
    }

    // Get all
    @GetMapping
    public List<Expenses> getAll() {
        return service.getAll();
    }

    // Get by ID
    @GetMapping("/{id}")
    public Expenses getById(@PathVariable Long id) {
        return service.getById(id);
    }

    // Delete
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }


}
