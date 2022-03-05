package com.ankist.expensetracker.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseCrud extends CrudRepository<ExpenseEntity,Integer> {

}
