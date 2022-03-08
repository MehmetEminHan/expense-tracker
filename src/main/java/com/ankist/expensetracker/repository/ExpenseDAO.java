package com.ankist.expensetracker.repository;

import com.ankist.expensetracker.model.ExpenseDTO;
import com.ankist.expensetracker.service.model.mapper.ExpenseMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public class ExpenseDAO {

    @Autowired
    private ExpenseCrud expenseCrud;
    ExpenseMapping expenseMapping= new ExpenseMapping();

    //Get by id dao
    public ExpenseDTO getExpenseById(Integer id){
        return expenseMapping.getById(expenseCrud,id);
    }

    //Get all dao
    public List<ExpenseDTO> getExpenseAll(){
        return expenseMapping.getAll(expenseCrud);
    }

    //Delete by id
    public void deleteById(Integer id){
        expenseCrud.deleteById(id);
    }

    //save dao
    public void saveAnExpense(Double expenseAmount, String currency, String category, String note) {

       expenseMapping.save(expenseCrud,expenseAmount, currency, category, note);

    }
}
