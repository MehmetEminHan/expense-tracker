package com.ankist.expensetracker.service;

import com.ankist.expensetracker.model.ExpenseDTO;
import com.ankist.expensetracker.repository.ExpenseEntity;
import com.ankist.expensetracker.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public record ExpenseService(ExpenseRepository expenseRepository, MappingService mapper) {

    public Optional<ExpenseDTO> find(Long id) {
       return expenseRepository.findById(id)
               .map(mapper::map);
    }

    public List<ExpenseDTO> fetchAll(){
        return expenseRepository.findAll().stream()
                .map(mapper::map)
                .collect(toList());
    }

    public void delete(Long id) {
        expenseRepository.deleteById(id);
    }

    public ExpenseDTO save(ExpenseDTO dto) {
        ExpenseEntity entity = expenseRepository.save(mapper.map(dto));
        return mapper.map(entity);
    }
}
