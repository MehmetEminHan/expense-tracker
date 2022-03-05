package com.ankist.expensetracker.repository;

import com.ankist.expensetracker.model.ExpenseDTO;
import com.ankist.expensetracker.service.ServiceMapper;
import com.ankist.expensetracker.service.expense.ExpenseCurrency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;


@Repository
public class ExpenseDAO {

    @Autowired
    private ExpenseCrud expenseCrud;

    private ServiceMapper mapper = ServiceMapper.INSTANCE;

    public void saveAnExpense(Double expenseAmount, String currency, String category, String note) {

        ExpenseDTO expenseDTO = new ExpenseDTO();

        expenseDTO.setExpenseAmount(expenseAmount);
        expenseDTO.setCurrency(ExpenseCurrency.chooseCurrency(currency));
        expenseDTO.setCategory(category);
        expenseDTO.setNote(note);

        expenseCrud.save(mapper.mapExpenseDtoToEntity(expenseDTO));


    }
}
