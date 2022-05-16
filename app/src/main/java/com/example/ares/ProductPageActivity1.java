package com.example.ares;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ares.model.Order;

public class ProductPageActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_page1);


        ImageView productimage = findViewById(R.id.productImage);
        TextView productOpis = findViewById(R.id.ProductPageOpisanie);
        TextView productvibor1= findViewById(R.id.productPagevibor1);
        TextView productvibor2 = findViewById(R.id.productPagevibor2);
        TextView productvibor3 = findViewById(R.id.productPagevibor3);
        TextView productvibor4 = findViewById(R.id.productPagevibor4);


        productimage.setImageResource(getIntent().getIntExtra("productImage",0));
        productOpis.setText(getIntent().getStringExtra("productOpis"));
        productvibor1.setText(getIntent().getStringExtra("productvibor1"));
        productvibor2.setText(getIntent().getStringExtra("productvibor2"));
        productvibor3.setText(getIntent().getStringExtra("productvibor3"));
        productvibor4.setText(getIntent().getStringExtra("productvibor4"));
    }
    public  void  addToCart(View view) {
int item_id =getIntent().getIntExtra("productId",0);
        Order.items_id.add(item_id);
        Toast.makeText(this,"Добавлено! :)", Toast.LENGTH_LONG).show();
    }
}