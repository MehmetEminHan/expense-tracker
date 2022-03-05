package com.ankist.expensetracker.service;

import com.ankist.expensetracker.model.ExpenseDTO;
import com.ankist.expensetracker.repository.ExpenseEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-04T21:10:06-0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class ServiceMapperImpl implements ServiceMapper {

    @Override
    public ExpenseDTO mapExpenseEntityToDTO(ExpenseEntity expenseEntity) {
        if ( expenseEntity == null ) {
            return null;
        }

        ExpenseDTO expenseDTO = new ExpenseDTO();

        expenseDTO.setId( expenseEntity.getId() );
        expenseDTO.setExpenseAmount( expenseEntity.getExpenseAmount() );
        expenseDTO.setExpenseDate( expenseEntity.getExpenseDate() );
        expenseDTO.setRegisterDate( expenseEntity.getRegisterDate() );
        expenseDTO.setCurrency( expenseEntity.getCurrency() );
        expenseDTO.setCategory( expenseEntity.getCategory() );
        expenseDTO.setNote( expenseEntity.getNote() );

        return expenseDTO;
    }

    @Override
    public ExpenseEntity mapExpenseDtoToEntity(ExpenseDTO expenseDTO) {
        if ( expenseDTO == null ) {
            return null;
        }

        ExpenseEntity expenseEntity = new ExpenseEntity();

        expenseEntity.setId( expenseDTO.getId() );
        expenseEntity.setExpenseAmount( expenseDTO.getExpenseAmount() );
        expenseEntity.setExpenseDate( expenseDTO.getExpenseDate() );
        expenseEntity.setRegisterDate( expenseDTO.getRegisterDate() );
        expenseEntity.setCurrency( expenseDTO.getCurrency() );
        expenseEntity.setCategory( expenseDTO.getCategory() );
        expenseEntity.setNote( expenseDTO.getNote() );

        return expenseEntity;
    }
}
