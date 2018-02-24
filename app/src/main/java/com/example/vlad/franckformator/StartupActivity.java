package com.example.vlad.franckformator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.vlad.franckformator.storage.DatabaseStorage;
import com.example.vlad.franckformator.storage.Storage;

public class StartupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Button next = findViewById(R.id.btnNextStep);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(StartupActivity.this, "WE have clicked next Button", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(StartupActivity.this, SpendingActivity.class);
                startActivity(intent);
            }
        });

    }
}
