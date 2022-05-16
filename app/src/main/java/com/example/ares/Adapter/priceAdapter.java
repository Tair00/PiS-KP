package com.example.ares.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ares.MainActivity;
import com.example.ares.ProductPage;
import com.example.ares.ProductPageActivity1;
import com.example.ares.R;
import com.example.ares.model.Product;

import java.util.List;

 public class priceAdapter extends RecyclerView.Adapter<priceAdapter.ProductViewHolder> {
     Context context;
     List<Product> products;

     public priceAdapter(Context context, List<Product> products) {
         this.context = context;
         this.products = products;
     }



     @NonNull
     @Override
     public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View productsItems = LayoutInflater.from(context).inflate(R.layout.product_item,parent,false);
        return new priceAdapter.ProductViewHolder(productsItems);
     }

     @Override
     public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        holder.Productbg.setBackgroundColor(Color.parseColor(products.get(position).getColor()));

        int imageId = context.getResources().getIdentifier("ic_" + products.get(position).getImg(),"drawable",context.getPackageName());
        holder.productImage.setImageResource(imageId);
        holder.productTitles.setText(products.get(position).getTitles());
         holder.productStatus.setText(products.get(position).getCharacteristic());
         holder.productPrice.setText(products.get(position).getPrice());


         holder.itemView.setOnClickListener(new View.OnClickListener(){

             @Override
             public void onClick(View view) {

                 Intent intent = new Intent(context, ProductPageActivity1.class);
                intent.putExtra("Productbg",Color.parseColor(products.get(position).getColor()));
                intent.putExtra("productImage",imageId);
                intent.putExtra("productTitles",products.get(position).getTitles());
                 intent.putExtra("productStatus",products.get(position).getCharacteristic());
                 intent.putExtra("productPrice",products.get(position).getPrice());
                 intent.putExtra("productText",products.get(position).getText());
                 intent.putExtra("productid",products.get(position).getId());
                 context.startActivities(new Intent[]{intent});

             }
         });
     }

     @Override
     public int getItemCount() {
         return products.size();
     }

     public static final class ProductViewHolder extends RecyclerView.ViewHolder{
        LinearLayout Productbg;
        ImageView productImage;
        TextView productTitles, productPrice,productStatus;




         public ProductViewHolder(@NonNull View itemView) {
             super(itemView);
             Productbg= itemView.findViewById(R.id.Productbg);

             productImage= itemView.findViewById(R.id.primage);
             productTitles= itemView.findViewById(R.id.productTitles);
             productStatus= itemView.findViewById(R.id.productStatus);
             productPrice= itemView.findViewById(R.id.productPrice);

         }
     }

}
