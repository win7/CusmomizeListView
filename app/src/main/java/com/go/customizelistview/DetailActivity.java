package com.go.customizelistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.go.customizelistview.Utility.CustomAdapter;
import com.go.customizelistview.Utility.Product;

public class DetailActivity extends AppCompatActivity {

    TextView tv_detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tv_detail = findViewById(R.id.textView_detail);

        for (int i = 0; i < CustomAdapter.array_list.size(); i++){
            Product product = CustomAdapter.array_list.get(i);
            if(product.getChecked()) {
                tv_detail.setText(tv_detail.getText() + " " + product.getName() + ", " + product.getQuantity() + "\n");
            }
        }
    }
}
