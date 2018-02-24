package com.example.vlad.franckformator.data;

public class Spending {
    public long date; //Id also
    public SpendingType type;
    public double amount;

    public Spending(long date, SpendingType type, double amount) {
        this.date = date;
        this.type = type;
        this.amount = amount;
    }
}

// Spendings list.


// [
//  { date: 1231243125235
//      type: "Products"
//      amount: 1.2f
//   }
// ,
// {   date: 4234234235
//      type: "Leisure"
//      amount: 5f
//   }
// ]

// leisure , 5, 2.02.2018