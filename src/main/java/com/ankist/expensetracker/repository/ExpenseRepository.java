package com.ankist.expensetracker.repository;

import org.apache.catalina.LifecycleState;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ExpenseRepository extends CrudRepository<ExpenseEntity, Long> {

    List<ExpenseEntity> findAll();
}
