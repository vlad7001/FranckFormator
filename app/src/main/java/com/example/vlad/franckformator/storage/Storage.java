package com.example.vlad.franckformator.storage;

import com.example.vlad.franckformator.data.Spending;

import java.util.List;

public interface Storage {
    void store(Spending data);

    List<Spending> fetch();

    void clear();
}
