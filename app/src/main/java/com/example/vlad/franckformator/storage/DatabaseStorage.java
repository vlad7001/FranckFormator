package com.example.vlad.franckformator.storage;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.vlad.franckformator.R;
import com.example.vlad.franckformator.data.Spending;
import com.example.vlad.franckformator.data.SpendingList;
import com.example.vlad.franckformator.data.SpendingType;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vlad on 17.02.2018.
 */

public class DatabaseStorage implements Storage {


    private static final String STORAGE_KEY = "my_storage";
    private static final String STORAGE_TABLE_KEY = "storage_table_key";

    private Context context;
    private SharedPreferences sharedPref;
    private Gson gson;


    public DatabaseStorage(Context context) {
        this.context = context;
        this.sharedPref = context.getSharedPreferences(STORAGE_KEY, Context.MODE_PRIVATE);
        this.gson = new Gson();

    }

    @Override
    public void store(Spending spending) {
        List<Spending> spendingsList = fetch();
        spendingsList.add(spending);
        SpendingList list = new SpendingList(spendingsList);
        String s = gson.toJson(list);
        storeToAndroidStorage(s);
    }

    @Override
    public List<Spending> fetch() {
        String fetchedData = readFromAndroidStorage();
        if (!fetchedData.equals("")) {
            SpendingList list = gson.fromJson(fetchedData, SpendingList.class);
            return list.getSpendingsList();
        } else return new ArrayList<>();
    }

    @Override
    public void clear() {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.clear();
        editor.apply();
    }


    private void storeToAndroidStorage(String data) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(STORAGE_TABLE_KEY, data);
        editor.apply();
    }


    private String readFromAndroidStorage() {
        return sharedPref.getString(STORAGE_TABLE_KEY, "");
    }

}
