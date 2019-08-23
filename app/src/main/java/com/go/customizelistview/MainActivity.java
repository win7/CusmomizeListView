package com.go.customizelistview;

import android.content.Intent;
import android.os.Bundle;

import com.go.customizelistview.Utility.CustomAdapter;
import com.go.customizelistview.Utility.Product;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ArrayList<Product> items = new ArrayList<Product>();
        items.add(new Product("A101", "Product 1", "10.0 Kg.", 10, 0, false,"ic_local_mall_black_24dp"));
        items.add(new Product("A102", "Product 2", "20.0 Kg.", 20, 0, false,"ic_local_grocery_store_black_24dp"));
        items.add(new Product("A103", "Product 3", "30.0 Kg.", 30, 0, false,"ic_local_mall_black_24dp"));
        items.add(new Product("A104", "Product 4", "40.0 Kg.", 40, 0, false,"ic_local_grocery_store_black_24dp"));
        items.add(new Product("A105", "Product 5", "50.0 Kg.", 50, 0, false,"ic_local_grocery_store_black_24dp"));

        final ListView lv_packages = findViewById(R.id.listView_packages);
        CustomAdapter adapter_item = new CustomAdapter(this, items);
        lv_packages.setClickable(true);
        lv_packages.setAdapter(adapter_item);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /* Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show(); */
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
