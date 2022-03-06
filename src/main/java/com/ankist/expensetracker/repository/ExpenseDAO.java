package com.ankist.expensetracker.repository;

import com.ankist.expensetracker.model.ExpenseDTO;
import com.ankist.expensetracker.service.ServiceMapper;
import com.ankist.expensetracker.service.model.ExpenseCurrency;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public class ExpenseDAO {

    @Autowired
    private ExpenseCrud expenseCrud;

    private ServiceMapper mapper = ServiceMapper.INSTANCE;

    //Get by id dao
    public ExpenseDTO getExpenseById(Integer id){
        return mapper.mapExpenseEntityToDTO(expenseCrud.findById(id).get());
    }

    //Get all dao
    public List<ExpenseDTO> getExpenseAll(){
        return mapper.mapListExpenseEntityToDTO(Lists.newArrayList(expenseCrud.findAll()));
    }

    //Delete by id
    public void deleteById(Integer id){
        expenseCrud.deleteById(id);
    }

    //save dao
    public void saveAnExpense(Double expenseAmount, String currency, String category, String note) {

        ExpenseDTO expenseDTO = new ExpenseDTO();

        expenseDTO.setExpenseAmount(expenseAmount);
        expenseDTO.setCurrency(ExpenseCurrency.chooseCurrency(currency));
        expenseDTO.setCategory(category);
        expenseDTO.setNote(note);

        expenseCrud.save(mapper.mapExpenseDtoToEntity(expenseDTO));


    }
}
