package com.example.vlad.franckformator.data;

import java.util.List;

public class SpendingList {
    private List<Spending> spendingsList;

    public SpendingList(List<Spending> spendingsList) {
        this.spendingsList = spendingsList;
    }

    public List<Spending> getSpendingsList() {
        return spendingsList;
    }
}
