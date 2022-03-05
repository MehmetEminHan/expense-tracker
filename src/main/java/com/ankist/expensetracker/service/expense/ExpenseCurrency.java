package com.ankist.expensetracker.service.expense;

public class ExpenseCurrency {

    private static final String TurkishLira = "TL";
    private static final String Dollars = "USD";

    //This method had created for add new currency for next versions!
    public static String chooseCurrency(String currency){

        if (currency.equals(TurkishLira))
            return TurkishLira;
        else if (currency.equals(Dollars))
            return Dollars;
        else
            return "Null";

    }
}
