package com.ankist.expensetracker.service;

import com.ankist.expensetracker.model.ExpenseDTO;
import com.ankist.expensetracker.repository.ExpenseEntity;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ExpenseMapper {

    ExpenseMapper INSTANCE = Mappers.getMapper(ExpenseMapper.class);
    @Named("mapExpenseEntityToDTO")
    ExpenseDTO mapExpenseEntityToDTO(ExpenseEntity expenseEntity);
    ExpenseEntity mapExpenseDtoToEntity(ExpenseDTO expenseDTO);

    @IterableMapping(qualifiedByName = "mapExpenseEntityToDTO")
    List<ExpenseDTO> mapListExpenseEntityToDTO(List<ExpenseEntity> expenseEntities);

}
