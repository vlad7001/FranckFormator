package com.example.vlad.franckformator;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class SecondActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spending);
        mDrawerLayout = findViewById(R.id.drawer_layout);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        mDrawerLayout.closeDrawers();
                        switch (menuItem.getItemId()){

                            case R.id.education:
                                Intent intent = new Intent(SecondActivity.this, Main2Activity.class);

                            startActivity(intent);

                        break;

                        }

                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here

                        return true;
                    }
                });


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

// TODO Add navigation drawer layout functionality here! (3 items and show toasts by clicking on items )
// Todo Add validate method for amount input, if invalid input show Toast
// Все управление менюшкой идет из этой активити.
// Todo читать: Как создать ListView из String (если тебе еще нужен Едукейшионал матириал)

