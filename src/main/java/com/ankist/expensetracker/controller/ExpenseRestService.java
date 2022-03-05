package com.ankist.expensetracker.controller;

import com.ankist.expensetracker.repository.ExpenseDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Date;

@RestController
public class ExpenseRestService {

    @Autowired
    private ExpenseDAO expenseServiceDAO;


    @PostMapping("/saveExpense")
    public ResponseEntity<String> saveExpense(@RequestHeader("expense_amount") Double expenseAmount,
                                              @RequestHeader("currency") String currency,
                                              @RequestHeader("category") String category,
                                              @RequestHeader("note") String note) {

        expenseServiceDAO.saveAnExpense(expenseAmount,currency,category,note);
        return new ResponseEntity<>("Register saved.", HttpStatus.OK);

    }
}
