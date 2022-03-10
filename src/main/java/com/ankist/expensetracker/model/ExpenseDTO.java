package com.ankist.expensetracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseDTO {

    private Long id;
    private BigDecimal expenseAmount;
    private Date expenseDate;
    private LocalDateTime registerDate;
    private String currency;
    private String category;
    private String note;

}
