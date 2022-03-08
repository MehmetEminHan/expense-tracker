package com.ankist.expensetracker.model;

import java.util.Currency;

public class ExpenseCurrency {

    //This method had created for add new currencyCode for next versions!
    public static Currency chooseCurrency(String currencyCode){
        return Currency.getInstance(currencyCode);
    }

}
