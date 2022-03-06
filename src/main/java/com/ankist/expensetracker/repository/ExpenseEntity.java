package com.ankist.expensetracker.repository;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Table(name = "expense")
@Entity

public class ExpenseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "expense_amount")
    private Double expenseAmount;

    @Column(name = "expense_date")
    private Date expenseDate;

    @Column(name = "register_date")
    private LocalDate registerDate;

    @Column(name = "currency")
    private String currency;

    @Column(name = "category")
    private String category;

    @Column(name = "note")
    private String note;

}
