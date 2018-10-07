package com.example.vlad.franckformator;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vlad.franckformator.data.Spending;
import com.example.vlad.franckformator.data.SpendingType;
import com.example.vlad.franckformator.storage.DatabaseStorage;

import java.util.List;

public class SpendingListActivity extends AppCompatActivity {

    public static final String TAG = "SPENDING_CATEGORY";
    private RecyclerView recyclerView;
    private DatabaseStorage storage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spendings);
        String tag = getIntent().getStringExtra(TAG);
        SpendingType spendingType = null;
        if (!tag.isEmpty()) {
            spendingType = SpendingType.valueOf(tag);
        }
        recyclerView = findViewById(R.id.rvSpendings);

        if (spendingType != null) {
            storage = new DatabaseStorage(SpendingListActivity.this);
            List<Spending> spendings = storage.fetch(spendingType);
            MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(this, spendings);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(adapter);
        }
    }

}
