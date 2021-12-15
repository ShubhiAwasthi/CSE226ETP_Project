package com.example.shoppingapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppingapp.Models.MainModel;
import com.example.shoppingapp.PlaceOrder_Activity;
import com.example.shoppingapp.R;

import java.util.ArrayList;

public class MainAdapterFemale extends RecyclerView.Adapter<MainAdapterFemale.viewholderF> {

    ArrayList<MainModel> listF;
    Context contextF;

    public MainAdapterFemale(ArrayList<MainModel> listF, Context contextF){
        this.listF = listF;
        this.contextF = contextF;
    }

    @NonNull
    @Override
    public MainAdapterFemale.viewholderF onCreateViewHolder(@NonNull ViewGroup parentF, int viewTypeF) {
        View viewF = LayoutInflater.from(contextF).inflate(R.layout.sample_products_female,parentF,false);
        return new MainAdapterFemale.viewholderF(viewF);
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapterFemale.viewholderF holderF, int positionF) {

        final MainModel model = listF.get(positionF);
        holderF.productImageF.setImageResource(model.getImage());
        holderF.mainNameF.setText(model.getName());
        holderF.priceF.setText(model.getPrice());
        holderF.descriptionF.setText(model.getDescription());

        holderF.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewF) {
                Intent intentF = new Intent(contextF, PlaceOrder_Activity.class);
                intentF.putExtra("image",model.getImage());
                intentF.putExtra("price",model.getPrice());
                intentF.putExtra("desc",model.getDescription());
                intentF.putExtra("name",model.getName());
                intentF.putExtra("type",1);
                contextF.startActivity(intentF);

            }
        });
    }

    @Override
    public int getItemCount() {
        return listF.size();
    }

    public class viewholderF extends RecyclerView.ViewHolder {

        ImageView productImageF;
        TextView mainNameF,priceF,descriptionF;
        public viewholderF(@NonNull View itemViewF) {
            super(itemViewF);

            productImageF = itemViewF.findViewById(R.id.imageViewF);
            mainNameF= itemViewF.findViewById(R.id.p_nameF);
            priceF = itemViewF.findViewById(R.id.priceF);
            descriptionF = itemViewF.findViewById(R.id.descriptionF);
        }
    }
}
