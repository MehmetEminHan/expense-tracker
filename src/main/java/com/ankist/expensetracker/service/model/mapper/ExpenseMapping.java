package com.ankist.expensetracker.service.model.mapper;

import com.ankist.expensetracker.model.ExpenseDTO;
import com.ankist.expensetracker.repository.ExpenseCrud;
import com.ankist.expensetracker.service.ServiceMapper;
import com.ankist.expensetracker.service.model.ExpenseCurrency;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ExpenseMapping {



    private ServiceMapper mapper = ServiceMapper.INSTANCE;



    //Get by id
    public ExpenseDTO getById(ExpenseCrud expenseCrud, Integer id){
        return mapper.mapExpenseEntityToDTO(expenseCrud.findById(id).get());
    }

    //Get all
    public List<ExpenseDTO> getAll(ExpenseCrud expenseCrud){
        return mapper.mapListExpenseEntityToDTO(Lists.newArrayList(expenseCrud.findAll()));
    }

    //Save
    public void save(ExpenseCrud expenseCrud, Double expenseAmount, String currency, String category, String note) {
        ExpenseDTO expenseDTO = new ExpenseDTO();

        expenseDTO.setExpenseAmount(expenseAmount);
        expenseDTO.setCurrency(ExpenseCurrency.chooseCurrency(currency));
        expenseDTO.setCategory(category);
        expenseDTO.setNote(note);

        expenseCrud.save(mapper.mapExpenseDtoToEntity(expenseDTO));
    }

}
