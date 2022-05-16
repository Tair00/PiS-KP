package com.example.ares;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.ares.ui.main.ProductPageFragment;

public class ProductPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_page1);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, ProductPageFragment.newInstance())
                    .commitNow();
        }
    }
}