package com.ankist.expensetracker.service;

import com.ankist.expensetracker.model.ExpenseDTO;
import com.ankist.expensetracker.repository.ExpenseEntity;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ServiceMapper {

    ServiceMapper INSTANCE = Mappers.getMapper(ServiceMapper.class);
    @Named("mapExpenseEntityToDTO")
    ExpenseDTO mapExpenseEntityToDTO(ExpenseEntity expenseEntity);
    ExpenseEntity mapExpenseDtoToEntity(ExpenseDTO expenseDTO);

    @IterableMapping(qualifiedByName = "mapExpenseEntityToDTO")
    List<ExpenseDTO> mapListExpenseEntityToDTO(List<ExpenseEntity> expenseEntities);

}
