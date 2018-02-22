package com.example.vlad.franckformator;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

//import android.view.Menu;

//import static com.example.vlad.franckformator.R.menu.menu_items;

public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spending);

    }

   @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        getMenuInflater().inflate(R.menu.menu_items, menu);
        return true;
   }

   public void onAbout(MenuItem menuItem) {

        Toast.makeText(this, "education", Toast.LENGTH_SHORT).show();

   }

   @Override
   public boolean onOptionsItemSelected(MenuItem item) {

       switch (item.getItemId()) {

           case R.id.settings:
               Toast.makeText(this, "you've choosen settings", Toast.LENGTH_SHORT).show();
               return true;

           case R.id.about:
               Toast.makeText(this, "you've choosen education", Toast.LENGTH_SHORT).show();
               return true;
       }

       return super.onOptionsItemSelected(item);
   }
}

// TODO Add navigation drawer layout functionality here! (3 items and show toasts by clicking on items )
// Todo Add validate method for amount input, if invalid input show Toast
// Все управление менюшкой идет из этой активити.
// Todo читать: Как создать ListView из String (если тебе еще нужен Едукейшионал матириал)

