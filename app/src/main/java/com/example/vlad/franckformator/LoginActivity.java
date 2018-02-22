package com.example.vlad.franckformator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

    /*   @Override
       protected void onCreate(Bundle savedInstanceState) {
           super.onCreate(savedInstanceState);
           setContentView(R.layout.activity_login);

           //DO the same as button logic for edit text.
           Button nextStep = findViewById(R.id.btnNextStep);

           nextStep.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   //get data from edit texts here and show it with toast
                   editText.getText().toString

                   Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                   startActivity(intent);
               }
           });*/
    private EditText etName;
    private EditText etPassword;
    private TextView tvInfo;
    private Button btnLogin;
    private int counter = 5;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etName = (EditText) findViewById(R.id.editText);
        etPassword = (EditText) findViewById(R.id.editText2);
        tvInfo = (TextView) findViewById(R.id.textHeader);

        btnLogin = (Button) findViewById(R.id.button);

        tvInfo.setText("No of attempts remaining: 5");

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(etName.getText().toString(), etPassword.getText().toString());
            }
        });

    }

    private void validate(String userName, String userPassword) {
        if (userName.equals("Vlad") && userPassword.equals("7001")) {
            Intent intent = new Intent(LoginActivity.this, SecondActivity.class);
            startActivity(intent);
        } else {
            counter--;

            tvInfo.setText("No of attempts remaining: " + String.valueOf(counter));

            if (counter == 0) {
                btnLogin.setEnabled(false);
            }

        }

    }

}
