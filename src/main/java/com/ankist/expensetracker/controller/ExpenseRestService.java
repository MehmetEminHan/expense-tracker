package com.ankist.expensetracker.controller;

import com.ankist.expensetracker.model.ExpenseDTO;
import com.ankist.expensetracker.repository.ExpenseDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExpenseRestService {

    @Autowired
    private ExpenseDAO expenseServiceDAO;


    @GetMapping("/getById")
    public ResponseEntity<ExpenseDTO> findById(@RequestParam("id") Integer id){

        return new ResponseEntity<>(expenseServiceDAO.getExpenseById(id),HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ExpenseDTO>> findAll(){
        return new ResponseEntity<>(expenseServiceDAO.getExpenseAll(),HttpStatus.OK);
    }

    @GetMapping("/deleteById")
    public ResponseEntity<String> deleteExpenseById(@RequestParam("id") Integer id){
        expenseServiceDAO.deleteById(id);
        return new ResponseEntity<>("deleted.", HttpStatus.OK);
    }

    @PostMapping("/saveExpense")
    public ResponseEntity<String> saveExpense(@RequestHeader("expenseAmount") Double expenseAmount,
                                              @RequestHeader("currency") String currency,
                                              @RequestHeader("category") String category,
                                              @RequestHeader("note") String note) {

        expenseServiceDAO.saveAnExpense(expenseAmount,currency,category,note);
        return new ResponseEntity<>("Register saved.", HttpStatus.OK);

    }
}
