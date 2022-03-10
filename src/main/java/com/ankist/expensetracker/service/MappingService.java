package com.ankist.expensetracker.service;

import com.ankist.expensetracker.model.ExpenseDTO;
import com.ankist.expensetracker.repository.ExpenseEntity;
import org.springframework.stereotype.Service;

@Service
public class MappingService {

    private ExpenseMapper mapper = ExpenseMapper.INSTANCE;

    public ExpenseDTO map(ExpenseEntity entity){
        return mapper.mapExpenseEntityToDTO(entity);
    }

    public ExpenseEntity map(ExpenseDTO dto){
        return mapper.mapExpenseDtoToEntity(dto);
    }
}
