package com.example.vlad.franckformator;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vlad.franckformator.data.Spending;
import com.example.vlad.franckformator.data.SpendingType;
import com.example.vlad.franckformator.storage.DatabaseStorage;
import com.example.vlad.franckformator.storage.Storage;

public class SpendingActivity extends AppCompatActivity implements View.OnClickListener {

    private DrawerLayout mDrawerLayout;
    private SpendingType selectedType;
    Button btnProducts;
    Button btnLeisure;
    Button btnLunch;
    Button btnClothes;
    Button btnFun;
    Button btnSport;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spending);
        mDrawerLayout = findViewById(R.id.drawer_layout);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnProducts = findViewById(R.id.buttonProducts);
        btnLeisure = findViewById(R.id.buttonLeisure);
        btnLunch = findViewById(R.id.buttonLunch);
        btnClothes = findViewById(R.id.buttonClothes);
        btnFun = findViewById(R.id.buttonFun);
        btnSport = findViewById(R.id.buttonSport);
        btnProducts.setOnClickListener(this);
        btnLeisure.setOnClickListener(this);
        btnLunch.setOnClickListener(this);
        btnClothes.setOnClickListener(this);
        btnFun.setOnClickListener(this);
        btnSport.setOnClickListener(this);

        selectedType = SpendingType.PRODUCTS;
        selectBorderedButton();
        //select Products button;
        final Storage storage = new DatabaseStorage(SpendingActivity.this);

        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            actionbar.setDisplayHomeAsUpEnabled(true);
            actionbar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
        }

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        mDrawerLayout.closeDrawers();
                        Intent intent;
                        switch (menuItem.getItemId()) {

                            case R.id.education:
                                intent = new Intent(SpendingActivity.this, QuotesActivity.class);
                                startActivity(intent);
                                break;
                            case R.id.statistics:
                                intent = new Intent(SpendingActivity.this, PieChartActivity.class);
                                startActivity(intent);
                                break;
                        }
                        return true;
                    }
                });


        final Button buttonSave = findViewById(R.id.btnSave);
        final EditText etCost = findViewById(R.id.etCost);
        buttonSave.setEnabled(false);
        etCost.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                boolean isInputCorrect = validateInput(s.toString());
                buttonSave.setEnabled(isInputCorrect);
            }
        });

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String input = etCost.getText().toString();
                boolean isInputCorrect = validateInput(input);
                if (isInputCorrect) {
                    storage.store(new Spending(System.currentTimeMillis(), getSelectedType(), Double.valueOf(input)));
                    Toast.makeText(SpendingActivity.this, "Data is succesfully saved", Toast.LENGTH_LONG).show();
                    etCost.setText("");
                    hideSoftKeyboard();
                }
            }
        });
    }


    private boolean validateInput(String s) {
        return !s.isEmpty();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public SpendingType getSelectedType() {
        return selectedType;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonProducts:
                selectedType = SpendingType.PRODUCTS;
                break;

            case R.id.buttonLeisure:
                selectedType = SpendingType.LEISURE;
                break;

            case R.id.buttonLunch:
                selectedType = SpendingType.LUNCH;
                break;

            case R.id.buttonClothes:
                selectedType = SpendingType.CLOTHES;
                break;

            case R.id.buttonFun:
                selectedType = SpendingType.FUN;
                break;

            case R.id.buttonSport:
                selectedType = SpendingType.SPORT;
                break;

        }
        selectBorderedButton();
    }

    public void selectBorderedButton() {
        //reset border for all buttons
        btnProducts.setBackground(getDrawable(R.drawable.whitewall));
        btnLeisure.setBackground(getDrawable(R.drawable.whitewall));
        btnLunch.setBackground(getDrawable(R.drawable.whitewall));
        btnClothes.setBackground(getDrawable(R.drawable.whitewall));
        btnFun.setBackground(getDrawable(R.drawable.whitewall));
        btnSport.setBackground(getDrawable(R.drawable.whitewall));

        View selectedView;
        switch (selectedType) {
            case FUN:
                selectedView = btnFun;
                break;
            case LEISURE:
                selectedView = btnLeisure;
                break;
            case SPORT:
                selectedView = btnSport;
                break;
            case CLOTHES:
                selectedView = btnClothes;
                break;
            case LUNCH:
                selectedView = btnLunch;
                break;
            case PRODUCTS:
                selectedView = btnProducts;
                break;
            default:
                selectedView = btnProducts;
        }

        selectedView.setBackground(getDrawable(R.drawable.borderedrawable));
    }

    /**
     * Hides the soft keyboard
     */
    public void hideSoftKeyboard() {
        if (getCurrentFocus() != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
    }

// ------------ Code made by Vlad -------------
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_items, menu);
//        return true;
//    }

//    public void onAbout(MenuItem menuItem) {
//        Toast.makeText(this, "education", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//
//        switch (item.getItemId()) {
//
//            case R.id.settings:
//                Toast.makeText(this, "you've choosen settings", Toast.LENGTH_SHORT).show();
//                return true;
//
//            case R.id.about:
//                Toast.makeText(this, "you've choosen education", Toast.LENGTH_SHORT).show();
//                return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

}
