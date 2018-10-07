package com.example.vlad.franckformator.storage;

import com.example.vlad.franckformator.data.Spending;
import com.example.vlad.franckformator.data.SpendingType;

import java.util.List;

public interface Storage {
    void store(Spending data);

    List<Spending> fetch();

    List<Spending> fetch(SpendingType type);

    void clear();
}
