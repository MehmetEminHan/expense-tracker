package com.ankist.expensetracker.controller;

import com.ankist.expensetracker.model.ExpenseDTO;
import com.ankist.expensetracker.service.ExpenseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/expenses")
public class ExpenseController {


    private final ExpenseService expenseService;

    public ExpenseController(final ExpenseService service) {
        this.expenseService = service;
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable("id") Long id){

        return expenseService.find(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity fetchAll(){
        return ResponseEntity.ok(expenseService.fetchAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteExpenseById(@PathVariable("id") Long id){
        expenseService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity save(@RequestBody ExpenseDTO expenseDTO) {
        ExpenseDTO dto = expenseService.save(expenseDTO);
        return ResponseEntity.created(URI.create(dto.getId().toString())).body(dto);
    }
}
