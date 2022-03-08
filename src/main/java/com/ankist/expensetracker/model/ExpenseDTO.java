package com.ankist.expensetracker.model;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor

public class ExpenseDTO {

    private Integer id;
    private Double expenseAmount;
    private Date expenseDate;
    private LocalDateTime registerDate;
    private String currency;
    private String category;
    private String note;

}
