package com.example.ares;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.ares.model.Order;
import com.example.ares.model.Product;

import java.util.ArrayList;
import java.util.List;

public class OrderPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_page);


        ListView orders_list = findViewById(R.id.orders_list);
        List<String> productTitles = new ArrayList<>();

        for(Product c : MainActivity.fullproductList){
            if(Order.items_id.contains(c.getId()))
            productTitles.add(c.getTitles());
        }
        orders_list.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Order.items_id.toArray()));
    }
}