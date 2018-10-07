package com.example.vlad.franckformator.data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SpendingList {
    private List<Spending> spendingsList;

    public SpendingList(List<Spending> spendingsList) {
        this.spendingsList = spendingsList;
    }

    public List<Spending> getSpendingsList() {
        return spendingsList;
    }

    public List<Spending> getSpendingsList(final SpendingType spendingType) {

        List<Spending> filteredList = new ArrayList<>();
        for (int i = 0; i < spendingsList.size(); i++) {
            if (spendingsList.get(i).type.equals(spendingType))
                filteredList.add(spendingsList.get(i)); // NOTE: Iterator's remove method, not ArrayList's, is used.
        }
        return filteredList;
    }
}
