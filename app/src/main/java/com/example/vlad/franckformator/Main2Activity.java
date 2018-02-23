package com.example.vlad.franckformator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main2Activity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView = (TextView) findViewById(R.id.listView);

        List<String> items = initData();

        int randomValue = random(items.size()-1);
        textView.setText(items.get(randomValue));
    }

    private List<String> initData(){
        List<String> list = new ArrayList<String>();

        list.add("quote1");
        list.add("quote2");
        list.add("quote3");
        list.add("quote4");

        return list;
    }

    int random (int size){
        Random random = new Random();
        return random.nextInt(size);



    }
}
