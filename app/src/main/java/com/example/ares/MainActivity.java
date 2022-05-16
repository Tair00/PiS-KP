package com.example.ares;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import com.example.ares.Adapter.CategoryAdapter;
import com.example.ares.Adapter.priceAdapter;
import com.example.ares.model.Category;
import com.example.ares.model.Product;

public class MainActivity extends AppCompatActivity {
    RecyclerView categoryRecycler, ProductRecycler;
    CategoryAdapter categoryAdapter;
    static priceAdapter priceadapter;
    static List<Product> productList = new ArrayList<>();
    static List<Product> fullproductList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(1,"Футбол"));
        categoryList.add(new Category(2,"Фитнес"));
        categoryList.add(new Category(3,"Велоспорт"));
        categoryList.add(new Category(4,"Воркаут"));

        setCategoryRecycler(categoryList);


        productList.add (new Product(1,"popitka","800","Вес от 1кг","#FF6B00","Фитнес гантели","text",1));
        productList.add (new Product(2,"popitka","800","Вес от 1кг","#FF6B00","Фитнес гантели","text",2));
        productList.add (new Product(3,"popitka","800","Вес от 1кг","#FF6B00","Фитнес гантели","text",3));
        productList.add (new Product(4,"popitka","800","Вес от 1кг","#FF6B00","Фитнес гантели","text",4));
        productList.add (new Product(4,"popitka","800","Вес от 1кг","#FF6B00","Фитнес гантели","text",4));
        productList.add (new Product(4,"popitka","800","Вес от 1кг","#FF6B00","Фитнес гантели","text",2));
        productList.add (new Product(4,"popitka","800","Вес от 1кг","#FF6B00","Фитнес гантели","text",1));
        productList.add (new Product(4,"popitka","800","Вес от 1кг","#FF6B00","Фитнес гантели","text",4));

        productList.add (new Product(4,"popitka","800","Вес от 1кг","#FF6B00","Фитнес гантели","text",4));


        fullproductList.addAll(productList);

        setProductRecycler(productList);
    }
    public  void openShoppingCart(View view){
        Intent intent = new Intent(this,OrderPage.class);
        startActivity(intent);
    }

    private void setProductRecycler(List<Product> productList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);

        ProductRecycler = findViewById(R.id.ProductRecycler);

        ProductRecycler.setLayoutManager(layoutManager);


        priceadapter = new priceAdapter(this,productList);
        ProductRecycler.setAdapter(priceadapter);
    }

    private void setCategoryRecycler(List<Category> categoryList) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);

        categoryRecycler = findViewById(R.id.categoryRecycler);

        categoryRecycler.setLayoutManager(layoutManager);


        categoryAdapter = new CategoryAdapter(this, categoryList);
        categoryRecycler.setAdapter(categoryAdapter);
    }

    public static void showProductByCategory(int category){
productList.clear();
productList.addAll(fullproductList);
List<Product> filterProduct = new ArrayList<>();
    for(Product c: productList){
        if(c.getCategory() == category)
            filterProduct.add(c);

    }
    productList.clear();

    productList.addAll(filterProduct);

    priceadapter.notifyDataSetChanged();
    }
}